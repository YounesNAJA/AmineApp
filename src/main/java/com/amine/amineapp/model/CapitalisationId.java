package com.amine.amineapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class CapitalisationId implements Serializable {
    @Column(name = "NUMEROCOMPTE")
    private BigInteger numeroCompte;

    @Column(name = "INSTRUMENT")
    private String instrument;

    public BigInteger getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(BigInteger numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
