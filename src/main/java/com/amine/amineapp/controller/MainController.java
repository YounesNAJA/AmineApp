package com.amine.amineapp.controller;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import com.amine.amineapp.model.StgBkpSecac;
import com.amine.amineapp.service.ReleveDeSoldeService;
import com.amine.amineapp.service.StgBkpSecacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeService.findAllReleveDeSoldeByMapping(releveSoldeFilter);
        model.addAttribute("releveDeSoldes", releveDeSoldes);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());

        return "releveSolde";
    }

    @GetMapping("/releveSolde")
    public String releveSolde(Model model){

        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeService.findAllReleveDeSoldeByMapping(new ReleveSoldeFilter());
        model.addAttribute("releveSoldeFilter", new ReleveSoldeFilter());
        model.addAttribute("releveDeSoldes", releveDeSoldes);
        model.addAttribute("instrumentCategories", releveDeSoldeService.findAllInstrumentCategories());
        model.addAttribute("instrumentSousCategories", releveDeSoldeService.findAllInstrumentSousCategories());

        return "releveSolde";
    }
}
