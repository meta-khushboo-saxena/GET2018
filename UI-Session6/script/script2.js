window.onload = function () {

	var dataPoints1 = [];
	var dataPoints2 = [];
	var dataPoints3 = [];

	var options = {
		theme: "light2",
		title:{
			text: "Overview"
		},
		axisX:{
			valueFormatString: "YYYY"
		},
		axisY: {
			minimum: 0
		},
		toolTip:{
			shared:true
		},  
		legend:{
			cursor:"pointer",
			verticalAlign: "bottom",
			horizontalAlign: "left",
			dockInsidePlotArea: true,
		},
		data: [{
			type: "spline",
			name: "Series A",
			markerType: "circle",
			xValueFormatString: "YYYY",
			color: "blue",
			yValueFormatString: "#,##0",
			dataPoints: dataPoints1
		},
		{
			type: "spline",
			name: "Series B",
			color: "pink",
			yValueFormatString: "#,##0",
			dataPoints: dataPoints2
		},
		{
			type: "spline",
			name: "Series C",
			color: "green",
			yValueFormatString: "#,##0",
			dataPoints: dataPoints3
		}]
	};

	function seriesA(data) {
		for (var i = 0; i < data.length; i++) {
			dataPoints1.push({
				x: new Date(data[i].date),
				y: data[i].units
			});
		}
		$("#chartContainer1").CanvasJSChart(options);

	}

	function seriesB(data) {
		for (var i = 0; i < data.length; i++) {
			dataPoints2.push({
				x: new Date(data[i].date),
				y: data[i].units
			});
		}
		$("#chartContainer1").CanvasJSChart(options);

	}

	function seriesC(data) {
		for (var i = 0; i < data.length; i++) {
			dataPoints3.push({
				x: new Date(data[i].date),
				y: data[i].units
			});
		}
		$("#chartContainer1").CanvasJSChart(options);
	}

	$.getJSON("http://localhost:3000/seriesA", seriesA);
	$.getJSON("http://localhost:3000/seriesB", seriesB);
	$.getJSON("http://localhost:3000/seriesC", seriesC);


	/*Javascript for Doughnut chart */
	 var options2 = {
               title: {
                   text: "Revenue By Country",
               },
               data: [{
                   type: "doughnut",
                   innerRadius: "70%",
                   showInLegend: true,
                   sliceOffset:2,
                   startAngle: -140,
                   dataPoints: [
                   {y: 30 ,color: "rgb(99,104,226)"},
                   {y: 12 ,color: "rgb(67,163,237)"},
                   {y: 20 ,color: "rgb(194,197,224)"}

                   ]
               }]
           };
           $("#chartContainer").CanvasJSChart(options2);
           $("#chartContainer").on( 
               function(evt){

                   alert("1");
               }
               );  

}