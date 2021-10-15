/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#txtAddressEdit').val(employee.address);
			$('#txtUsernameEdit').val(employee.username);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#txtFirstnameEdit').val(employee.firstname);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastname);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtMobileEdit').val(employee.mobile);
			$('#txtOthernameEdit').val(employee.othername);		
			$('#txtPhoneEdit').val(employee.phone);			
			$('#fupPhotoEdit').val(employee.photo);			
			$('#txtSSNEdit').val(employee.socialSecurityNumber);			
			$('#ddlStateEdit').val(employee.stateid);	
			$('#ddlTitleEdit').val(employee.title);			
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#idDetails').val(employee.id);
			$('#descriptionDetails').val(employee.description);
			$('#detailsDetails').val(employee.details);
			$('#lastModifiedByDetails').val(employee.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();		
	});	
	
	$('#uploadButton').on('click',function(event){
		var href = $(this).attr('href');
		
		$.post(href, function(data, status){
			console.log(data);
		});
	});	
		
});




//function fcnUpload(url){
//	console.log("Upload button was clicked");
//	//var href = $(this).attr('href');
//	var href = url;
//	console.log("End point of upload: " + href);
//	$.post(href, function(data, status){
//		console.log(data);
//	});
//}
