package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.chart.CapitalisationGraph;
import com.amine.amineapp.model.chart.CapitalisationGraphId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphRepository extends CrudRepository<CapitalisationGraph, CapitalisationGraphId> {

//    @Query(value = Queries.CAPITALISATION_ANNUELLE, nativeQuery = true)
//    List<CapitalisationGraph> findCapitalisationAnnuelle(String startDate, String endDate);

    @Query(value = Queries.CAPITALISATION_ANNUELLE, nativeQuery = true)
    List<CapitalisationGraph> findCapitalisationAnnuelle(String startDate, String endDate);

//    @Query(value = Queries.CAPITALISATION_SEMESTRIELLE, nativeQuery = true)
//    List<CapitalisationGraph> findCapitalisationMensuelle(String startDate, String endDate);

    @Query(value = Queries.CAPITALISATION_SEMESTRIELLE, nativeQuery = true)
    List<CapitalisationGraph> findCapitalisationSemestrielle(String startDate, String endDate);
}
