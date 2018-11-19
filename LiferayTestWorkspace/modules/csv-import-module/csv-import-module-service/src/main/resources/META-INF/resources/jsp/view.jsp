<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="uploadCSV" var="actionURL" />
<portlet:resourceURL var="getGoodsData" />
<div class="hide" id="getGoodsData">${getGoodsData}</div>
<div class="hide" id="portletNamespace"><portlet:namespace/></div>
<liferay-ui:error key="something-went-wrong" message="something-went-wrong" />
<liferay-ui:error key="error-csv-not-found" message="error-csv-not-found" />
<liferay-ui:error key="error-invalid-csv" message="error-invalid-csv" />
<liferay-ui:success key="file-upload-success" message="file-upload-success" />
<div class="upload-button">
	<input type="button" onClick="openModal('fileUploadModal')" class="btn btn-primary file-upload" value="Upload File" />
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
<div class="goods-title"><center><strong>Goods Data</strong></center></div>
<aui:row>
	<aui:col>
		<table id="<portlet:namespace/>goods-data-table"></table>
	</aui:col>
</aui:row>