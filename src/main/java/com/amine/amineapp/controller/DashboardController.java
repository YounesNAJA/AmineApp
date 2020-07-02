package com.amine.amineapp.controller;

import com.amine.amineapp.model.Capitalisation;
import com.amine.amineapp.model.ReleveDeSoldeDetaille;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import com.amine.amineapp.service.ReleveDeSoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/dashboard")
@SessionAttributes("releveSoldeFilter")
public class DashboardController {

    @Autowired
    private ReleveDeSoldeService releveDeSoldeService;

    @GetMapping("/releve-solde")
    public String dashboard(Model model, @RequestParam("page") Optional<Integer> page, @ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter){
        ReleveSoldeFilter releveSoldeFilterSesssion = getReleveDeSoldeFilterFromSession(releveSoldeFilter);
        int pageSize = releveSoldeFilterSesssion.getNumberOfRows();
        int currentPage = page.orElse(1);
        Page<Capitalisation> capitalisationsPaged = releveDeSoldeService.findPaginatedCapitalisation(releveSoldeFilterSesssion, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("capitalisationsPaged", capitalisationsPaged);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());
        int totalPages = capitalisationsPaged.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "releve-solde";
    }

    @ModelAttribute("releveSoldeFilter")
    public ReleveSoldeFilter releveSoldeFilter() {
        return new ReleveSoldeFilter();
    }

    private ReleveSoldeFilter getReleveDeSoldeFilterFromSession(ReleveSoldeFilter releveSoldeFilter){
        if (releveSoldeFilter != null) {
            return releveSoldeFilter;
        } else {
            return new ReleveSoldeFilter();
        }
    }
}
