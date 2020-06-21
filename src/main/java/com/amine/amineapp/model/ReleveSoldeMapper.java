package com.amine.amineapp.model;

import java.util.List;

public class ReleveSoldeMapper {

	public static ReleveDeSolde map(Object[] releveSoldeObject) {
		ReleveDeSolde releveSolde = new ReleveDeSolde();
		ReleveDeSoldeId releveDeSoldeID = new ReleveDeSoldeId();
		
		releveDeSoldeID.setAcno(releveSoldeObject[4].toString());
		releveDeSoldeID.setSecurityID(releveSoldeObject[5].toString());
		releveSolde.setReleveDeSoldeId(releveDeSoldeID);
		
		releveSolde.setMandant(releveSoldeObject[0].toString());
		releveSolde.setLibelleMandat(releveSoldeObject[1].toString());
		releveSolde.setMandataire(releveSoldeObject[2].toString());
		releveSolde.setLibelleMandataire(releveSoldeObject[3].toString());
		releveSolde.setEngLongName(releveSoldeObject[6].toString());
		releveSolde.setInstrCtgry(releveSoldeObject[7].toString());
		releveSolde.setNormalQuantity(releveSoldeObject[8].toString());
		return releveSolde;
	}

}
