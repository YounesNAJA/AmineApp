package com.amine.amineapp.service;

import com.amine.amineapp.model.Capitalisation;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.ReleveDeSoldeDetaille;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ReleveDeSoldeService {
    List<String> findAllInstrumentCategories();
    List<String> findAllInstrumentSousCategories();
    Page<ReleveDeSolde> findPaginatedReleveDeSolde(ReleveSoldeFilter releveSoldeFilter, Pageable pageable);
    Page<ReleveDeSoldeDetaille> findPaginatedReleveDeSoldeDetaille(ReleveSoldeFilter releveSoldeFilter, Pageable pageable);
    Page<Capitalisation> findPaginatedCapitalisation(ReleveSoldeFilter releveSoldeFilter, Pageable pageable);
}
