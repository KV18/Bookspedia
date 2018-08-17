$(function() {
	switch (menu) {
	
	case 'Home':
		$('#nav_home').addClass('active');
		break;
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
		$('#nav_bookList').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

});