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


}
