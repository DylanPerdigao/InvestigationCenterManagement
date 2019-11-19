package com.DEI.TP2;

import java.util.ArrayList;
import java.util.Date;

public class Grantee extends Person{
    //Variables
    private Date grantBegin, grantEnd;
    private Project project;

    //Constructor
    Grantee(String name, String email, ArrayList<Task> tasks, Date grantBegin, Date grantEnd, Project project){
        super(name, email, tasks);
        setGrantBegin(grantBegin);
        setGrantEnd(grantEnd);
        setProject(project);
    }

    //Getter and Setters

    public Date getGrantBegin() {
        return grantBegin;
    }
    public void setGrantBegin(Date grantBegin) {
        this.grantBegin = grantBegin;
    }

    public Date getGrantEnd() {
        return grantEnd;
    }
    public void setGrantEnd(Date grantEnd) {
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
        String out = "";
        //TODO: Function
        return out;
    }
}
