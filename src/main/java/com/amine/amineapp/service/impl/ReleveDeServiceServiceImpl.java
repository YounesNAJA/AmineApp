package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.InstrumentCategoryRepository;
import com.amine.amineapp.dao.repository.InstrumentSousCategoryRepository;
import com.amine.amineapp.dao.repository.ReleveDeSoldeRepository;
import com.amine.amineapp.model.filter.InstrumentCategory;
import com.amine.amineapp.model.filter.InstrumentSousCategory;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.filter.ReleveSoldeFilter;
import com.amine.amineapp.model.mapper.ReleveSoldeMapper;
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

//    @Override
//    public List<ReleveDeSolde> findAllReleveDeSoldeByMapping(ReleveSoldeFilter releveSoldeFilter) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//
//        List<ReleveDeSolde> releveDeSoldes = new ArrayList<>();
//        for (Object[] object : releveDeSoldeRepository.findAllReleveDeSoldeObjects(
//                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
//                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
//                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
//        )){
//            releveDeSoldes.add(ReleveSoldeMapper.map(object));
//        }
//        return releveDeSoldes;
//    }

    @Override
    public List<ReleveDeSolde> findAllReleveDeSolde(ReleveSoldeFilter releveSoldeFilter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return releveDeSoldeRepository.findAllReleveDeSolde(
                //(releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                null,
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );
    }

    public Page<ReleveDeSolde> findPaginatedReleveDeSolde(ReleveSoldeFilter releveSoldeFilter, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ReleveDeSolde> releveDeSoldes = releveDeSoldeRepository.findAllReleveDeSolde(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );

        List<ReleveDeSolde> releveDeSoldesSubList = new ArrayList<>();

        if (releveDeSoldes.size() < startItem) {
            releveDeSoldesSubList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, releveDeSoldes.size());
            releveDeSoldesSubList = releveDeSoldes.subList(startItem, toIndex);
        }

        Page<ReleveDeSolde> bookPage
                = new PageImpl<ReleveDeSolde>(releveDeSoldesSubList, PageRequest.of(currentPage, pageSize), releveDeSoldes.size());

        return bookPage;
    }

    private boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
