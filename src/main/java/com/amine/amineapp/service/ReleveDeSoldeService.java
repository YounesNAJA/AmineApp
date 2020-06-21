package com.amine.amineapp.service;

import com.amine.amineapp.model.filter.InstrumentCategory;
import com.amine.amineapp.model.filter.InstrumentSousCategory;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;

import java.util.List;

public interface ReleveDeSoldeService {
    List<ReleveDeSolde> findAllReleveDeSolde(ReleveSoldeFilter releveSoldeFilter);
    List<ReleveDeSolde> findAllReleveDeSoldeByMapping(ReleveSoldeFilter releveSoldeFilter);
    List<String> findAllInstrumentCategories();
    List<String> findAllInstrumentSousCategories();
}
