package com.DEI.TP2;

import java.util.ArrayList;

public class Teacher extends Person {
    //Variables
    private int mecanographicNumber;
    private String investigationArea;
    private ArrayList<Project> projects;

    //Constructor
    Teacher(String name, String email, int mecanographicNumber, String investigationArea, ArrayList<Task> tasks, ArrayList<Project> projects){
        super(name, email, tasks);
        setMecanographicNumber(mecanographicNumber);
        setInvestigationArea(investigationArea);
        setProjects(projects);
    }

    //Getters and Setters
    public int getMecanographicNumber() {
        return mecanographicNumber;
    }
    public void setMecanographicNumber(int mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
    }

    public String getInvestigationArea() {
        return investigationArea;
    }
    public void setInvestigationArea(String investigationArea) {
        this.investigationArea = investigationArea;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    //Other Projects


    //tosString

    @Override
    public String toString() {
        String out = "";
        //TODO: Function
        return out;
    }
}
