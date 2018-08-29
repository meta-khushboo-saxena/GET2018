function validateAll(){
	var flag = true;
	if(!validateName(document.getElementById('first_name'))){
		flag = false;
	}
	if(!validateName(document.getElementById('last_name'))){
		flag = false;
	}
	if(!validateContact()){
		flag = false;
	}
	if(!validateEmail()){
		flag = false;
	}
	if(!validatePassword()){
		flag = false;
	}
	if(!checkPasswordMatch()){
		flag = false;
	}
	return flag;
}

function validateName(name){
	var flag = false;
	if(!(/^[a-zA-Z]{2,}$/.test(name.value))){
		name.style.borderColor="red";
		 if(name.value == document.getElementById('first_name').value && name.value != ""){
			 document.getElementById('checkfirstname').innerHTML = "invalid firstname";
			 document.getElementById('checkfirstname').style.color = "red";
		 }else if (name.value == document.getElementById('first_name').value && name.value == ""){
			 document.getElementById('checkfirstname').innerHTML = "enter firstname";
			 document.getElementById('checkfirstname').style.color = "red";
		 }else {
			 document.getElementById('checklastname').innerHTML = "invalid lastname";
			 document.getElementById('checklastname').style.color = "red";
		 }
	}else {
		 if(name.value == document.getElementById('first_name').value){
			 document.getElementById('checkfirstname').innerHTML = "&#10004;"; 
			 document.getElementById('checkfirstname').style.color = "green";
		 }else{
			 document.getElementById('checklastname').innerHTML = "&#10004;";
			 document.getElementById('checklastname').style.color = "green";
		 }
		name.style.borderColor="green";		 
		flag = true;
	}
		return flag;
}

function validateContact(){
	var flag = false;
	var contact = document.getElementById('contact').value;
	if(!(/^[0-9]{8,12}$/.test(contact)) && contact != ""){
		document.getElementById('checkcontact').innerHTML = "invalid number";
		document.getElementById('checkcontact').style.color = "red";
		document.getElementById('contact').style.borderColor="red";
	}else if(!(/^[0-9]{8,12}$/.test(contact)) && contact == ""){
		document.getElementById('checkcontact').innerHTML = "enter number";
		document.getElementById('checkcontact').style.color = "red";
		document.getElementById('contact').style.borderColor="red";
	}else{
		document.getElementById('checkcontact').innerHTML = "&#10004;";
		document.getElementById('checkcontact').style.color = "green";
		document.getElementById('contact').style.borderColor="green";
		flag = true;
	}
	return flag;
}
				
function validateEmail() {
	var flag = false;
	var email = document.getElementById('email').value;
	if (!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email)) && email != ""){
			document.getElementById('email').style.borderColor = "red";
			document.getElementById('checkemail').innerHTML = "invalid email";
			document.getElementById('checkemail').style.color = "red";	
		}else if (!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email)) && email == ""){
			document.getElementById('email').style.borderColor = "red";
			document.getElementById('checkemail').innerHTML = "enter email";
			document.getElementById('checkemail').style.color = "red";	
		}else{
			document.getElementById('checkemail').innerHTML = "&#10004;";
			document.getElementById('checkemail').style.color = "green";
			document.getElementById('email').style.borderColor = "green";
			flag = true;
		}
		return flag;
}

 function validatePassword() {
	var flag = false;
	var password = document.getElementById('password').value;
	if (!(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/.test(password)) && password != "") {
	  document.getElementById('checkpassword').innerHTML = "weak";
	  document.getElementById('checkpassword').style.color = "red";
	  document.getElementById('password').style.borderColor="red";
	} else if (!(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/.test(password)) && password == ""){
	  document.getElementById('checkpassword').innerHTML = "enter password";
	  document.getElementById('checkpassword').style.color = "red";
	  document.getElementById('password').style.borderColor="red";
	} else {
	  document.getElementById('password').style.borderColor="green";
	  document.getElementById('checkpassword').innerHTML = "strong";
	  document.getElementById('checkpassword').style.color = "green";
	  flag = true;
	}
	return flag;
}

function checkPasswordMatch() {
	var flag = false;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirm_password').value;
	if(password != ""){
		if (password != confirmPassword){
			document.getElementById('checkconfirmpassword').innerHTML = "&#10006";
			document.getElementById('checkconfirmpassword').style.color = "red";
			document.getElementById('confirm_password').style.borderColor="red";	
		} else {
			document.getElementById('checkconfirmpassword').innerHTML = "&#10004;";
			document.getElementById('checkconfirmpassword').style.color = "green";
			document.getElementById('confirm_password').style.borderColor="green";
			flag = true;
		}
	}
	return flag;
}  
