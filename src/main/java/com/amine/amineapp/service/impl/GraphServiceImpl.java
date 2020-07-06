package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.GraphRepository;
import com.amine.amineapp.model.chart.CapitalisationGraph;
import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.chart.GraphSerie;
import com.amine.amineapp.model.filter.GraphFilter;
import com.amine.amineapp.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GraphServiceImpl implements GraphService {
    @Autowired
    private GraphRepository graphRepository;

    private List<CapitalisationGraph> getCapitalisationAnnuelleGraphData(GraphFilter graphFilter){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return graphRepository.findCapitalisationAnnuelle(
            (graphFilter.getStartDate() != null)? simpleDateFormat.format(graphFilter.getStartDate()) : simpleDateFormat.format(new Date()),
            (graphFilter.getEndDate() != null)? simpleDateFormat.format(graphFilter.getEndDate()) : simpleDateFormat.format(new Date())
        );
    }

    public Graph getGraphData(GraphFilter graphFilter){
        List<CapitalisationGraph> capitalisationGraphs = getCapitalisationAnnuelleGraphData(graphFilter);

        Graph graph = new Graph();
        graph.setGraphTitle("Capitalisation annuelle");
        graph.setyAxisTitle("Capitalisation");
        graph.setxAxisCategories(capitalisationGraphs.stream()
                .map(capitalisationGraph -> capitalisationGraph.getCapitalisationGraphId().getCategorie())
                .collect(Collectors.toSet()));

        Set<Integer> series = capitalisationGraphs.stream()
                .map(capitalisationGraph -> capitalisationGraph.getCapitalisationGraphId().getAnnee())
                .collect(Collectors.toSet());

        graph.setGraphSeries(new HashSet<>());

        Map<String, HashMap<Integer, Double>> data = new HashMap<>();
        for (String categorie: graph.getxAxisCategories()) {
            HashMap<Integer, Double> categorieData = new HashMap<>();
            for (Integer serie: series) {
                Double capi = capitalisationGraphs.stream()
                        .filter(capitalisationGraph -> capitalisationGraph.getCapitalisationGraphId().getCategorie().equals(categorie)
                                && capitalisationGraph.getCapitalisationGraphId().getAnnee().equals(serie))
                        .map(capitalisationGraph -> capitalisationGraph.getCapi() == null ? 0.0 : capitalisationGraph.getCapi())
                        .findFirst()
                        .orElse(0.0);

                categorieData.put(serie, capi);
            }

            data.put(categorie, categorieData);
        }

        for (Integer serie: series) {
            GraphSerie graphSerie = new GraphSerie();
            graphSerie.setName(serie.toString());
            graphSerie.setData(data.entrySet().stream()
                    .map(categorieData -> categorieData.getValue().get(serie))
                    .collect(Collectors.toList()));
            graph.getGraphSeries().add(graphSerie);
        }

        return graph;
    }
}
