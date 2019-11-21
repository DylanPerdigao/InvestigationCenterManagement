package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrientedStudent extends  Grantee {
    //Variables
    private ArrayList<Teacher> advisors;

    //Constructor
    public OrientedStudent(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project);
        this.advisors = advisors;
    }

    //Getters and Setters
    public ArrayList<Teacher> getAdvisors() {
        return advisors;
    }
    public void setAdvisors(ArrayList<Teacher> advisors) {
        this.advisors = advisors;
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
    			"\nAdvisors: "+this.getAdvisors();
        return out;
    }
}
