package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.ReleveDeSoldeId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleveDeSoldeRepository extends PagingAndSortingRepository<ReleveDeSolde, ReleveDeSoldeId> {

    @Query(value = Queries.RELEVE_SOLDE, nativeQuery = true)
    List<ReleveDeSolde> findAllReleveDeSolde(String bookingDate, String instrumentCategory, String instrumentSousCategory);
}
