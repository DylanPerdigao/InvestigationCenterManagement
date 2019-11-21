package com.DEI.TP2;

import java.util.ArrayList;

public class InvestigationCenter {
	//Variables
	private String name;
	private ArrayList<Person> people = new ArrayList<Person>();
	private ArrayList<Project> projects  = new ArrayList<Project>();

	//Constructor
	InvestigationCenter(String name){
		setName(name);
	}
	//Getter - Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

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

	//Other Functions
	public Project addProject(Project project){
		projects.add(project);
		return project;
	}

	public ArrayList<Project> showCompleted(){
		ArrayList<Project> completed = new ArrayList<>();
		//TODO: funçao
		return completed;
	}

	public ArrayList<Project> showIncompleted(){
		ArrayList<Project> incompleted = new ArrayList<>();
		//TODO: funçao
		return incompleted;
	}

	//toString
	@Override
	public String toString() {
        String out = "Name: "+this.getName()+
        		"\nPeople: "+this.getPeople()+
        		"\nProjects: "+this.getProjects();

		return out;
	}
}