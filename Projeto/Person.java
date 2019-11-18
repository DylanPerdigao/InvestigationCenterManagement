package com.company;

import java.util.ArrayList;

public class Person {
    //Variables
    private  String name, email;
    private ArrayList<Task> tasks;

    //Constructor
    Person(String name, String email){
        this.name=name;
        this.email=email;
    }
    //Getter - Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    //Other Functions


    //toString
    @Override
    public String toString() {
        String out = "";
        //TODO: funçao
        return out;
    }
}

