package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.ReleveDeSoldeRepository;
import com.amine.amineapp.dao.repository.StgBkpSecacRepository;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.StgBkpSecac;
import com.amine.amineapp.service.ReleveDeSoldeService;
import com.amine.amineapp.service.StgBkpSecacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReleveDeServiceServiceImpl implements ReleveDeSoldeService {
    Logger logger = LoggerFactory.getLogger(ReleveDeServiceServiceImpl.class);

    @Autowired
    private ReleveDeSoldeRepository releveDeSoldeRepository;

    @Override
    public List<ReleveDeSolde> findAllReleveDeSoldeOfSemestre(Date bookingDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return releveDeSoldeRepository.findAllReleveDeSoldeOfSemestre(simpleDateFormat.format(bookingDate));
    }
}
