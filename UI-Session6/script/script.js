window.onload = function () {

/*Javascript for Spline chart */
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
			itemclick: toogleDataSeries
		},
		data: [{
			type: "spline",
			name: "Series A",
			markerType: "circle",
			xValueFormatString: "YYYY",
			color: "blue",
			yValueFormatString: "#,##0",
			dataPoints: [
			{ x: new Date(2015, 10, 7), y: 150 },
			{ x: new Date(2014, 10, 6), y: 50 },
			{ x: new Date(2013, 10, 5), y: 20 },
			{ x: new Date(2012, 10, 4), y: 150 },
			{ x: new Date(2011, 10, 3), y: 20 },
			{ x: new Date(2010, 10, 2), y: 150 },
			{ x: new Date(2009, 10, 1), y: 0 }
			]
		},
		{
			type: "spline",
			name: "Series B",
			color: "pink",
			yValueFormatString: "#,##0",
			dataPoints: [
			{ x: new Date(2015, 10, 7), y: 170 },
			{ x: new Date(2014, 10, 6), y: 150 },
			{ x: new Date(2013, 10, 5), y: 110 },
			{ x: new Date(2012, 10, 4), y: 80 },
			{ x: new Date(2011, 10, 3), y: 50 },
			{ x: new Date(2010, 10, 2), y: 30 },
			{ x: new Date(2009, 10, 1), y: 0 }
			]
		},
		{
			type: "spline",
			name: "Series C",
			color: "green",
			yValueFormatString: "#,##0",
			dataPoints: [
			{ x: new Date(2015, 10, 7), y: 130 },
			{ x: new Date(2014, 10, 6), y: 40 },
			{ x: new Date(2013, 10, 5), y: 150 },
			{ x: new Date(2012, 10, 4), y: 40 },
			{ x: new Date(2011, 10, 3), y: 130 },
			{ x: new Date(2010, 10, 2), y: 50 },
			{ x: new Date(2009, 10, 1), y: 0 }
			]
		}]
	};
	$("#lineChartContainer").CanvasJSChart(options);

	function toogleDataSeries(e){
		if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
			e.dataSeries.visible = false;
		} else{
			e.dataSeries.visible = true;
		}
		e.chart.render();
	}
}