package com.test.csvimport.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageTranslator;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Rana
 *
 */
public class GoodsImportBackgroundTaskStatusMessageTranslator implements BackgroundTaskStatusMessageTranslator {
	@Override
	public void translate(BackgroundTaskStatus backgroundTaskStatus, Message message) {
		backgroundTaskStatus.setAttribute("backgroundTaskId", message.getLong("backgroundTaskId"));
		backgroundTaskStatus.setAttribute("dataImported", message.getLong("dataImported"));
		backgroundTaskStatus.setAttribute("totalData", message.getLong("totalData"));
		backgroundTaskStatus.setAttribute("fileName", message.getString("fileName"));
	}
}