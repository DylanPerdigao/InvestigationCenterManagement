package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents a person who has a Grant.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */

public class Grantee extends Person{
    //Variables
    private LocalDate grantBegin, grantEnd;
    private Project project;

    /**
     * This is the constructor of the grantee object.
     * 
     * @param name	This is the name of the grantee.
     * @param email	This is the email of the grantee.
     * @param tasks	This is an ArrayList of Tasks of the grantee.
     * @param grantBegin	This is the date when begins the Grant of the grantee.
     * @param grantEnd	This is the date when ends the Grant of the grantee.
     * @param project	This is the project which the grantee is assigned to.
     * @since 09-12-2019 
     */
    Grantee(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin,LocalDate grantEnd, Project project){
        super(name, email, tasks);
        setGrantBegin(grantBegin);
        setGrantEnd(grantEnd);
        setProject(project);
    }

    /**
     * This method gets the the begin of the grant.
     * @return Date of the begin of the grant.
     * @since 09-12-2019
     */
    public LocalDate getGrantBegin() {
        return grantBegin;
    }
    /**
     * This method sets the begin of the grant.
     * @param grantBegin	This is the date where the grant begins.
     * @since 09-12-2019
     */
    public void setGrantBegin(LocalDate grantBegin) {
        this.grantBegin = grantBegin;
    }
    /**
     * This method gets the end of the grant.
     * @return Date of the end of the grant.
     * @since 09-12-2019
     */
    public LocalDate getGrantEnd() {
        return grantEnd;
    }
    /**
     * This method sets the end of the grant.
     * @param grantEnd	This is the date where the grant ends.
     * @since 09-12-2019
     */
    public void setGrantEnd(LocalDate grantEnd) {
        this.grantEnd = grantEnd;
    }
    /**
     * This method gets the project where the grantee is assigned to.
     * @return Project assigned to the grantee.
     * @since 09-12-2019
     */
    public Project getProject() {
        return project;
    }
    /**
     * This method sets the project assigned to the grantee.
     * @param project	This is the project assigned to the grantee.
     * @since 09-12-2019
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * This method returns a string with informations about the grantee.
     * @return String with informations about the grantee.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
    			"\nEmail: "+this.getEmail()+
        		"\nGrant Begin: "+this.getGrantBegin()+
        		"\nGrant End: "+this.getGrantEnd()+
        		"\nTasks: "+this.getTasks()+
    			"\nProject: "+this.getProject();
        return out;
    }
}
