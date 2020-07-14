package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.filter.InstrumentCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentCategoryRepository extends CrudRepository<InstrumentCategory, String> {

    @Query(value = Queries.INSTRUMENT_CATEGORIES, nativeQuery = true)
    List<InstrumentCategory> findAllInstrumentCategories();
}
