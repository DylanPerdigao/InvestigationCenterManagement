package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represent the Investigation Center.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class InvestigationCenter implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final boolean COMPLETED = true;
	private static final boolean UNCOMPLETED = false;
	private String name;
	private ArrayList<Person> people;
	private ArrayList<Project> projects;

    /**
     * This is the constructor of the investigation center object.
     * 
     * @param name	This is the name of the investigation center.
     * @param people	This is the ArrayList of the people of the investigation center.
     * @param projects	This is the ArrayList of the projects of the investigation center.
     * @since 09-12-2019 
     */
	public InvestigationCenter(String name,ArrayList<Person> people,ArrayList<Project> projects){
		setName(name);
		setPeople(people);
		setProjects(projects);
	}
    /**
     * This method gets the name of the investigation center.
     * @return Name of the investigation center.
     * @since 09-12-2019
     */
	public String getName() {
		return name;
	}
    /**
     * This method sets the name of the investigation center.
     * @param name	This is the name of the investigation center.
     * @since 09-12-2019
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * This method gets the people of the investigation center.
     * @return ArrayList of people of the investigation center.
     * @since 09-12-2019
     */
	public ArrayList<Person> getPeople() {
		return people;
	}
    /**
     * This method sets the people of the investigation center.
     * @param people	This is the ArrayList of the people of the investigation center.
     * @since 09-12-2019
     */
	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
    /**
     * This method gets the projects of the investigation center.
     * @return ArrayList of projects of the investigation center.
     * @since 09-12-2019
     */
	public ArrayList<Project> getProjects() {
		return projects;
	}
    /**
     * This method sets the projects of the investigation center.
     * @param projects	This is the ArrayList of the projects of the investigation center.
     * @since 09-12-2019
     */
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
    /**
     * This method creates a project for the investigation center.
     * @param project    This is the project who is added to the investigation center.
     * @since 09-12-2019
     */
	public void addProject(Project project){
		projects.add(project);
	}
	/**
	 * This method removes a project for the investigation center.
	 * @param project	This is the project who is going to be removed from the investigation center.
	 * @since 09-12-2019
	 */
	public void removeProject(Project project){
		projects.remove(project);
	}
    /**
     * This method search in the list of projects which are completed after that, it will returns the completed projects of the investigation center.
     * @return Completed tasks of the project.
     * @since 09-12-2019
     */

	public ArrayList<Project> showCompleted(){
		ArrayList<Project> completed = new ArrayList<Project>();
		for(Project project:projects) {
			if(project.getStatus()==COMPLETED) {
				completed.add(project);
			}
		}
		return completed;
	}
    /**
     * This method search in the list of projects which are uncompleted after that, it will returns the uncompleted projects of the investigation center.
     * @return Uncompleted tasks of the project.
     * @since 09-12-2019
     */
	public ArrayList<Project> showUncompleted(){
		ArrayList<Project> uncompleted = new ArrayList<Project>();
		for(Project project:projects) {
			if(project.getStatus()==UNCOMPLETED) {
				uncompleted.add(project);
			}
		}
		return uncompleted;
	}
    /**
     * This method returns a string with informations about the investigation center.
     * @return String with informations about the investigation center.
     * @since 09-12-2019
     */
	@Override
	public String toString() {
		return this.getName();
	}
}