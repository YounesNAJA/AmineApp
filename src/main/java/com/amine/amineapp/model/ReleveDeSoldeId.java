package com.amine.amineapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ReleveDeSoldeId implements Serializable {
    @Column(name = "SECURITYID")
    private String securityID;

    @Column(name = "ACNO")
    private String acno;
}
