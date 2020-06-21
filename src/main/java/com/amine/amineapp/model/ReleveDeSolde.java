package com.amine.amineapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ReleveDeSolde {
    @EmbeddedId
    private ReleveDeSoldeId releveDeSoldeId;

    @Column(name = "MANDAT")
    private String mandant;

    @Column(name = "LIBELLEMANDANT")
    private String libelleMandant;

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

	public String getLibelleMandant() {
		return libelleMandant;
	}

	public void setLibelleMandant(String libelleMandant) {
		this.libelleMandant = libelleMandant;
	}
}
