package com.amine.amineapp.service;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReleveDeSoldeService {
    List<ReleveDeSolde> findAllReleveDeSolde(ReleveSoldeFilter releveSoldeFilter);
    //List<ReleveDeSolde> findAllReleveDeSoldeByMapping(ReleveSoldeFilter releveSoldeFilter);
    List<String> findAllInstrumentCategories();
    List<String> findAllInstrumentSousCategories();
    Page<ReleveDeSolde> findPaginatedReleveDeSolde(ReleveSoldeFilter releveSoldeFilter, Pageable pageable);
}
