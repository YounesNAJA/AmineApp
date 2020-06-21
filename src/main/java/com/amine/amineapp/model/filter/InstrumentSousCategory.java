package com.amine.amineapp.model.filter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstrumentSousCategory {
    @Id
    @Column(name = "INSTRCTGRY")
    private String sousCategoryName;

    public String getSousCategoryName() {
        return sousCategoryName;
    }

    public void setSousCategoryName(String sousCategoryName) {
        this.sousCategoryName = sousCategoryName;
    }
}
