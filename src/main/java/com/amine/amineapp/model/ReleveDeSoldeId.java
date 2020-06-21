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

	public String getSecurityID() {
		return securityID;
	}

	public void setSecurityID(String securityID) {
		this.securityID = securityID;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}
    
    
}
