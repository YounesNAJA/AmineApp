package com.amine.amineapp.service;

import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.filter.GraphFilter;

public interface GraphService {
    Graph getGraphData(GraphFilter graphFilter);
}
