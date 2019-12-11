package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;

/**
 * This class represent the design task.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Design extends Task {
    /**
     * This is the constructor of the design task object.
     * 
     * @param name	This is the name of the design task.
     * @param effortRate	This is the effort rate of the design task.
     * @param beginDate	This is date when begins the design task.
     * @param endDate	This is date when ends the design task.
     * @param duration	This is the duration of the design task.
     * @param responsible	This is the person who is responsible for the design task.
     * @param status	This is the status of the design task.
     * @since 09-12-2019 
     */
    public Design(String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, double status) {
        super(name, effortRate, beginDate, endDate, duration, responsible, status);
    }
    /**
     * This method returns a string with informations about the design task.
     * @return String with informations about the design task.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        String out = "[DESIGN] "+this.getName()+" ("+this.getStatus()+"%)";
        return out;
    }
}
