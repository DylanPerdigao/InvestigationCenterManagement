package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;

/**
 * This class represent the task.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Task {
    //Variables
    private String name;
    private double effortRate;
    private int duration;
    private LocalDate beginDate, endDate;
    private Person responsible;
    private boolean status;

    /**
     * This is the constructor of the task object.
     * 
     * @param name	This is the name of the task.
     * @param effortRate	This is the effort rate of the task.
     * @param beginDate	This is date when begins the task.
     * @param endDate	This is date when ends the task.
     * @param duration	This is the duration of the task.
     * @param responsible	This is the person who is responsible for the task.
     * @param status	This is the status of the task.
     * @since 09-12-2019 
     */
    Task( String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, boolean status){
        setName(name);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setDuration(duration);
        setEffortRate(effortRate);
        setResponsible(responsible);
        setStatus(status);
    }

    //Getter and Setters
    public double getEffortRate() {
        return effortRate;
    }
    public void setEffortRate(double effortRate) {
        this.effortRate = effortRate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }
    public Person getResponsible() {
        return responsible;
    }
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
    /**
     * This method returns a string with informations about the task.
     * @return String with informations about the task.
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