package com.amine.amineapp.service;

import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.filter.GraphFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface GraphService {
    Graph getCapitalisationAnnuelleGraphData(GraphFilter graphFilter) throws ParseException;
    Graph getCapitalisationMensuelleGraphData(GraphFilter graphFilter) throws ParseException;
}
