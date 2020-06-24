package com.amine.amineapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ReleveDeSoldeDetaille {
	@EmbeddedId
	private ReleveDeSoldeDetailleId releveDeSoldeDetailleId;

    @Column(name = "DATE_MAJ")
    private Date dateMaj;

    @Column(name = "CODE_MANDATAIRE")
    private String codeMandataire;

    @Column(name = "LIBELLE_MANDATAIRE")
    private String libelleMandataire;

    @Column(name = "CODE_MANDANT")
    private String codeMandant;

	@Column(name = "LIBELLE_MANDANT")
	private String libelleMandant;


	@Column(name = "EMETTEUR")
	private String emetteur;

	@Column(name = "AGENT")
	private String agent;

	@Column(name = "GESTION")
	private String gestion;

	@Column(name = "LIBELLE_VALEUR")
	private String libelleValeur;

	@Column(name = "QUANTITE")
	private String quantite;

	@Column(name = "DATE_OUVERTURE")
	private String dateOuverture;

	@Column(name = "PRIX")
	private String prix;

	@Column(name = "CAPITALISATION")
	private String capitalisation;

	@Column(name = "SENS")
	private String sens;

	@Column(name = "CLASS")
	private String classID;

	@Column(name = "TYPE")
	private String type;

	public ReleveDeSoldeDetailleId getReleveDeSoldeDetailleId() {
		return releveDeSoldeDetailleId;
	}

	public void setReleveDeSoldeDetailleId(ReleveDeSoldeDetailleId releveDeSoldeDetailleId) {
		this.releveDeSoldeDetailleId = releveDeSoldeDetailleId;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getCodeMandataire() {
		return codeMandataire;
	}

	public void setCodeMandataire(String codeMandataire) {
		this.codeMandataire = codeMandataire;
	}

	public String getLibelleMandataire() {
		return libelleMandataire;
	}

	public void setLibelleMandataire(String libelleMandataire) {
		this.libelleMandataire = libelleMandataire;
	}

	public String getCodeMandant() {
		return codeMandant;
	}

	public void setCodeMandant(String codeMandant) {
		this.codeMandant = codeMandant;
	}

	public String getLibelleMandant() {
		return libelleMandant;
	}

	public void setLibelleMandant(String libelleMandant) {
		this.libelleMandant = libelleMandant;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getGestion() {
		return gestion;
	}

	public void setGestion(String gestion) {
		this.gestion = gestion;
	}

	public String getLibelleValeur() {
		return libelleValeur;
	}

	public void setLibelleValeur(String libelleValeur) {
		this.libelleValeur = libelleValeur;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getCapitalisation() {
		return capitalisation;
	}

	public void setCapitalisation(String capitalisation) {
		this.capitalisation = capitalisation;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
