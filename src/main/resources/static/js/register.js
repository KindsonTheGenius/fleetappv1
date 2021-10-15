
$('document').ready(function(){			
	var password = document.getElementById("password")
	var confirmPassword = document.getElementById("confirmPassword");
	
	function validatePassword(){
	  if(password.value != confirmPassword.value) {
	    confirmPassword.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirmPassword.setCustomValidity('');
	  }
	}	
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;		
});

//$('#password').on('change', function(event){
//	
//});
//
//$('#confirmPassword').on('keyup', function(event){
//
//});