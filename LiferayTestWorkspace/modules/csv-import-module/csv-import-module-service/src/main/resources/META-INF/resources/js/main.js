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