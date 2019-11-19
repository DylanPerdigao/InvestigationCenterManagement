package com.DEI.TP2;

import java.util.Date;

public class Task {
    //Variables
    private String name;
    private double effortRate;
    private int duration;
    private Date beginDate, endDate;
    private Person responsible;

    //Constructor
    Task( String name, double effortRate, Date beginDate, Date endDate, int duration, Person responsible){
        setName(name);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setDuration(duration);
        setEffortRate(effortRate);
        setResponsible(responsible);
    }

    //Getter and Setters
    public double getEffortRate() {
        return effortRate;
    }
    public void setEffortRate(double effortRate) {
        this.effortRate = effortRate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }
    public Person getResponsible() {
        return responsible;
    }

    //Other Functions

    //toString
    @Override
    public String toString() {
        String out = "";
        //TODO: Function
        return out;
    }
}