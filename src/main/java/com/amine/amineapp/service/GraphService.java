package com.amine.amineapp.service;

import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.filter.GraphFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface GraphService {
    Graph getCapitalisationAnnuelleGraphData(GraphFilter graphFilter);
    Graph getCapitalisationMensuelleGraphData(GraphFilter graphFilter);
}
