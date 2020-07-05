package com.amine.amineapp.dao.repository;

import com.amine.amineapp.model.Capitalisation;
import com.amine.amineapp.model.embedded.CapitalisationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitalisationRepository extends CrudRepository<Capitalisation, CapitalisationId> {
    @Query(value ="SELECT a.ACNO NUMEROCOMPTE, a.SECURITYID INSTRUMENT, c.ENGLONGNAME LIBELLEINSTRUMENT, c.INSTRCTGRY CATEGORIE, a.NORMALQUANTITY QUANTITEAVOIRS, case WHEN c.CLASSID='DEBT' THEN c.PARVALUE*a.NORMALQUANTITY WHEN c.CLASSID ='MTFU' THEN g.CLOSEPRICE*a.NORMALQUANTITY WHEN c.CLASSID='EQTY' THEN g.CLOSEPRICE*a.NORMALQUANTITY WHEN c.CLASSID='EQTY' and c.INSTRCTGRY = 'OPCR' THEN c.PARVALUE*a.NORMALQUANTITY END CAPI FROM stg_bkp_secposeod a LEFT JOIN stg_bpm_poadetails b ON a.ACOWNERID=b.BPID LEFT JOIN stg_bpm_prmrydtls e ON b.POAHOLDER=e.BPID LEFT JOIN stg_fim_prmydtls c ON a.SECURITYID=c.INSTRID LEFT JOIN fim_qutndtls_tmp_v g ON a.SECURITYID=g.INSTRID, stg_bkp_secac f WHERE a.ACOWNERID=f.ACOWNERID and a.NORMALQUANTITY <> 0 and a.ACNO=f.ACNO AND (?1 IS NULL OR a.BOOKINGDATE = ?1) AND (?2 IS NULL OR c.INSTRCTGRY = ?2) ORDER BY a.SECURITYID", nativeQuery = true)
    List<Capitalisation> findAllCapitalisations(String bookingDate, String category);
}
