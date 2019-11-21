package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Licensed extends OrientedStudent {
    //Variables
    private final double COST = 800;

    //Constructor
    public Licensed(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project,advisors);
    }

    //Getters and Setters
    public double getCost() {
        return COST;
    }

    //Other Functions

    //toString
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
    			"\nEmail: "+this.getEmail()+
        		"\nGrant Begin: "+this.getGrantBegin()+
        		"\nGrant End: "+this.getGrantEnd()+
        		"\nTasks: "+this.getTasks()+
    			"\nProject: "+this.getProject()+
    			"\nAdvisors: "+this.getAdvisors()+
    			"\nCost: "+this.getCost();
        return out;
    }
}
