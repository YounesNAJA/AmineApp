package com.amine.amineapp.service;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.StgBkpSecac;

import java.util.Date;
import java.util.List;

public interface ReleveDeSoldeService {
    List<ReleveDeSolde> findAllReleveDeSoldeOfSemestre(Date bookingDate);
}
