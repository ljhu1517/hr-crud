$(function(){
	$('#hr-table').DataTable({
		'ajax':{
			'url':'/getAll',
			'dataSrc':''
		},
		"columns": [
			{"data":"firstName"},
			{"data":"lastName"},
			{"data":"email"},
			{"data":"departmentName"},
			{"data":"employeeId"},
			{"data":"managerName"},
			{"data":"editUrl"},
			{"data":"deleteUrl"}
		]
	});
}); 