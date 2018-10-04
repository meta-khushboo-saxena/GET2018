window.onload=function(){

	for (i = 0; i < localStorage.length; i++) {

		var container = document.getElementById('container');

		var row = document.createElement("div");
		row.setAttribute('class', 'row');

		var labelDiv = document.createElement("div");
		labelDiv.setAttribute('class', 'label');

		var label = document.createElement("label");
		label.innerHTML = localStorage.key(i);

		var spanDiv = document.createElement("div");
		spanDiv.setAttribute('class', 'content');

		var span = document.createElement("span");
		span.innerHTML = localStorage.getItem(localStorage.key(i));

		labelDiv.appendChild(label);
		spanDiv.appendChild(span);

		row.appendChild(labelDiv);
		row.appendChild(spanDiv);

		container.appendChild(row);

	}
}