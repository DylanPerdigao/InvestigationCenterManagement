package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the master student.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */
public class Master extends AdvisedStudent implements Serializable{
	private static final long serialVersionUID = 1L;
    //Variables
    private final double COST = 1000;

    /**
     * This is the constructor of the master student object.
     * 
     * @param name	This is the name of the master student.
     * @param email	This is the email of the master student.
     * @param tasks	This is an ArrayList of Tasks of the master student.
     * @param grantBegin	This is the date when begins the Grant of the master student.
     * @param grantEnd	This is the date when ends the Grant of the master student.
     * @param project	This is the project which the master student is assigned to.
     * @param advisors	This is an ArrayList of the Advisors of the master student.
     * @since 05-12-2019 
     */
    public Master(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project, advisors);
    }

    /**
     * This method gets the cost per month of the master student.
     * @return Cost per month of the master student.
     * @since 05-12-2019
     */
    public double getCost() {
        return COST;
    }

    /**
     * This method returns a string with informations about the master student.
     * @return String with informations about the master student.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        String out = "[Master]\t"+this.getName();
        return out;
    }
}