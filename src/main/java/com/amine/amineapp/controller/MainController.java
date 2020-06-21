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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
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

    @PostMapping("/releveSolde")
    public String releveSoldeFiltred(@ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter, Model model){
        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeService.findAllReleveDeSolde(releveSoldeFilter);
        model.addAttribute("releveDeSoldes", releveDeSoldes);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());

        return "releveSolde";
    }

    @GetMapping("/releveSolde")
    public String releveSolde(Model model){

        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeService.findAllReleveDeSolde(new ReleveSoldeFilter());
        model.addAttribute("releveSoldeFilter", new ReleveSoldeFilter());
        model.addAttribute("releveDeSoldes", releveDeSoldes);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());

        return "releveSolde";
    }

    @GetMapping(value = "/releveSoldePaginated")
    public String listBooks(
            @ModelAttribute("releveSoldeFilter") ReleveSoldeFilter releveSoldeFilter,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

        Page<ReleveDeSolde> releveSoldePage = releveDeSoldeService.findPaginatedReleveDeSolde(releveSoldeFilter, PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("releveSoldePage", releveSoldePage);

        int totalPages = releveSoldePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "releveSoldePaginated";
    }
}
