package com.amine.amineapp.dao.repository;

import com.amine.amineapp.dao.Queries;
import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.ReleveDeSoldeId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleveDeSoldeRepository extends PagingAndSortingRepository<ReleveDeSolde, ReleveDeSoldeId> {
    @Query(value = "SELECT ACOWNERID MANDANT, B.BPNAME LIBELLEMANDANT, CASE WHEN C.POAHOLDER IS NULL THEN A.ACOWNERID ELSE C.POAHOLDER END AS MANDATAIRE, CASE WHEN D.BPNAME IS NULL THEN B.BPNAME ELSE D.BPNAME END AS LIBELLEMANDATAIRE, A.ACNO, A.SECURITYID, E.ENGLONGNAME, E.INSTRCTGRY, A.NORMALQUANTITY FROM STG_BKP_SECPOSEOD A LEFT JOIN STG_BPM_POADETAILS C ON A.ACOWNERID = C.BPID LEFT JOIN STG_BPM_PRMRYDTLS D ON C.POAHOLDER = D.BPID, STG_BPM_PRMRYDTLS B, STG_FIM_PRMYDTLS E WHERE A.ACOWNERID = B.BPID AND A.SECURITYID = E.INSTRID AND A.NORMALQUANTITY != 0 AND (?1 IS NULL OR A.BOOKINGDATE = ?1) AND (?2 IS NULL OR E.CLASSID = ?2) AND (?3 IS NULL OR E.INSTRCTGRY = ?3) ORDER BY A.ACOWNERID", nativeQuery = true)
    List<ReleveDeSolde> findAllReleveDeSolde(String bookingDate, String instrumentCategory, String instrumentSousCategory);
}
