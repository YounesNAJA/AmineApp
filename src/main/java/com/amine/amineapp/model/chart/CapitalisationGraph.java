package com.amine.amineapp.model.chart;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CapitalisationGraph {
    @EmbeddedId
    private CapitalisationGraphId capitalisationGraphId;

    @Column(name = "CAPI")
    protected Double capi;

    public CapitalisationGraphId getCapitalisationGraphId() {
        return capitalisationGraphId;
    }

    public void setCapitalisationGraphId(CapitalisationGraphId capitalisationGraphId) {
        this.capitalisationGraphId = capitalisationGraphId;
    }

    public Double getCapi() {
        return capi;
    }

    public void setCapi(Double capi) {
        this.capi = capi;
    }
}
