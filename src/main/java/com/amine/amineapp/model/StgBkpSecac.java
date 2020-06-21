package com.amine.amineapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "stg_bkp_secac")
public class StgBkpSecac {
  @Id
  @Column(name = "ACACTIVATIONDATE")
  private Timestamp acActivationDate;

  @Override
  public String toString() {
    return "StgBkpSecac{" +
            "acActivationDate=" + acActivationDate +
            '}';
  }

  public Timestamp getAcActivationDate() {
    return acActivationDate;
  }

  public void setAcActivationDate(Timestamp acActivationDate) {
    this.acActivationDate = acActivationDate;
  }
}
