package com.DEI.TP2;

import java.util.ArrayList;

public class InvestigationCenter {
	//Variables
	private String name;
	private ArrayList<Person> people = new ArrayList<>();
	private ArrayList<Project> projects  = new ArrayList<>();

	//Constructor
	InvestigationCenter(String name){
		this.name=name;
	}
	//Getter - Setter
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
		String out = "";
		//TODO: funçao
		return out;
	}
}