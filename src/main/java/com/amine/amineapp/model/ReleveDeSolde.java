package com.amine.amineapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class ReleveDeSolde {
    @EmbeddedId
    private ReleveDeSoldeId releveDeSoldeId;

    @Column(name = "MANDAT")
    private String mandant;

    @Column(name = "LIBELLEMANDAT")
    private String libelleMandat;

    @Column(name = "MANDATAIRE")
    private String mandataire;

    @Column(name = "LIBELLEMANDATAIRE")
    private String libelleMandataire;

    @Column(name = "ENGLONGNAME")
    private String engLongName;

    @Column(name = "INSTRCTGRY")
    private String instrCtgry;

    @Column(name = "NORMALQUANTITY")
    private String normalQuantity;

	public ReleveDeSoldeId getReleveDeSoldeId() {
		return releveDeSoldeId;
	}

	public void setReleveDeSoldeId(ReleveDeSoldeId releveDeSoldeId) {
		this.releveDeSoldeId = releveDeSoldeId;
	}

	public String getMandant() {
		return mandant;
	}

	public void setMandant(String mandant) {
		this.mandant = mandant;
	}

	public String getLibelleMandat() {
		return libelleMandat;
	}

	public void setLibelleMandat(String libelleMandat) {
		this.libelleMandat = libelleMandat;
	}

	public String getMandataire() {
		return mandataire;
	}

	public void setMandataire(String mandataire) {
		this.mandataire = mandataire;
	}

	public String getLibelleMandataire() {
		return libelleMandataire;
	}

	public void setLibelleMandataire(String libelleMandataire) {
		this.libelleMandataire = libelleMandataire;
	}

	public String getEngLongName() {
		return engLongName;
	}

	public void setEngLongName(String engLongName) {
		this.engLongName = engLongName;
	}

	public String getInstrCtgry() {
		return instrCtgry;
	}

	public void setInstrCtgry(String instrCtgry) {
		this.instrCtgry = instrCtgry;
	}

	public String getNormalQuantity() {
		return normalQuantity;
	}

	public void setNormalQuantity(String normalQuantity) {
		this.normalQuantity = normalQuantity;
	}


}
