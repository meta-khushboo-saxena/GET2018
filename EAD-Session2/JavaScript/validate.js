function validateAll(){
    if(validateName(document.getElementById('first_name')) && validateName(document.getElementById('last_name')) && validateContact() && validateEmail() && validatePassword() && checkPasswordMatch()){
		return true;
	}else{
		alert("Please enter all the feild correctly!!");
		return false;	
	}	
}

function validateName(name){
	if(!(/^[a-zA-Z]{2,}$/.test(name.value))){
		name.style.borderColor="red";
		 if(name.value == document.getElementById('first_name').value){
			 document.getElementById('checkfirstname').innerHTML = "*invalid firstname";
			 document.getElementById('checkfirstname').style.color = "red";
		 }else{
			 document.getElementById('checklastname').innerHTML = "*invalid lastname";
			 document.getElementById('checklastname').style.color = "red";
		 }
		return false;
	}else{
		 if(name.value == document.getElementById('first_name').value){
			 document.getElementById('checkfirstname').innerHTML = "&#10004;"; 
			 document.getElementById('checkfirstname').style.color = "green";
		 }else{
			 document.getElementById('checklastname').innerHTML = "&#10004;";
			 document.getElementById('checklastname').style.color = "green";
		 }
		name.style.borderColor="green";		 
		return true;
	}	
}

function validateContact(){
	if(!(/^[0-9]{8,12}$/.test(document.getElementById('contact').value))){
		document.getElementById('checkcontact').innerHTML = "*invalid number";
		document.getElementById('checkcontact').style.color = "red";
		document.getElementById('contact').style.borderColor="red";
		return false;
	}else{
		document.getElementById('checkcontact').innerHTML = "&#10004;";
		document.getElementById('checkcontact').style.color = "green";
		document.getElementById('contact').style.borderColor="green";
		return true;
	}
}
				
function validateEmail() {
 if (!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(document.getElementById('email').value)))
  {
	document.getElementById('email').style.borderColor = "red";
	document.getElementById('checkemail').innerHTML = "*invalid email";
	document.getElementById('checkemail').style.color = "red";
    return false;
	
  }else{
	document.getElementById('checkemail').innerHTML = "&#10004;";
	document.getElementById('checkemail').style.color = "green";
    document.getElementById('email').style.borderColor = "green";
    return true;
}
}

 function validatePassword() {
	 if (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/.test(document.getElementById('password').value))
  {
	  document.getElementById('password').style.borderColor="green";
	  document.getElementById('checkpassword').innerHTML = "strong";
	  document.getElementById('checkpassword').style.color = "green";
		return true;
  } else{
	  document.getElementById('checkpassword').innerHTML = "*weak";
	  document.getElementById('checkpassword').style.color = "red";
	  document.getElementById('password').style.borderColor="red";
    return false;
  }
}

function checkPasswordMatch() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirm_password').value;
    if (password != confirmPassword){
        document.getElementById('checkconfirmpassword').innerHTML = "&#10006";
		document.getElementById('checkconfirmpassword').style.color = "red";
		document.getElementById('confirm_password').style.borderColor="red";	
		return false;
	}
    else{
        document.getElementById('checkconfirmpassword').innerHTML = "&#10004;";
		document.getElementById('checkconfirmpassword').style.color = "green";
		document.getElementById('confirm_password').style.borderColor="green";
		return true;
	}
}  