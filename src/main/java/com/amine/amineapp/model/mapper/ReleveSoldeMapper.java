package com.amine.amineapp.model.mapper;

import com.amine.amineapp.model.ReleveDeSolde;
import com.amine.amineapp.model.ReleveDeSoldeId;

public class ReleveSoldeMapper {

	public static ReleveDeSolde map(Object[] releveSoldeObject) {
		ReleveDeSolde releveSolde = new ReleveDeSolde();
		releveSolde.setReleveDeSoldeId(new ReleveDeSoldeId(
				releveSoldeObject[ReleveSoldeColumns.SECURITYID].toString(),
				releveSoldeObject[ReleveSoldeColumns.ACNO].toString()
		));
		releveSolde.setMandant(releveSoldeObject[ReleveSoldeColumns.MANDANT].toString());
		releveSolde.setLibelleMandat(releveSoldeObject[ReleveSoldeColumns.LIBELLEMANDAT].toString());
		releveSolde.setMandataire(releveSoldeObject[ReleveSoldeColumns.MANDATAIRE].toString());
		releveSolde.setLibelleMandataire(releveSoldeObject[ReleveSoldeColumns.LIBELLEMANDATAIRE].toString());
		releveSolde.setEngLongName(releveSoldeObject[ReleveSoldeColumns.ENGLONGNAME].toString());
		releveSolde.setInstrCtgry(releveSoldeObject[ReleveSoldeColumns.INSTRCTGRY].toString());
		releveSolde.setNormalQuantity(releveSoldeObject[ReleveSoldeColumns.NORMALQUANTITY].toString());
		return releveSolde;
	}

}
