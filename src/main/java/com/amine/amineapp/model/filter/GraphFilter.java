package com.amine.amineapp.model.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    }

    public static GraphFilter defaultSemestrielleDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return new GraphFilter(
                simpleDateFormat.parse(LocalDateTime.now().getYear()+ "-06-30"),
                simpleDateFormat.parse(LocalDateTime.now().minusYears(1).getYear()+ "-06-30")
        );
    }

    public static GraphFilter defaultAnnuelleDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return new GraphFilter(
                simpleDateFormat.parse(LocalDateTime.now().getYear()+ "-12-31"),
                simpleDateFormat.parse(LocalDateTime.now().minusYears(1).getYear()+ "-12-31")
        );
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
