package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the PhD (Philosophiæ Doctor)
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */
public class PhD extends Grantee implements Serializable{
	private static final long serialVersionUID = 1L;
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
    PhD(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project) {
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
        String out = "[PhD]\t\t" +this.getName();
        return out;
    }

}
