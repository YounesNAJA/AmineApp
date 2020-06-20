package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.StgBkpSecac;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StgBkpSecacRepository extends PagingAndSortingRepository<StgBkpSecac, Timestamp> {

    @Query(value = "SELECT ACACTIVATIONDATE FROM stg_bkp_secac WHERE ACACTIVATIONDATE IS NOT NULL", nativeQuery = true)
    List<StgBkpSecac> findByActivationDate();
}
