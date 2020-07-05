package com.amine.amineapp.model;

import com.amine.amineapp.model.embedded.CapitalisationId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Capitalisation {
    @EmbeddedId
    private CapitalisationId capitalisationId;

    @Column(name = "LIBELLEINSTRUMENT")
    private String libelleInstrument;

    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "QUANTITEAVOIRS")
    private String QuantiteAvoirs;

    @Column(name = "CAPI")
    private String capi;

    public CapitalisationId getCapitalisationId() {
        return capitalisationId;
    }

    public void setCapitalisationId(CapitalisationId capitalisationId) {
        this.capitalisationId = capitalisationId;
    }

    public String getLibelleInstrument() {
        return libelleInstrument;
    }

    public void setLibelleInstrument(String libelleInstrument) {
        this.libelleInstrument = libelleInstrument;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getQuantiteAvoirs() {
        return QuantiteAvoirs;
    }

    public void setQuantiteAvoirs(String quantiteAvoirs) {
        QuantiteAvoirs = quantiteAvoirs;
    }

    public String getCapi() {
        return capi;
    }

    public void setCapi(String capi) {
        this.capi = capi;
    }
}
