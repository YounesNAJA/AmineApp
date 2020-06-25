package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.InstrumentCategoryRepository;
import com.amine.amineapp.dao.repository.InstrumentSousCategoryRepository;
import com.amine.amineapp.dao.repository.ReleveDeSoldeDetailleRepository;
import com.amine.amineapp.dao.repository.ReleveDeSoldeRepository;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.ReleveDeSoldeDetaille;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<String> findAllInstrumentCategories() {
        return instrumentCategoryRepository.findAllInstrumentCategories().stream().map(InstrumentCategory::getCategoryName).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllInstrumentSousCategories() {
        return instrumentSousCategoryRepository.findAllInstrumentSousCategories().stream().map(InstrumentSousCategory::getSousCategoryName).collect(Collectors.toList());
    }

/*    @Override
    public List<ReleveDeSolde> findAllReleveDeSolde(ReleveSoldeFilter releveSoldeFilter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return releveDeSoldeRepository.findAllReleveDeSolde(
                //(releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                null,
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );
    }*/

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

    private Page getPagedData(List releveDeSoldes, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List releveDeSoldesSubList = new ArrayList<>();

        if (releveDeSoldes.size() < startItem) {
            releveDeSoldesSubList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, releveDeSoldes.size());
            releveDeSoldesSubList = releveDeSoldes.subList(startItem, toIndex);
        }

        Page releveDeSoldePage
                = new PageImpl<>(releveDeSoldesSubList, PageRequest.of(currentPage, pageSize), releveDeSoldes.size());

        return releveDeSoldePage;
    }

    private boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
