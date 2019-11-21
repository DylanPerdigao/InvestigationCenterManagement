package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grantee extends Person{
    //Variables
    private LocalDate grantBegin, grantEnd;
    private Project project;

    //Constructor
    Grantee(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin,LocalDate grantEnd, Project project){
        super(name, email, tasks);
        setGrantBegin(grantBegin);
        setGrantEnd(grantEnd);
        setProject(project);
    }

    //Getter and Setters

    public LocalDate getGrantBegin() {
        return grantBegin;
    }
    public void setGrantBegin(LocalDate grantBegin) {
        this.grantBegin = grantBegin;
    }

    public LocalDate getGrantEnd() {
        return grantEnd;
    }
    public void setGrantEnd(LocalDate grantEnd) {
        this.grantEnd = grantEnd;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
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
    			"\nProject: "+this.getProject();
        return out;
    }
}
