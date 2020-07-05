package com.amine.amineapp.controller;

import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.filter.GraphFilter;
import com.amine.amineapp.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/dashboard/graph")
@SessionAttributes("graphFilter")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @ModelAttribute("graphFilter")
    public GraphFilter graphFilter() {
        return new GraphFilter();
    }

    private GraphFilter getGraphFilterFromSession(GraphFilter graphFilter){
        if (!graphFilter.isEmpty()) {
            return graphFilter;
        } else {
            return new GraphFilter();
        }
    }

    @GetMapping("/cap-annuelle")
    public Graph getCapitalisationAnnuelle(@ModelAttribute("graphFilter") GraphFilter graphFilter) throws ParseException {
        GraphFilter graphFilterSession = getGraphFilterFromSession(graphFilter);
        return graphService.getGraphData(graphFilterSession);
    }
}
