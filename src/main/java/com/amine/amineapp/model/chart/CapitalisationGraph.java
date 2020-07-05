package com.amine.amineapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CapitalisationGraph {
    @EmbeddedId
    private CapitalisationGraphId capitalisationGraphId;



    @Column(name = "CAPI")
    private Double capi;

    public Double getCapi() {
        return capi;
    }

    public void setCapi(Double capi) {
        this.capi = capi;
    }


}
