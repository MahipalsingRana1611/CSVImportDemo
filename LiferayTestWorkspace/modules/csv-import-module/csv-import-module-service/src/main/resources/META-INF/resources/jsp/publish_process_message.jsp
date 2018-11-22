<%@ include file="/jsp/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
BackgroundTask backgroundTask = (BackgroundTask)row.getObject();
%>

<c:if test="<%= backgroundTask.isInProgress() %>">
	<%
	BackgroundTaskStatus backgroundTaskStatus = BackgroundTaskStatusRegistryUtil.getBackgroundTaskStatus(backgroundTask.getBackgroundTaskId());
	%>

	<c:if test="<%= backgroundTaskStatus != null %>">
		<%
		double percentage = 100;
		int dataImported = GetterUtil.getInteger(backgroundTaskStatus.getAttribute("dataImported"));
		int totalData = GetterUtil.getInteger(backgroundTaskStatus.getAttribute("totalData"));
		String fileName = GetterUtil.getString(backgroundTaskStatus.getAttribute("fileName"));
		if (totalData > 0) {
			percentage = Math.round((double)dataImported / totalData * 100);
		}
		%>
		
		<strong class="label background-task-status-<%= BackgroundTaskConstants.getStatusLabel(backgroundTask.getStatus()) %> <%= BackgroundTaskConstants.getStatusCssClass(backgroundTask.getStatus()) %>">
			<liferay-ui:message key="<%= backgroundTask.getStatusLabel() %>" /> <span><%= percentage %>%</span>
		</strong>
		
		<div class="active progress progress-striped">
			<div class="progress-bar" style="width: <%= percentage %>%;">
				<c:if test="<%= totalData > 0 %>">
					<%= dataImported %> / <%= totalData %>
				</c:if>
			</div>
		</div>

		<div class="progress-current-item">
			<strong><liferay-ui:message key="importing" /><%= StringPool.TRIPLE_PERIOD %></strong> <%= HtmlUtil.escape(fileName) %>
		</div>
	</c:if>
</c:if>