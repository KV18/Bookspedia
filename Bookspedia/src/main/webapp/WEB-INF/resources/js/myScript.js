$(function() {
	switch (menu) {
	
	case 'About':
		$('#nav_about').addClass('active');
		break;
	
	case 'Contact':
		$('#nav_contact').addClass('active');
		break;
	
	case 'All Products':
		$('#nav_bookList').addClass('active');
		break;
	default :
		if(menu == "Home") break;
		$('#nav_bookList').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	var $table = $('#productListTable');
	
	if($table.length){
		//console.log('Inside the table');
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			
			jsonUrl = window.contextRoot + '/json/data/all/products';
			
		}
		else{
			
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
			
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],['3 records','5 records','10 records','ALL']],
			pageLength:5,
			ajax:{
				
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				
				{
					data:'productCode',
					mRender:function(data, type, row){
						
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				
				{
					data: 'productName'
				},
				{
					data:'brand'
				},
				{
					data:'unitPrice',  
					mRender: function(data, type, row){
						
						return '&#8377;' + data
					}
				},
				{
					data:'quantity',
					mRender: function(data, type, row)
					{
						if(data<1){
							return '<span style="color:red">Out of stock</span>';
						}
						return data;
					}
				},
				{
					data:'productId',
					bSortable:false,
					mRender: function(data, type, row){
						
						var str = '';
						str +='<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><i class="far fa-eye"></i></a> &#160;';
						
						if(row.quantity <1)
							{
							str +='<a href="javascript:void(0)" class="btn btn-success disabled"><i class="fas fa-cart-plus"></i></a>';
							}
						else
							{
							str +='<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><i class="fas fa-cart-plus"></i></a>';
							}
						
						return str;
					}
				}
			]
		});
	}

	
	
});