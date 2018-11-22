<%@ include file="/jsp/init.jsp" %>

<liferay-ui:error key="entryNotFound"
				message="the-entry-could-not-be-found" />
<liferay-ui:error key="noPermissions"
				message="you-do-not-have-the-required-permissions" />

<liferay-ui:search-container emptyResultsMessage="no-import-processes-were-found">
	<liferay-ui:search-container-results>

		<%
		List<BackgroundTask> backgroundTasks = BackgroundTaskLocalServiceUtil.getBackgroundTasks(CustomBackgroundTaskExecutor.class.getName(), BackgroundTaskConstants.STATUS_IN_PROGRESS);
		searchContainer.setResults(backgroundTasks);
		searchContainer.setTotal(backgroundTasks.size());
		%>

	</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.liferay.portal.background.task.model.BackgroundTask"
			keyProperty="backgroundTaskId"
			modelVar="backgroundTask"
		>
			<liferay-ui:search-container-column-jsp
				cssClass="background-task-status-column"
				name="status"
				path="/jsp/publish_process_message.jsp"
			/>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
