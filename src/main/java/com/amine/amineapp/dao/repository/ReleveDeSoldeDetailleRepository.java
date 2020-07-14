package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.ReleveDeSoldeDetaille;
import com.amine.amineapp.model.embedded.ReleveDeSoldeDetailleId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleveDeSoldeDetailleRepository extends PagingAndSortingRepository<ReleveDeSoldeDetaille, ReleveDeSoldeDetailleId> {

    @Query(value = Queries.RELEVE_SOLDE_DETAILLE, nativeQuery = true)
    List<ReleveDeSoldeDetaille> findAllReleveDeSoldeDetaille(String bookingDate, String instrumentCategory, String instrumentSousCategory);
}