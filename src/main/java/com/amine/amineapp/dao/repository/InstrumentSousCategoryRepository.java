package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.filter.InstrumentSousCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentSousCategoryRepository extends CrudRepository<InstrumentSousCategory, String> {

    @Query(value ="SELECT DISTINCT INSTRCTGRY FROM stg_fim_prmydtls", nativeQuery = true)
    List<InstrumentSousCategory> findAllInstrumentSousCategories();
}
