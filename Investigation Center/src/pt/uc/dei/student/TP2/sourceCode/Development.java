package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;

/**
 * This class represent the development task.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Development extends Task {
    /**
     * This is the constructor of the development task object.
     * 
     * @param name	This is the name of the  development task.
     * @param effortRate	This is the effort rate of the development task.
     * @param beginDate	This is date when begins the development task.
     * @param endDate	This is date when ends the development task.
     * @param duration	This is the duration of the development task.
     * @param responsible	This is the person who is responsible for the development task.
     * @param status	This is the status of the development task.
     * @since 09-12-2019 
     */
    public Development(String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, boolean status) {
        super(name, effortRate, beginDate, endDate, duration, responsible, status);
    }
    /**
     * This method returns a string with informations about the development task.
     * @return String with informations about the development task.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
        		"\nEffort: "+this.getEffortRate()+
        		"\nResponsible: "+this.getResponsible()+
        		"\nDuration (month): "+this.getDuration()+
        		"\nBegin Date: "+this.getBeginDate()+
        		"\nEnd Date: "+this.getEndDate();
        return out;
    }
}