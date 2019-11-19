package com.DEI.TP2;

import java.util.ArrayList;
import java.util.Date;

public class OrientedStudent extends  Grantee {
    //Variables
    private ArrayList<Teacher> advisors;

    //Constructor
    public OrientedStudent(String name, String email, ArrayList<Task> tasks, Date grantBegin, Date grantEnd, Project project, ArrayList<Teacher> advisors) {
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
        String out = "";
        //TODO: Function
        return out;
    }
}
