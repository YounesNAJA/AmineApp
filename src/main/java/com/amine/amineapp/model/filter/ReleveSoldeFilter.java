package com.amine.amineapp.model.filter;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class ReleveSoldeFilter {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;
    private String instrumentCategory;
    private String instrumentSousCategory;
    private Integer numberOfRows;

    public ReleveSoldeFilter() {
        this.bookingDate = new Date();
    }
}
