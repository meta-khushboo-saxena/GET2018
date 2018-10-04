
function changeState(event){

	var state = document.getElementById('state').value;
	var form = document.getElementById('form_container');
	var hosting =  document.getElementById("hosting_container");
	var zipcode =  document.getElementById("zipcode_container");
	var description =  document.getElementById("project_container");
	var domain =  document.getElementById("domain_container");

	if(form.contains(hosting)) {
		form.removeChild(hosting);
	}
	if(form.contains(zipcode)) {
		form.removeChild(zipcode);
	}
	if(form.contains(description)) {
		form.removeChild(description);
	}
	if(form.contains(domain)) {
		form.removeChild(domain);
	}

	switch(state)
	{
		case "Rajasthan":
		domainAppend();
		projectDescriptionAppend();
		document.getElementById('website').addEventListener('focusout', checkDomain);
		document.getElementById('description').addEventListener('focusout', checkDescription);
		break;
		case "Haryana":
		zipcodeAppend();
		hostingAppend();
		document.getElementById('zipcode').addEventListener('focusout', checkZipcode);
		break;
		case "Maharashtra":
		zipcodeAppend();
		projectDescriptionAppend();
		document.getElementById('zipcode').addEventListener('focusout', checkZipcode);
		document.getElementById('description').addEventListener('focusout', checkDescription);
		break;
	}
}

function domainAppend() {

	var form = document.getElementById('form_container');
	var submitButton  = document.getElementById('submit_container');

	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'domain_container');

	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	var label = document.createElement('label');
	label.innerHTML = "Website or domain name";
	inner_div_label.appendChild(label);

	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-globe-americas";
	inner_div_icon.append(fontAwesome);

	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	var website = document.createElement('input');
	website.setAttribute('type', 'text');
	website.setAttribute('placeholder', 'Website or domain name');
	website.setAttribute('id', 'website');
	website.setAttribute('name', 'website');
	inner_div_content.appendChild(website);

	form.insertBefore(div, submitButton);	    
}

function projectDescriptionAppend() {

	var form = document.getElementById('form_container');
	var submitButton  = document.getElementById('submit_container');

	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'project_container');

	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	var label = document.createElement('label');
	label.innerHTML = "Project Description";
	inner_div_label.appendChild(label);

	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-pen";
	inner_div_icon.append(fontAwesome);

	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	var textarea = document.createElement('textarea');
	textarea.setAttribute('placeholder', 'Project Description');
	textarea.setAttribute('id', 'description');
	textarea.setAttribute('name', 'description');
	inner_div_content.appendChild(textarea);

	form.insertBefore(div, submitButton);	    
}

function zipcodeAppend() {

	var form = document.getElementById('form_container');
	var submitButton  = document.getElementById('submit_container');

	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'zipcode_container');

	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	var label = document.createElement('label');
	label.innerHTML = "Zip Code";
	inner_div_label.appendChild(label);

	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-home";
	inner_div_icon.append(fontAwesome);

	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	var zipcode = document.createElement('input');
	zipcode.setAttribute('type', 'text');
	zipcode.setAttribute('placeholder', 'Zip Code');
	zipcode.setAttribute('id', 'zipcode');
	zipcode.setAttribute('name', 'zipcode');
	inner_div_content.appendChild(zipcode);

	form.insertBefore(div, submitButton);	    
}

function hostingAppend() {

	var form = document.getElementById('form_container');
	var submitButton  = document.getElementById('submit_container');

	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'hosting_container');

	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	var label = document.createElement('label');
	label.innerHTML = "Do you have Hosting?";
	inner_div_label.appendChild(label);

	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	var yes = document.createTextNode("Yes");
	var no = document.createTextNode("No");
	var inputyes = document.createElement("input");
	inputyes.type = "radio";
	inputyes.name = "hosting";
	inputyes.id = "yes";
	inputyes.value = "yes";
	var inputno = document.createElement("input");
	inputno.type = "radio";
	inputno.name = "hosting";
	inputno.id = "no";
	inputno.value = "no";
	inner_div_content.appendChild(inputyes);
	inner_div_content.appendChild(yes);
	inner_div_content.appendChild(inputno);
	inner_div_content.appendChild(no);

	form.insertBefore(div, submitButton);	    
}