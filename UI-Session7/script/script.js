
var errorMap = new Map();
window.onload=function(){
	var formSubmit = document.getElementById('form');

	if ( window.addEventListener ) { 
		formSubmit.addEventListener('submit', validateAll);
	}

	document.getElementById('first_name').addEventListener('focusout', checkFirstName);
	document.getElementById('last_name').addEventListener('focusout', checkLastName);
	document.getElementById('email').addEventListener('focusout', checkEmail);
	document.getElementById('phone').addEventListener('focusout', checkPhone);
	document.getElementById('address').addEventListener('focusout', checkAddress);
	document.getElementById('city').addEventListener('focusout', checkCity);
	document.getElementById('state').addEventListener('focusout', checkState);
	document.getElementById('state').addEventListener('change', changeState);
}

function deleteEntry(key){
	if(errorMap.has(key)) {
		errorMap.delete(key);
	}
}

function validateAll(event){

	var form = document.getElementById('form_container');

	if(form.contains(document.getElementById("zipcode_container"))) {
		checkZipcode(event);
	}
	if(form.contains(document.getElementById("project_container"))) {
		checkDescription(event);
	}
	if(form.contains(document.getElementById("domain_container"))) {
		checkDomain(event);
	}

	checkFirstName(event);
	checkEmail(event);
	checkPhone(event);
	checkCity(event);
	checkAddress(event);
	checkState(event);
	
	var message = "";
	if(errorMap.size > 0){
		var allkeys = errorMap.keys();
		for(var key of allkeys) {
			message +=  key + " - " + errorMap.get(key) + "\n";
		}
		alert(message);
	}else {
		localStorage.clear();
		for(var i=0;i<document.getElementById("form").elements.length;i++){
			if(document.getElementById("form").elements[i].value.length != 0){
				localStorage.setItem(document.getElementById("form").elements[i].name,document.getElementById("form").elements[i].value);
			}
		} 
	}
}

function checkFirstName(event) {
	var firstName = document.getElementById('first_name');
	if(firstName.value == ""){
		errorMap.set("FirstName", "First Name is required");
		firstName.style.borderColor = "red";
		event.preventDefault();
		
	}else if (!(/^[a-zA-Z]{2,}$/.test(firstName.value))) {
		errorMap.set("FirstName", "First Name is invalid");
		firstName.style.borderColor = "red";
		event.preventDefault();
	} else{
		deleteEntry("FirstName");
		firstName.style.borderColor = "green";
	}
}

function checkLastName(event) {

	var lastName = document.getElementById('last_name');

	if (!(/^[a-zA-Z]{2,}$/.test(lastName.value)) && lastName.value != "") {
		lastName.style.borderColor = "red";
		errorMap.set("LastName", "LastName is invalid");
		event.preventDefault();
	} else{
		deleteEntry("LastName");
		lastName.style.borderColor = "green";
	}
}

function checkEmail(event){

	var email = document.getElementById('email');

	if(email.value == ""){
		errorMap.set("Email", "Email is required");
		email.style.borderColor = "red";
		event.preventDefault();
	}else if(!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email.value))){
		errorMap.set("Email", "Email is invalid");
		email.style.borderColor = "red";
		event.preventDefault();
	}else{
		deleteEntry("Email");
		email.style.borderColor = "green";
	}
}

function checkPhone(event){
	var phone = document.getElementById('phone');
	if(phone.value == ""){
		errorMap.set("Phone", "Phone is required");
		phone.style.borderColor = "red";
		event.preventDefault();
	}else if(!(/^[0-9]{8,12}$/.test(phone.value))){
		errorMap.set("Phone", "Phone is invalid");
		phone.style.borderColor = "red";
		event.preventDefault();
	}else{
		deleteEntry("Phone");
		phone.style.borderColor = "green";
	}
}

function checkAddress(event){
	var address = document.getElementById('address');
	if(address.value == ""){
		errorMap.set("Address", "Address is required");
		address.style.borderColor = "red";
		event.preventDefault();
	}else{
		deleteEntry("Address");
		address.style.borderColor = "green";
	}
}

function checkCity(event){
	var city = document.getElementById('city');
	if(city.value == ""){
		errorMap.set("City", "City is required");
		city.style.borderColor = "red";
		event.preventDefault();
	}else{
		deleteEntry("City");
		city.style.borderColor = "green";
	}
}

function checkZipcode(event){
	var zipcode = document.getElementById('zipcode');
	if(zipcode.value == ""){
		errorMap.set("Zipcode", "Zipcode is required");
		zipcode.style.borderColor = "red";
		event.preventDefault();
	}else if(!(/^[0-9]{6}$/.test(zipcode.value))){
		errorMap.set("Zipcode", "Zipcode is invalid");
		zipcode.style.borderColor = "red";
		event.preventDefault();
	}else{
		deleteEntry("Zipcode");
		zipcode.style.borderColor = "green";
	}
}

function checkDomain(event){
	var website = document.getElementById('website');
	if(website.value == ""){
		errorMap.set("Website", "Website is required");
		website.style.borderColor = "red";
		event.preventDefault();
	} else {
		deleteEntry("Website");
		website.style.borderColor = "green";
	}
}


function checkDescription(event){
	var description = document.getElementById('description');
	if(description.value == ""){
		errorMap.set("Description", "Description is required");
		description.style.borderColor = "red";
		event.preventDefault();
	} else{
		deleteEntry("Description");
		description.style.borderColor = "green";
	}
}

function checkState(event) {

	var state = document.getElementById('state');

	if (state.value == "") {
		state.style.borderColor = "red";
		errorMap.set("State", "State is required");
		event.preventDefault();
	} else{
		deleteEntry("State");
		state.style.borderColor = "green";
	}
}
