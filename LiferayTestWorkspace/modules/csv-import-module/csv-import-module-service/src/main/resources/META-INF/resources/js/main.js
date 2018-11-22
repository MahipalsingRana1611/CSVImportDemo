var portletNamespace = $('#portletNamespace').text();
var reloadDatatable = false;
//Datatable for display the goods data
var datatable = $("#"+portletNamespace+"goods-data-table").DataTable({
	ajax : $("#getGoodsData").text(),
	columns : [
		{
			data: 'name',
			title:'Name'
		},
		{
			data: 'description', 
			title: 'Description'
		},
		{
			data: 'length', 
			title: 'Length',
		},
		{
			data: 'height', 
			title: 'Height',
		},
		{
			data: 'area', 
			title: 'Area',
		},
		{
			data: 'nr', 
			title: 'Nr',
		}
	],
});

/*
 * Method to open modal pop for upload file
 */
function openModal(modelDataId) {
	var content = $("#"+modelDataId).html();
	AUI().use(
	  'aui-modal',
	  function(A) {
	    var modal = new A.Modal(
	      {
	        bodyContent: content,
	        centered: true,
	        headerContent: '<b>CSV File Upload</b>',
	        render: '#modalRenderer',
	        zIndex: 1100,
	        centered: true
	      }
	    ).render();
	  }
	);
}

AUI.add(
		'liferay-csv-import',
		function(A) {
			var Lang = A.Lang;

			var ADate = A.Date;

			var FAILURE_TIMEOUT = 10000;

			var REGEX_LAYOUT_ID = /plid_(\d+)/;

			var RENDER_INTERVAL_IDLE = 120000;

			var RENDER_INTERVAL_IN_PROGRESS = 2000;
			
			var INITIALIZE_INTERVAL = 50;

			var STR_CHECKED = 'checked';

			var STR_CLICK = 'click';

			var STR_EMPTY = '';

			var defaultConfig = {
				setter: '_setNode'
			};

			var CSVImport = A.Component.create(
				{
					ATTRS: {
						form: defaultConfig,
						incompleteProcessMessageNode: defaultConfig,
						processesNode: defaultConfig
					},

					AUGMENTS: [Liferay.PortletBase],

					EXTENDS: A.Base,

					NAME: 'csvimport',

					prototype: {
						initializer: function(config) {
							var instance = this;
							console.log("initializer called");
							instance._processesResourceURL = config.processesResourceURL;

							A.later(INITIALIZE_INTERVAL, instance, instance._renderProcesses);
						},

						_getValue: function(nodeName) {
							var instance = this;

							var value = STR_EMPTY;

							var node = instance.get(nodeName);

							if (node) {
								value = node.val();
							}

							return value;
						},


						_isChecked: function(nodeName) {
							var instance = this;

							var node = instance.get(nodeName);

							return (node && node.attr(STR_CHECKED));
						},

						_reloadForm: function() {
							var instance = this;

							var cmdNode = instance.byId('cmd');

							if (cmdNode) {
								cmdNode.val(STR_EMPTY);

								submitForm(instance.get('form'));
							}
						},

						_renderProcesses: function() {
							var instance = this;

							var processesNode = instance.get('processesNode');

							if (processesNode && instance._processesResourceURL) {
								A.io.request(
									instance._processesResourceURL,
									{
										on: {
											failure: function() {
												new Liferay.Notice(
													{
														closeText: false,
														content: Liferay.Language.get('your-request-failed-to-complete') + '<button type="button" class="close">&times;</button>',
														noticeClass: 'hide',
														timeout: FAILURE_TIMEOUT,
														toggleText: false,
														type: 'warning',
														useAnimation: true
													}
												).show();
											},
											success: function(event, id, obj) {
												processesNode.empty();

												processesNode.plug(A.Plugin.ParseContent);

												processesNode.setContent(this.get('responseData'));

												var renderInterval = RENDER_INTERVAL_IDLE;

												var inProgress = !!processesNode.one('.background-task-status-in-progress');
												
												if (inProgress) {
													renderInterval = RENDER_INTERVAL_IN_PROGRESS;
													reloadDatatable = true;
												} else {
													datatable.ajax.reload();
													reloadDatatable = false;
												}

												instance._updateincompleteProcessMessage(inProgress, processesNode.one('.incomplete-process-message'));

												A.later(renderInterval, instance, instance._renderProcesses);
											}
										}
									}
								);
							}
						},

						_setNode: function(val) {
							var instance = this;

							if (Lang.isString(val)) {
								val = instance.one(val);
							}
							else {
								val = A.one(val);
							}

							return val;
						},

						_updateincompleteProcessMessage: function(inProgress, content) {
							var instance = this;

							var incompleteProcessMessageNode = instance.get('incompleteProcessMessageNode');

							if (incompleteProcessMessageNode) {
								content.show();

								if (inProgress || incompleteProcessMessageNode.hasClass('in-progress')) {
									incompleteProcessMessageNode.setContent(content);

									if (inProgress) {
										incompleteProcessMessageNode.addClass('in-progress');

										incompleteProcessMessageNode.show();
									}
								}
							}
						}
					}
				}
			);

			Liferay.CSVImport = CSVImport;
		},
		'',
		{
			requires: ['aui-dialog-iframe-deprecated', 'aui-io-request', 'aui-modal', 'aui-parse-content', 'aui-toggler', 'aui-tree-view', 'liferay-notice', 'liferay-portlet-base', 'liferay-store', 'liferay-util-window']
		}
	);