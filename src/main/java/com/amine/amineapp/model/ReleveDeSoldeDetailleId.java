package com.amine.amineapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReleveDeSoldeDetailleId implements Serializable {

	@Column(name = "CODE_VALEUR")
	private String codeValeur;

	@Column(name = "NUM_COMPTE")
	private String numCompte;

	public String getCodeValeur() {
		return codeValeur;
	}

	public void setCodeValeur(String codeValeur) {
		this.codeValeur = codeValeur;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
}
