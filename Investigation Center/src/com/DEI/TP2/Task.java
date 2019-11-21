package com.DEI.TP2;

import java.time.LocalDate;

public class Task {
    //Variables
    private String name;
    private double effortRate;
    private int duration;
    private LocalDate beginDate, endDate;
    private Person responsible;

    //Constructor
    Task( String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible){
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

    public LocalDate getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
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
        String out = "Name: "+this.getName()+
        		"\nEffort: "+this.getEffortRate()+
        		"\nResponsible: "+this.getResponsible()+
        		"\nDuration (month): "+this.getDuration()+
        		"\nBegin Date: "+this.getBeginDate()+
        		"\nEnd Date: "+this.getEndDate();
        return out;
    }
}