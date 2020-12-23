package com.roiim.restapi.pojo;

public class Date {
    public Integer day;

    public Integer month;

    public Integer year;

    public Date(){}

    public Date( int day, int month, int year ){

        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
