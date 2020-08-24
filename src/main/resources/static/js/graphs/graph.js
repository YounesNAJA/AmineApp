var drawCapitalisationGraph = function(typeCapitalisation, graphTitle, yAxisTitle, xAxisCategories, series) {
    Highcharts.chart(typeCapitalisation, {
        chart: {
            type: 'line'
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
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: series

    });

    $(".highcharts-credits").hide();
};

var getDateFromYear = function(year) {
    if(year != null && year.length === 4)
        return year + "-12-31";
};

var getDateSemestreFromYear = function(year) {
    if(year != null && year.length === 4)
        return year + "-06-30";
};

$("#capiAnnuelleForm").submit(function(e){
    $.get("graph/cap-annuelle", {
        startDate: getDateFromYear($("#startYear").val()),
        endDate: getDateFromYear($("#endYear").val())
    })
        .done(function(data) {
            drawCapitalisationGraph('capitalisationAnnuelle', data.graphTitle, data.yAxisTitle, data.xAxisCategories, data.graphSeries);
        });
    e.preventDefault();
});

$("#capiMensuelleForm").submit(function(e){
    $.get("graph/cap-mensuelle", {
        startDate: getDateSemestreFromYear($("#startSemestre").val()),
        endDate: getDateSemestreFromYear($("#endSemestre").val())
    })
        .done(function(data) {
            drawCapitalisationGraph('capitalisationSemestrielle', data.graphTitle, data.yAxisTitle, data.xAxisCategories, data.graphSeries);
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

// $(function() {
//     var yearSelectors = $('.year-selector');
//     for(var yearSelector in yearSelectors){
//         yearSelector.datepicker({
//             changeYear: true,
//             showButtonPanel: true,
//             dateFormat: 'yy',
//             onClose: function(dateText, inst) {
//                 var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
//                 $(this).datepicker('setDate', new Date(year, 1));
//             }
//         });
//     }
//
//     $(".date-picker-year").focus(function () {
//         $(".ui-datepicker-month").hide();
//     });
// });