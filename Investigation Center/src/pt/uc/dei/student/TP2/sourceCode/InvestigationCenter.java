package pt.uc.dei.student.TP2.sourceCode;

import java.util.ArrayList;

public class InvestigationCenter {
	//constants
	public static final boolean COMPLETED = true;
	public static final boolean UNCOMPLETED = false;
	
	//Variables
	private String name;
	private ArrayList<Person> people;
	private ArrayList<Project> projects;

	//Constructor
	public InvestigationCenter(String name,ArrayList<Person> people,ArrayList<Project> projects){
		setName(name);
		setPeople(people);
		setProjects(projects);
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
		ArrayList<Project> completed = new ArrayList<Project>();
		for(Project project:projects) {
			if(project.getStatus()==COMPLETED) {
				completed.add(project);
			}
		}
		return completed;
	}

	public ArrayList<Project> showIncompleted(){
		ArrayList<Project> uncompleted = new ArrayList<Project>();
		for(Project project:projects) {
			if(project.getStatus()==UNCOMPLETED) {
				uncompleted.add(project);
			}
		}
		return uncompleted;
	}

	//toString
	@Override
	public String toString() {
		return this.getName();
	}
}