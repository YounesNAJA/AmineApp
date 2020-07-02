package com.amine.amineapp.controller;

import com.amine.amineapp.model.ReleveDeSolde;
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
@RequestMapping("/")
@SessionAttributes("releveSoldeFilter")
public class MainController {

    @Autowired
    private ReleveDeSoldeService releveDeSoldeService;

    @ModelAttribute("releveSoldeFilter")
    public ReleveSoldeFilter releveSoldeFilter() {
        return new ReleveSoldeFilter();
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/releveSolde")
    public String releveSoldePaginated(Model model, @RequestParam("page") Optional<Integer> page, @ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter) {
        ReleveSoldeFilter releveSoldeFilterSesssion = getReleveDeSoldeFilterFromSession(releveSoldeFilter);
        int pageSize = releveSoldeFilterSesssion.getNumberOfRows();
        int currentPage = page.orElse(1);
        Page<ReleveDeSolde> releveSoldePaged = releveDeSoldeService.findPaginatedReleveDeSolde(releveSoldeFilterSesssion, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("releveSoldePaged", releveSoldePaged);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());
        int totalPages = releveSoldePaged.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "releveSolde";
    }

    @GetMapping(value = "/releveSoldeDetaille")
    public String releveSoldeDetaillePaginated(Model model, @RequestParam("page") Optional<Integer> page, @ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter) {
        ReleveSoldeFilter releveSoldeFilterSesssion = getReleveDeSoldeFilterFromSession(releveSoldeFilter);
        int pageSize = releveSoldeFilterSesssion.getNumberOfRows();
        int currentPage = page.orElse(1);
        Page<ReleveDeSoldeDetaille> releveSoldeDetaillePaged = releveDeSoldeService.findPaginatedReleveDeSoldeDetaille(releveSoldeFilterSesssion, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("releveSoldePaged", releveSoldeDetaillePaged);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());
        int totalPages = releveSoldeDetaillePaged.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "releveSoldeDetaille";
    }

    private ReleveSoldeFilter getReleveDeSoldeFilterFromSession(ReleveSoldeFilter releveSoldeFilter){
        if (releveSoldeFilter != null) {
            return releveSoldeFilter;
        } else {
            return new ReleveSoldeFilter();
        }
    }
}
