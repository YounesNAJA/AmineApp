package com.amine.amineapp.model.chart;

import java.util.List;
import java.util.Set;

public class Graph {
    private String graphTitle;
    private String yAxisTitle;
    private Set<String> xAxisCategories;
    private Set<GraphSerie> graphSeries;

    public String getGraphTitle() {
        return graphTitle;
    }

    public void setGraphTitle(String graphTitle) {
        this.graphTitle = graphTitle;
    }

    public String getyAxisTitle() {
        return yAxisTitle;
    }

    public void setyAxisTitle(String yAxisTitle) {
        this.yAxisTitle = yAxisTitle;
    }

    public Set<String> getxAxisCategories() {
        return xAxisCategories;
    }

    public void setxAxisCategories(Set<String> xAxisCategories) {
        this.xAxisCategories = xAxisCategories;
    }

    public Set<GraphSerie> getGraphSeries() {
        return graphSeries;
    }

    public void setGraphSeries(Set<GraphSerie> graphSeries) {
        this.graphSeries = graphSeries;
    }
}
