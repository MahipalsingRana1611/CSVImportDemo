<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="uploadCSV" var="actionURL" />
<portlet:resourceURL var="getGoodsData" >
	<portlet:param name="<%= Constants.CMD %>" value="getGoodsData" />
</portlet:resourceURL>
<div class="hide" id="getGoodsData">${getGoodsData}</div>
<div class="hide" id="portletNamespace"><portlet:namespace/></div>
<liferay-ui:error key="something-went-wrong" message="something-went-wrong" />
<liferay-ui:error key="error-csv-not-found" message="error-csv-not-found" />
<liferay-ui:error key="error-invalid-csv" message="error-invalid-csv" />
<liferay-ui:success key="file-upload-success" message="file-upload-success" />

<div class="file-upload-button">
	<input type="button" onClick="openModal('fileUploadModal')" class="btn btn-primary" value="Upload File" />
</div>
<div id="modalRenderer"></div>
<div class="hide" id="fileUploadModal">
	<aui:form action="<%=actionURL%>" enctype="multipart/form-data" method="post">
	    <aui:row>
	        <aui:col><aui:input type="file" inlineLabel="left" label="upload-file" name="csvFileUpload" id="csvFileUpload" accept=".csv" size="1" /></aui:col>
	    </aui:row>
	    <aui:button-row>          
	    	<aui:button type="submit" value="upload" name="upload" cssClass="topSpace"/>
	    </aui:button-row>
	</aui:form>
</div>

<div class="process-list" id="<portlet:namespace />importProcesses">
	<liferay-util:include page="/jsp/import_csv_processes.jsp"
		servletContext="<%=application%>" />
</div>

<div class="goods-title"><center><strong>Goods Data</strong></center></div>
<aui:row>
	<aui:col>
		<table id="<portlet:namespace/>goods-data-table"></table>
	</aui:col>
</aui:row>

<aui:script use="liferay-csv-import">
	<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" var="importProcessesURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.IMPORT %>" />
	</liferay-portlet:resourceURL>

	new Liferay.CSVImport(
		{
			form: document.<portlet:namespace />fm1,
			incompleteProcessMessageNode: '#<portlet:namespace />incompleteProcessMessage',
			namespace: '<portlet:namespace />',
			processesNode: '#importProcesses',
			processesResourceURL: '<%= importProcessesURL.toString() %>'
		}
	);
</aui:script>