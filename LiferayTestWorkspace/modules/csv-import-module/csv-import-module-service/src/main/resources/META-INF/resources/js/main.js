var portletNamespace = $('#portletNamespace').text();

//Datatable for display the goods data
$("#"+portletNamespace+"goods-data-table").DataTable({
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