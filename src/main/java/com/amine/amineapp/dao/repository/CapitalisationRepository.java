package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.Capitalisation;
import com.amine.amineapp.model.embedded.CapitalisationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitalisationRepository extends CrudRepository<Capitalisation, CapitalisationId> {
    @Query(value = Queries.ALL_CAPITALISATIONS, nativeQuery = true)
    List<Capitalisation> findAllCapitalisations(String bookingDate, String category);
}
