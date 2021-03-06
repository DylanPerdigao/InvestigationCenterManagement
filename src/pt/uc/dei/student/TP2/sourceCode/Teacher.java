package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a teacher.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Teacher extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	//Variables
    private int mecanographicNumber;
    private String investigationArea;
    private ArrayList<Project> projects;

    /**
     * This is the constructor of the teacher object.
     * 
     * @param name	This is the name of the teacher.
     * @param email	This is the email of the teacher.
     * @param mecanographicNumber	This is mecanographic number of the teacher.
     * @param investigationArea	This is the investigation area of the teacher.
     * @param tasks	This is an ArrayList of Tasks of the teacher.
     * @param projects	This is an ArrayList of projects which the teacher is assigned to.
     * @since 09-12-2019 
     */
    Teacher(String name, String email, int mecanographicNumber, String investigationArea, ArrayList<Task> tasks, ArrayList<Project> projects){
        super(name, email, tasks);
        setMecanographicNumber(mecanographicNumber);
        setInvestigationArea(investigationArea);
        setProjects(projects);
    }
    /**
     * This is the constructor of the teacher object with all atributed initilized with null
     * 
     * @since 10-12-2019 
     */
    Teacher() {
    	super(null, null, null);
        setMecanographicNumber(-1);
        setInvestigationArea(null);
        setProjects(null);
	}

	/**
     * This method gets the mecanographic number of the teacher.
     * @return Mecanographic number of the teacher.
     * @since 09-12-2019
     */
    public int getMecanographicNumber() {
        return mecanographicNumber;
    }
    /**
     * This method sets the mecanographic number of the teacher.
     * @param mecanographicNumber	This is the mecanographic number of the teacher.
     * @since 09-12-2019
     */
    public void setMecanographicNumber(int mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
    }
    /**
     * This method gets the investigation area of the teacher.
     * @return Investigation area of the teacher.
     * @since 09-12-2019
     */
    public String getInvestigationArea() {
        return investigationArea;
    }
    /**
     * This method sets the investigation area of the teacher.
     * @param investigationArea	This is the investigation area of the teacher.
     * @since 09-12-2019
     */
    public void setInvestigationArea(String investigationArea) {
        this.investigationArea = investigationArea;
    }
    /**
     * This method gets the list of projects of the teacher.
     * @return ArrayList of projects which the teacher is assigned to.
     * @since 09-12-2019
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }
    /**
     * This method sets the projects assigned to the teacher.
     * @param projects	This is the projects assigned to the teacher.
     * @since 09-12-2019
     */
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
    /**
     * This method adds a project to the teacher.
     * @param project	This is the project that will be added to the teacher.
     * @since 12-12-2019
     */
    public void addProject(Project project) {
        this.projects.add(project);
    }
    /**
     * This method removes a project from the teacher.
     * @param project	This is the project that will be removed from the teacher.
     * @since 12-12-2019
     */
    public void removeProject(Project project) {
        this.projects.remove(project);
    }
    /**
     * This method returns a string with information about the teacher.
     * @return String with information about the teacher.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        return "[Teacher]\t"+ this.getName();
    }
}
