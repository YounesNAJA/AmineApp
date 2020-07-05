package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.*;
import com.amine.amineapp.model.*;
import com.amine.amineapp.model.chart.CapitalisationGraph;
import com.amine.amineapp.model.chart.Graph;
import com.amine.amineapp.model.chart.GraphSerie;
import com.amine.amineapp.model.filter.GraphFilter;
import com.amine.amineapp.model.filter.InstrumentCategory;
import com.amine.amineapp.model.filter.InstrumentSousCategory;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import com.amine.amineapp.service.ReleveDeSoldeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReleveDeServiceServiceImpl implements ReleveDeSoldeService {
    Logger logger = LoggerFactory.getLogger(ReleveDeServiceServiceImpl.class);

    @Autowired
    private ReleveDeSoldeRepository releveDeSoldeRepository;

    @Autowired
    private ReleveDeSoldeDetailleRepository releveDeSoldeDetailleRepository;

    @Autowired
    private InstrumentCategoryRepository instrumentCategoryRepository;

    @Autowired
    private InstrumentSousCategoryRepository instrumentSousCategoryRepository;

    @Autowired
    private CapitalisationRepository capitalisationRepository;


    @Override
    public List<String> findAllInstrumentCategories() {
        return instrumentCategoryRepository.findAllInstrumentCategories().stream().map(InstrumentCategory::getCategoryName).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllInstrumentSousCategories() {
        return instrumentSousCategoryRepository.findAllInstrumentSousCategories().stream().map(InstrumentSousCategory::getSousCategoryName).collect(Collectors.toList());
    }

    public Page<Capitalisation> findPaginatedCapitalisation(ReleveSoldeFilter releveSoldeFilter, Pageable pageable) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Capitalisation> capitalisations = capitalisationRepository.findAllCapitalisations(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );

        return getPagedData(capitalisations, pageable);
    }

    public Page<ReleveDeSolde> findPaginatedReleveDeSolde(ReleveSoldeFilter releveSoldeFilter, Pageable pageable) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeRepository.findAllReleveDeSolde(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );

        return getPagedData(releveDeSoldes, pageable);
    }

    public Page<ReleveDeSoldeDetaille> findPaginatedReleveDeSoldeDetaille(ReleveSoldeFilter releveSoldeFilter, Pageable pageable) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ReleveDeSoldeDetaille> releveDeSoldesDetailles = releveDeSoldeDetailleRepository.findAllReleveDeSoldeDetaille(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );

        return getPagedData(releveDeSoldesDetailles, pageable);
    }

    private Page getPagedData(List listOfElements, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List elementsSubList = new ArrayList<>();

        if (listOfElements.size() < startItem) {
            elementsSubList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listOfElements.size());
            elementsSubList = listOfElements.subList(startItem, toIndex);
        }

        Page releveDeSoldePage
                = new PageImpl<>(elementsSubList, PageRequest.of(currentPage, pageSize), listOfElements.size());

        return releveDeSoldePage;
    }

    private boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
