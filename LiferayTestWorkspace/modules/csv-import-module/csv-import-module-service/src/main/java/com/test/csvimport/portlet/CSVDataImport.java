/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.csvimport.portlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.background.task.model.BackgroundTask;
import com.liferay.portal.background.task.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManager;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.test.csvimport.background.task.CustomBackgroundTaskExecutor;
import com.test.csvimport.constants.CSVDataImportPortletKeys;
import com.test.csvimport.model.Goods;
import com.test.csvimport.model.impl.GoodsImpl;
import com.test.csvimport.service.GoodsLocalServiceUtil;

/**
 * @author Rana
 *
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.development",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.name=" + CSVDataImportPortletKeys.CSVDataImport,
		"com.liferay.portlet.header-portlet-css=/css/datatables.min.css",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/datatables.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name=CSVDataImport" }, service = Portlet.class)
public class CSVDataImport extends MVCPortlet {
	@Reference
	protected BackgroundTaskManager backgroundTaskmanager;
	private static final Log log = LogFactoryUtil.getLog(CSVDataImport.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(
	 * javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		log.debug("Excuting serveResource::" + cmd);
		if (cmd.equals(Constants.IMPORT)) {
			PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
					.getRequestDispatcher("/jsp/import_csv_processes.jsp");
			portletRequestDispatcher.include(resourceRequest, resourceResponse);
		} else {
			// Get goods data
			List<Goods> goodsList = GoodsLocalServiceUtil.getGoodses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("data", goodsList);
			resourceResponse.getWriter().write(object.toJSONString());
		}
	}

	/**
	 * Upload csv file
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void uploadCSV(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		UploadPortletRequest upreq = PortalUtil.getUploadPortletRequest(actionRequest);
		// Get file from the request
		File file = upreq.getFile("csvFileUpload");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<GoodsImpl> goodsDataList;
		try {
			// Parse csv data with considering default separator as comma
			goodsDataList = parseDataFromCSV(file, ',');
		} catch (IOException e1) { // Catch the exception if the file missing or
									// empty
			log.error("IO error::" + e1);
			SessionErrors.add(actionRequest, "error-csv-not-found");
			return;
		} catch (Exception e) { // Catch the exception if csv data file is not
								// valid
			log.error("Error while parse csv::" + e);
			SessionErrors.add(actionRequest, "error-invalid-csv");
			return;
		}
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		// This taskContextMap can be used as transporter to background job
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put("userId", themeDisplay.getUserId());
		taskContextMap.put("notificationTitle", "Data Successfully Imported");
		taskContextMap.put("notificationBody",
				"Data imported successfully for the given csv file <b>" + upreq.getFileName("csvFileUpload") + "</b>");
		taskContextMap.put("goodsDataList", new ArrayList<GoodsImpl>(goodsDataList));
		taskContextMap.put("fileName", upreq.getFileName("csvFileUpload"));
		taskContextMap.put("serviceContext", serviceContext);

		try {
			// Adding the job to liferay background manager
			BackgroundTask backgroundTask = BackgroundTaskLocalServiceUtil.addBackgroundTask(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(), CustomBackgroundTaskExecutor.class.getName(),
					CustomBackgroundTaskExecutor.class.getName(), taskContextMap,
					ServiceContextFactory.getInstance(actionRequest));
			// With returned background object you can check status, id etc.
			actionRequest.setAttribute("backgroundTaskId", backgroundTask.getBackgroundTaskId());
			SessionMessages.add(actionRequest, "file-upload-success");
		} catch (Exception e) {
			log.error("Exception while adding background task.", e);
			SessionErrors.add(actionRequest, "something-went-wrong");
		}
	}

	/**
	 * Parse data from csv file
	 * 
	 * @param source
	 * @param delimiter
	 * @return
	 */
	private static List<GoodsImpl> parseDataFromCSV(File file, char delimiter)
			throws NumberFormatException, IOException, PortletException {
		/**
		 * Reading the CSV File Delimiter is comma Default Quote character is
		 * double quote Start reading from line 1
		 */
		CSVReader csvReader = new CSVReader(new FileReader(file), delimiter, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
		// mapping of columns with their positions
		ColumnPositionMappingStrategy<GoodsImpl> mappingStrategy = new ColumnPositionMappingStrategy<GoodsImpl>();
		// Set mappingStrategy type to Goods Type
		mappingStrategy.setType(GoodsImpl.class);
		// Setting the colums for mappingStrategy
		mappingStrategy.setColumnMapping(new String[] { "name", "description", "length", "height", "nr" });
		// create instance for CsvToBean class
		CsvToBean<GoodsImpl> ctb = new CsvToBean<GoodsImpl>();
		// parsing csvReader(Employee.csv) with mappingStrategy
		return ctb.parse(mappingStrategy, csvReader);
	}
}