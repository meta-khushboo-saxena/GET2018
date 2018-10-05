window.onload=function(){
	
	var formData = JSON.parse(localStorage.getItem("form_data"));

	for (var index = 0; index < formData.length - 1; index++) {

		var container = document.getElementById('container');

		var row = document.createElement("div");
		row.setAttribute('class', 'row');

		var labelDiv = document.createElement("div");
		labelDiv.setAttribute('class', 'label');

		var label = document.createElement("label");
		label.innerHTML = formData[index].label;

		var spanDiv = document.createElement("div");
		spanDiv.setAttribute('class', 'content');

		var span = document.createElement("span");
		span.innerHTML = formData[index].value;

		labelDiv.appendChild(label);
		spanDiv.appendChild(span);

		row.appendChild(labelDiv);
		row.appendChild(spanDiv);

		container.appendChild(row);

	}
}
