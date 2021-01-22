package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represent the documentation task.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Documentation extends Task implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final double effortRate = 0.25;
    /**
     * This is the constructor of the documentation task object.
     * 
     * @param name	This is the name of the  documentation task.
     * @param beginDate	This is date when begins the documentation task.
     * @param endDate	This is date when ends the documentation task.
     * @param duration	This is the duration of the documentation task.
     * @param responsible	This is the person who is responsible for the documentation task.
     * @param status	This is the status of the documentation task.
     * @since 09-12-2019 
     */
    public Documentation(String name, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, double status) {
        super(name, effortRate, beginDate, endDate, duration, responsible, status);
    }
    /**
     * This method returns a string with informations about the documentation task.
     * @return String with informations about the documentation task.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        return "[DOC] "+ this.getName()+" ("+ this.getStatus()+"%)";
    }
}
