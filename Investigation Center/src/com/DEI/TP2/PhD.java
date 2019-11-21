package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class PhD extends Grantee {
    //Variables
    private final double COST = 1200;

    //Constructor
    public PhD(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project) {
        super(name, email, tasks, grantBegin, grantEnd, project);
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
    			"\nCost: "+this.getCost();
        return out;
    }

}
