package com.amine.amineapp.model.filter;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class InstrumentSousCategory {
    @Id
    @Column(name = "INSTRCTGRY")
    private String sousCategoryName;
}
