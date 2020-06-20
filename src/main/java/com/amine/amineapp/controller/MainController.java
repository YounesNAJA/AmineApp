package com.amine.amineapp.controller;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.StgBkpSecac;
import com.amine.amineapp.service.ReleveDeSoldeService;
import com.amine.amineapp.service.StgBkpSecacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    @GetMapping("/releveSolde")
    public String releveSolde(Model model){
        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeService.findAllReleveDeSoldeOfSemestre(new GregorianCalendar(2019, Calendar.APRIL, 18).getTime());
        model.addAttribute("releveDeSoldes", releveDeSoldes);

        return "releveSolde";
    }
}
