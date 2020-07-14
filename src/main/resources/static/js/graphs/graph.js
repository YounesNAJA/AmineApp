var drawCapitalisationGraph = function(typeCapitalisation, graphTitle, yAxisTitle, xAxisCategories, series) {
    Highcharts.chart(typeCapitalisation, {
        chart: {
            type: 'column',
        },
        title: {
            text: graphTitle
        },
        xAxis: {
            categories: xAxisCategories
        },
        yAxis: {
            title: {
                text: yAxisTitle
            }
        },
        series: series

    });

    $(".highcharts-credits").hide();
}

$("#capiAnnuelleForm").submit(function(e){
    $.get("graph/cap-annuelle", {
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val()
    })
        .done(function(data) {
            drawCapitalisationGraph('capitalisationAnnuelle', data.graphTitle, data.yAxisTitle, data.xAxisCategories, data.graphSeries);
        });
    e.preventDefault();
});

$("#capiMensuelleForm").submit(function(e){
    $.get("graph/cap-mensuelle", {
        startDate: $("#startDateM").val(),
        endDate: $("#endDateM").val()
    })
        .done(function(data) {
            drawCapitalisationGraph('capitalisationMensuelle', data.graphTitle, data.yAxisTitle, data.xAxisCategories, data.graphSeries);
        });
    e.preventDefault();
});

$("#capiAnnuelleForm").submit();
$("#capiMensuelleForm").submit();


// TODO à supprimer après
Highcharts.chart('containervaleur', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Catégorie en % valeur'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    accessibility: {
        point: {
            valueSuffix: '%'
        }
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: false
            },
            showInLegend: true
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'Actions',
            y: 61.41,
            sliced: true,
            selected: true
        }, {
            name: 'Bon de trésors',
            y: 11.84
        }, {
            name: 'Obligations',
            y: 10.85
        }, {
            name: 'OPCI et OPCC',
            y: 4.67
        }, {
            name: 'OPCVM',
            y: 4.18
        }, {
            name: 'FPCT',
            y: 7.05
        }]
    }]
});