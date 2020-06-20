package com.amine.amineapp.service.impl;

import com.amine.amineapp.dao.repository.StgBkpSecacRepository;
import com.amine.amineapp.model.StgBkpSecac;
import com.amine.amineapp.service.StgBkpSecacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StgBkpSecacServiceImpl implements StgBkpSecacService {
    Logger logger = LoggerFactory.getLogger(StgBkpSecacServiceImpl.class);

    @Autowired
    private StgBkpSecacRepository stgBkpSecacRepository;

    public List<StgBkpSecac> findByActivationDate(){
        logger.info(stgBkpSecacRepository.findByActivationDate().toString());
        return stgBkpSecacRepository.findByActivationDate();
    }
}
