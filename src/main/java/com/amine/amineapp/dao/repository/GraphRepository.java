package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.chart.CapitalisationGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphRepository extends CrudRepository<CapitalisationGraph, String> {
    @Query(value ="SELECT c.INSTRCTGRY AS CATEGORIE, YEAR(a.BOOKINGDATE) AS ANNEE, case WHEN c.CLASSID='DEBT' THEN abs(c.PARVALUE*a.NORMALQUANTITY) WHEN c.CLASSID ='MTFU' THEN abs(g.CLOSEPRICE*a.NORMALQUANTITY) WHEN c.CLASSID='EQTY' THEN abs(g.CLOSEPRICE*a.NORMALQUANTITY) WHEN c.CLASSID='EQTY' and c.INSTRCTGRY = 'OPCR' THEN abs(c.PARVALUE*a.NORMALQUANTITY) END CAPI FROM stg_bkp_secposeod a LEFT JOIN stg_bpm_poadetails b ON a.ACOWNERID=b.BPID LEFT JOIN stg_bpm_prmrydtls e ON b.POAHOLDER=e.BPID LEFT JOIN stg_fim_prmydtls c ON a.SECURITYID=c.INSTRID LEFT JOIN fim_qutndtls_tmp_v g ON a.SECURITYID=g.INSTRID, stg_bkp_secac f WHERE a.ACOWNERID=f.ACOWNERID and f. ACTYPE='20' and a.NORMALQUANTITY <> 0 and a.ACNO=f.ACNO AND (?1 IS NULL AND ?2 IS NULL OR a.BOOKINGDATE BETWEEN ?1 AND ?2) GROUP BY c.INSTRCTGRY, YEAR(a.BOOKINGDATE)", nativeQuery = true)
    List<CapitalisationGraph> findCapitalisationAnnuelle(String startDate, String endDate);
}
