package com.amine.amineapp.model.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;

public class ReleveSoldeFilter {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;
    private String instrumentCategory;
    private String instrumentSousCategory;
    private Optional<Integer> numberOfRows;

    public ReleveSoldeFilter() {
        this.bookingDate = new Date();
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getInstrumentCategory() {
        return instrumentCategory;
    }

    public void setInstrumentCategory(String instrumentCategory) {
        this.instrumentCategory = instrumentCategory;
    }

    public String getInstrumentSousCategory() {
        return instrumentSousCategory;
    }

    public void setInstrumentSousCategory(String instrumentSousCategory) {
        this.instrumentSousCategory = instrumentSousCategory;
    }

    public Optional<Integer> getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(Optional<Integer> numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}
