package com.amine.amineapp.model.chart;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CapitalisationGraphId implements Serializable {
    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "ANNEE")
    private Integer annee;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
}
