package com.company;

import java.util.ArrayList;

public class CISUC {
    //Variables
    private ArrayList<Person> people;
    private ArrayList<Project> projects;

    //Functions
    public ArrayList<Person> getPeople() {
        return people;
    }
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public Project addProject(Project project){
        projects.add(project);
        return project;
    }


}