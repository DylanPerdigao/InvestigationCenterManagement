package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the advised students of a project (Bachelor and Master students)
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */

public class AdvisedStudent extends  Grantee implements Serializable{
	private static final long serialVersionUID = 1L;
    private ArrayList<Teacher> advisors;

    /**
     * This is the constructor of the advised students object.
     * 
     * @param name	This is the name of the student.
     * @param email	This is the email of the student.
     * @param tasks	This is an ArrayList of Tasks of the student.
     * @param grantBegin	This is the date when begins the Grant of the student.
     * @param grantEnd	This is the date when ends the Grant of the student.
     * @param project	This is the project which the student is assigned to.
     * @param advisors	This is an ArrayList of the Advisors of the student.
     * @since 05-12-2019
     */
    public AdvisedStudent(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project);
        this.advisors = advisors;
    }

    /**
     * This method gets the ArrayList of advisors of the advised student.
     * @return ArrayList of advisors of the advised student.
     * @since 05-12-2019
     */
    public ArrayList<Teacher> getAdvisors() {
        return advisors;
    }
    /**
     * This method sets the ArrayList of advisors of the advised student.
     * @param advisors	ArrayList of advisors of the student
     * @since 05-12-2019
     */
    public void setAdvisors(ArrayList<Teacher> advisors) {
        this.advisors = advisors;
    }
    /**
     * This method adds an advisor to the advised student.
     * @param advisor	Advisor that wil be added to the student
     * @since 12-12-2019
     */
    public void addAdvisor(Teacher advisor) {
        this.advisors.add(advisor);
    }
    /**
     * This method returns a string with informations about the advised student.
     * @return String with informations about the advised student.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        return "Name: "+ this.getName()+
    			"\nEmail: "+ this.getEmail()+
        		"\nGrant Begin: "+ this.getGrantBegin()+
        		"\nGrant End: "+ this.getGrantEnd()+
        		"\nTasks: "+ this.getTasks()+
    			"\nProject: "+ this.getProject()+
    			"\nAdvisors: "+ this.getAdvisors();
    }
}
