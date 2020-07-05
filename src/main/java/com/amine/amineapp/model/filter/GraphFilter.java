package com.amine.amineapp.model.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class GraphFilter {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public GraphFilter(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public GraphFilter() {
        endDate = new Date();
        startDate = Timestamp.valueOf(LocalDateTime.now().minusYears(2));
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isEmpty() {
        return startDate == null && endDate == null;
    }
}
