package com.test.csvimport.background.task;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.test.csvimport.constants.CSVDataImportPortletKeys;

/**
 * @author Rana
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + CSVDataImportPortletKeys.CSVDataImport 
		}, service = UserNotificationHandler.class)
public class CustomUserNotificationHandler extends BaseUserNotificationHandler {

	/**
	 * 
	 */
	public CustomUserNotificationHandler() {
		setPortletId(CSVDataImportPortletKeys.CSVDataImport);
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.notifications.BaseUserNotificationHandler#getBody(com.liferay.portal.kernel.model.UserNotificationEvent, com.liferay.portal.kernel.service.ServiceContext)
	 */
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		// long userId = jsonObject.getLong("userId");
		String notificationBody = jsonObject.getString("notificationBody");
		String notificationTitle = "<strong>" + jsonObject.getString("notificationTitle") + "</strong>";
		String body = StringUtil.replace(getBodyTemplate(), new String[] { "[$TITLE$]", "[$BODY_TEXT$]" },
				new String[] { notificationTitle, notificationBody });
		return body;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.notifications.BaseUserNotificationHandler#getBodyTemplate()
	 */
	@Override
	protected String getBodyTemplate() throws Exception {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$BODY_TEXT$]</div>");
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.notifications.BaseUserNotificationHandler#getLink(com.liferay.portal.kernel.model.UserNotificationEvent, com.liferay.portal.kernel.service.ServiceContext)
	 */
	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String pageLink = jsonObject.getString("pageLink");
		return pageLink;
	}

}
