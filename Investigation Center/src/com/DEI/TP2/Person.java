package com.DEI.TP2;

import java.util.ArrayList;

public class Person {
    //Variables
    private  String name, email;
    private ArrayList<Task> tasks;

    //Constructor
    Person(String name, String email, ArrayList<Task> tasks){
        setName(name);
        setEmail(email);
        setTasks(tasks);
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
    public boolean isSurcharged(Task newTask) {
    	double effort = newTask.getEffortRate();
    	for(Task task: tasks) {
    		effort+=task.getEffortRate();
    	}
    	if(effort>1) {
    		return true;
    	}else {
    		return false;
    	}
    }

    //toString
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
        			"\nEmail: "+this.getEmail()+
        			"\nTasks: "+this.getTasks();
        return out;
    }
}

