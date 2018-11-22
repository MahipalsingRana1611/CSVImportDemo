package com.test.csvimport.background.task;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.test.csvimport.constants.CSVDataImportPortletKeys;
import com.test.csvimport.model.impl.GoodsImpl;
import com.test.csvimport.service.GoodsLocalServiceUtil;

/**
 * @author Rana
 *
 */
@Component(immediate = true, property = {
		"background.task.executor.class.name=com.test.csvimport.background.task.CustomBackgroundTaskExecutor" }, service = BackgroundTaskExecutor.class)
public class CustomBackgroundTaskExecutor extends BaseBackgroundTaskExecutor {
	private static final Log log = LogFactoryUtil.getLog(CustomBackgroundTaskExecutor.class.getName());

	public CustomBackgroundTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(new GoodsImportBackgroundTaskStatusMessageTranslator());
	}

	/**
	 * @param backgroundTask
	 * @return BackgroundTaskResult
	 */
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		// Get context map from the background task to get context data
		Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();
		// Iterate over the list and save data to database
		List<GoodsImpl> goodsDataList = (List<GoodsImpl>) contextMap.get("goodsDataList");
		int goodsImportedCount = 0;
		Message message = new Message();
		for (GoodsImpl goodsData : goodsDataList) {
			GoodsLocalServiceUtil.saveGoods(goodsData);
			goodsImportedCount++;
			// Background task id needs to be passed
			message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());
			message.put("totalData", goodsDataList.size());
			message.put("dataImported", goodsImportedCount);
			message.put("fileName", contextMap.get("fileName"));
			MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		}
		// Generate notification to user for the successful task completion
		generateNotification(Long.valueOf(contextMap.get("userId").toString()),
				contextMap.get("notificationTitle").toString(), contextMap.get("notificationBody").toString(),
				(ServiceContext) contextMap.get("serviceContext"));
		// Get success result of background task
		return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_SUCCESSFUL);
	}

	@Override
	public boolean isSerial() {
		return false;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		return this;
	}

	/**
	 * Generate the notification for completion of the import data task
	 *
	 * @param userId
	 * @param reportTypeText
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void generateNotification(long userId, String notificationTitle, String notificationBody,
			ServiceContext serviceContext) throws PortalException, SystemException {
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put("userId", userId);
		payloadJSON.put("notificationTitle", notificationTitle);
		payloadJSON.put("notificationBody", notificationBody);

		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, CSVDataImportPortletKeys.CSVDataImport,
				new Date().getTime(), UserNotificationDeliveryConstants.TYPE_WEBSITE, userId, payloadJSON.toString(),
				false, serviceContext);
		log.info("Notification generated for successful completion of task");
	}
}