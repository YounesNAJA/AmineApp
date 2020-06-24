package com.amine.amineapp.controller;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.StgBkpSecac;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import com.amine.amineapp.service.ReleveDeSoldeService;
import com.amine.amineapp.service.StgBkpSecacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    private StgBkpSecacService stgBkpSecacService;

    @Autowired
    private ReleveDeSoldeService releveDeSoldeService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/stg")
    public String stg(Model model){
        List<StgBkpSecac> stgBkpSecacs = stgBkpSecacService.findByActivationDate();
        model.addAttribute("stgBkpSecacs", stgBkpSecacs);

        return "stg";
    }

    @ModelAttribute("releveSoldeFilter")
    public ReleveSoldeFilter releveSoldeFilter() {
        return new ReleveSoldeFilter();
    }

    @GetMapping(value = "/releveSolde")
    public String releveSoldePaginated(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<ReleveDeSolde> releveSoldePaged = releveDeSoldeService.findPaginatedReleveDeSolde(getReleveDeSoldeFilterFromSession(releveSoldeFilter), PageRequest.of(currentPage - 1, pageSize));
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

    private ReleveSoldeFilter getReleveDeSoldeFilterFromSession(ReleveSoldeFilter releveSoldeFilter){
        if (releveSoldeFilter != null) {
            return releveSoldeFilter;
        } else {
            return new ReleveSoldeFilter();
        }
    }
}
