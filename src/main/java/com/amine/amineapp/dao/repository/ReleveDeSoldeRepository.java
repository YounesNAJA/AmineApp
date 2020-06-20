package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.StgBkpSecac;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ReleveDeSoldeRepository extends PagingAndSortingRepository<StgBkpSecac, Timestamp> {

    @Query(value ="SELECT ACOWNERID MANDANT, B.BPNAME LIBELLEMANDANT, CASE WHEN C.POAHOLDER IS NULL THEN A.ACOWNERID ELSE C.POAHOLDER END AS MANDATAIRE, CASE WHEN D.BPNAME IS NULL THEN B.BPNAME ELSE D.BPNAME END AS LIBELLEMANDATAIRE, A.ACNO, A.SECURITYID, E.ENGLONGNAME, E.INSTRCTGRY, A.NORMALQUANTITY FROM STG_BKP_SECPOSEOD A LEFT JOIN STG_BPM_POADETAILS C ON A.ACOWNERID = C.BPID LEFT JOIN STG_BPM_PRMRYDTLS D ON C.POAHOLDER = D.BPID, STG_BPM_PRMRYDTLS B, STG_FIM_PRMYDTLS E WHERE A.ACOWNERID = B.BPID AND A.SECURITYID = E.INSTRID AND A.NORMALQUANTITY != 0 AND A.BOOKINGDATE = ?1 ORDER BY A.ACOWNERID", nativeQuery = true)
    List<ReleveDeSolde> findAllReleveDeSoldeOfSemestre(String bookingDate);
}
