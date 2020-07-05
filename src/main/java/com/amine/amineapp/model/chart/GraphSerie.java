package com.amine.amineapp.model.chart;

import java.util.List;

public class GraphSerie {
    private String name;
    private List<Double> data;

    public GraphSerie(String name, List<Double> data) {
        this.name = name;
        this.data = data;
    }

    public GraphSerie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
