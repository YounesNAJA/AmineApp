package com.amine.amineapp.service;

import com.amine.amineapp.model.StgBkpSecac;

import java.util.List;

public interface StgBkpSecacService {
    List<StgBkpSecac> findByActivationDate();
}
