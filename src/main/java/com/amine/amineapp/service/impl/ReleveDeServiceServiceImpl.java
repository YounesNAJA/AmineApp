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
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<InstrumentCategory> findAllInstrumentCategories() {
        return instrumentCategoryRepository.findAllInstrumentCategories();
    }

    @Override
    public List<InstrumentSousCategory> findAllInstrumentSousCategories() {
        return instrumentSousCategoryRepository.findAllInstrumentSousCategories();
    }

    @Override
    public List<ReleveDeSolde> findAllReleveDeSoldeByMapping(ReleveSoldeFilter releveSoldeFilter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        List<ReleveDeSolde> releveDeSoldes = new ArrayList<>();
        for (Object[] object : releveDeSoldeRepository.findAllReleveDeSoldeObjects(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        )){
            releveDeSoldes.add(ReleveSoldeMapper.map(object));
        }
        return releveDeSoldes;
    }

    @Override
    public List<ReleveDeSolde> findAllReleveDeSolde(ReleveSoldeFilter releveSoldeFilter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return releveDeSoldeRepository.findAllReleveDeSolde(
                (releveSoldeFilter.getBookingDate() != null)? simpleDateFormat.format(releveSoldeFilter.getBookingDate()) : simpleDateFormat.format(new Date()),
                isBlank(releveSoldeFilter.getInstrumentCategory()) ? null : releveSoldeFilter.getInstrumentCategory(),
                isBlank(releveSoldeFilter.getInstrumentSousCategory()) ? null : releveSoldeFilter.getInstrumentSousCategory()
        );
    }

    private boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
