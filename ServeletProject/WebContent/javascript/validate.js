/**
 * Function to check all the functions
 * 
 * @returns {Boolean}
 */
function validateAll() {
	var flag = true;
	if (!validateName(document.getElementById('first_name'))) {
		flag = false;
	}
	if (!validateEmail()) {
		flag = false;
	}
	if (!validateAge()) {
		flag = false;
	}
	if (flag == false) {
		alert("Please fill all the details correctly!!");
	}
	return flag;
}

/**
 * Function to validate first name and last name
 * 
 * @param name
 * @returns {Boolean}
 */
function validateName(name) {
	var flag = false;
	if (!(/^[a-zA-Z]{2,}$/.test(name.value))) {

		if (name == document.getElementById('first_name') && name.value != "") {
			name.style.borderColor = "red";
			document.getElementById('validateFirstname').innerHTML = "invalid firstname";
			document.getElementById('validateFirstname').style.color = "red";
		} else if (name == document.getElementById('first_name')
				&& name.value == "") {
			name.style.borderColor = "red";
			document.getElementById('validateFirstname').innerHTML = "enter firstname";
			document.getElementById('validateFirstname').style.color = "red";
		} else if (name == document.getElementById('last_name')
				&& name.value != "") {
			name.style.borderColor = "red";
			document.getElementById('validateLastname').innerHTML = "invalid lastname";
			document.getElementById('validateLastname').style.color = "red";
		} else {
			name.style.borderColor = "";
			document.getElementById('validateLastname').innerHTML = "";
		}
	} else {
		if (name.value == document.getElementById('first_name').value) {
			document.getElementById('validateFirstname').innerHTML = "&#10004;";
			document.getElementById('validateFirstname').style.color = "green";
		} else {
			document.getElementById('validateLastname').innerHTML = "&#10004;";
			document.getElementById('validateLastname').style.color = "green";
		}
		name.style.borderColor = "green";
		flag = true;
	}
	return flag;
}

/**
 * Function to validate email
 * 
 * @returns {Boolean}
 */
function validateEmail() {
	var flag = false;
	var email = document.getElementById('email').value;
	if (!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email))
			&& email != "") {
		document.getElementById('email').style.borderColor = "red";
		document.getElementById('validateEmail').innerHTML = "invalid email";
		document.getElementById('validateEmail').style.color = "red";
	} else if (!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email))
			&& email == "") {
		document.getElementById('email').style.borderColor = "red";
		document.getElementById('validateEmail').innerHTML = "enter email";
		document.getElementById('validateEmail').style.color = "red";
	} else {
		document.getElementById('validateEmail').innerHTML = "&#10004;";
		document.getElementById('validateEmail').style.color = "green";
		document.getElementById('email').style.borderColor = "green";
		flag = true;
	}
	return flag;
}

/**
 * Function to check if the age field is empty or not
 * 
 * @returns {Boolean}
 */
function validateAge() {
	if (document.getElementById('age').value != "") {
		document.getElementById('validateAge').innerHTML = "&#10004;";
		document.getElementById('validateAge').style.color = "green";
		document.getElementById('age').style.borderColor = "green";

		return true;
	}
	document.getElementById('age').style.borderColor = "red";
	document.getElementById('validateAge').innerHTML = "enter age";
	document.getElementById('validateAge').style.color = "red";
	return false;
}
