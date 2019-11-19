package com.DEI.TP2;

import java.util.ArrayList;
import java.util.Date;

public class Master extends OrientedStudent {
    //Variables
    private ArrayList<Teacher> advisors;
    private final double COST = 1000;

    //Constructor
    public Master(String name, String email, ArrayList<Task> tasks, Date grantBegin, Date grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project, advisors);
    }

    //Getters and Setters
    public double getCost() {
        return COST;
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