package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the PhD (Philosophiæ Doctor)
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */
public class PhD extends Grantee {
    //Variables
    private final double COST = 1200;

    /**
     * This is the constructor of the PhD (Philosophiæ Doctor) object.
     * 
     * @param name	This is the name of the PhD.
     * @param email	This is the email of the PhD.
     * @param tasks	This is an ArrayList of Tasks of the PhD.
     * @param grantBegin	This is the date when begins the Grant of the PhD.
     * @param grantEnd	This is the date when ends the Grant of the PhD.
     * @param project	This is the project which the PhD is assigned to.
     * @since 05-12-2019
     */
    public PhD(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project) {
        super(name, email, tasks, grantBegin, grantEnd, project);
    }
    /**
     * This method gets the cost per month of the PhD.
     * @return Cost per month of the PhD
     * @since 05-12-2019
     */
	public double getCost() {
		return COST;
	}
    /**
     * This method returns a string with informations about the PhD.
     * @return String with informations about the PhD.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
    			"\nEmail: "+this.getEmail()+
        		"\nGrant Begin: "+this.getGrantBegin()+
        		"\nGrant End: "+this.getGrantEnd()+
        		"\nTasks: "+this.getTasks()+
    			"\nProject: "+this.getProject()+
    			"\nCost: "+this.getCost();
        return out;
    }

}
