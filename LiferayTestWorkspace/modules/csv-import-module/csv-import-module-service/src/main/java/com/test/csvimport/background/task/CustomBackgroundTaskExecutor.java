package com.test.csvimport.background.task;

import java.io.Serializable;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Rana
 *
 */
@Component(immediate = true, property = {
		"background.task.executor.class.name=com.inexture.csvimporter.background.task.executor.CustomBackgroundTaskExecutor" 
		}, service = BackgroundTaskExecutor.class)
public class CustomBackgroundTaskExecutor extends BaseBackgroundTaskExecutor {
	public static final Log log = LogFactoryUtil.getLog(CustomBackgroundTaskExecutor.class);

	/**
	 * Override execute method for save data
	 * @param backgroundTask
	 * @return BackgroundTaskResult
	 */
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		// taskContextMap which is sent by the caller
		Map<String, Serializable> taskContextMap = backgroundTask.getTaskContextMap();

		String title = taskContextMap.get("title").toString();
		// TODO business logic for back ground task
		log.info("Executing background task for "+title);
		// Telling the system if, background task is successful or not
		BackgroundTaskResult backgroundTaskResult = new BackgroundTaskResult(BackgroundTaskConstants.STATUS_SUCCESSFUL);
		return backgroundTaskResult;
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
}