package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents a bachelor student.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */
public class Bachelor extends AdvisedStudent implements Serializable{
	private static final long serialVersionUID = 1L;
	private final double COST = 800;
    /**
     * This is the constructor of the bachelor student object.
     * 
     * @param name	This is the name of the bachelor student.
     * @param email	This is the email of the bachelor student.
     * @param tasks	This is an ArrayList of Tasks of the bachelor student.
     * @param grantBegin	This is the date when begins the Grant of the bachelor student.
     * @param grantEnd	This is the date when ends the Grant of the bachelor student.
     * @param project	This is the project which the bachelor student is assigned to.
     * @param advisors	This is an ArrayList of the Advisors of the bachelor student.
     * @since 05-12-2019 
     */
    Bachelor(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project,advisors);
    }

    /**
     * This method gets the cost per month of the bachelor student.
     * @return Cost per month of the bachelor student.
     * @since 05-12-2019
     */
    public double getCost() {
        return COST;
    }

    /**
     * This method returns a string with informations about the bachelor student.
     * @return String with informations about the bachelor student.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        return "[Bachelor]\t"+ this.getName();
    }
}
