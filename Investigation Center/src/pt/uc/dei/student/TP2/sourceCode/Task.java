package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represent the task.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
    private String name;
    private double effortRate;
    private int duration;
    private LocalDate beginDate, endDate;
    private Person responsible;
    private double status;

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
    Task(String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, double status){
        setName(name);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setDuration(duration);
        setEffortRate(effortRate);
        setResponsible(responsible);
        setStatus(status);
    }
    /**
     * This is the constructor of the task object with the responsible person initialized to null;
     * 
     * @param name	This is the name of the task.
     * @param effortRate	This is the effort rate of the task.
     * @param beginDate	This is date when begins the task.
     * @param endDate	This is date when ends the task.
     * @param duration	This is the duration of the task.
     * @param status	This is the status of the task.
     * @since 09-12-2019 
     */
    Task(String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, double status) {
        setName(name);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setDuration(duration);
        setEffortRate(effortRate);
        setResponsible(new Person());
        setStatus(status);
	}

	/**
     * This method gets the name of the task.
     * @return Name of the task.
     * @since 09-12-2019
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets the name of the task.
     * @param name	This is the name of the task.
     * @since 09-12-2019
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the effort rate of the task.
     * @return Effort rate of the task.
     * @since 09-12-2019
     */
    public double getEffortRate() {
        return effortRate;
    }
    /**
     * This method sets the effort rate of the task.
     * @param effortRate	This is the effort rate of the task.
     * @since 09-12-2019
     */
    public void setEffortRate(double effortRate) {
        this.effortRate = effortRate;
    }
    /**
     * This method gets the date where the task begins.
     * @return Date where the task begins.
     * @since 09-12-2019
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }
    /**
     * This method sets the date where the task begins.
     * @param beginDate	This is the date where the task begins.
     * @since 09-12-2019
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    /**
     * This method gets the date where the task ends.
     * @return Date where the task ends.
     * @since 09-12-2019
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    /**
     * This method sets the date where the task ends.
     * @param endDate	This is the date where the task ends.
     * @since 09-12-2019
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    /**
     * This method gets the duration of the task.
     * @return Duration of the task.
     * @since 09-12-2019
     */
    public int getDuration() {
        return duration;
    }
    /**
     * This method sets the duration of the task.
     * @param duration	This is the duration of the task.
     * @since 09-12-2019
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /**
     * This method gets the person responsible for the task
     * @return Person responsible for the task
     * @since 09-12-2019
     */
    public Person getResponsible() {
        return responsible;
    }
    /**
     * This method sets the person responsible for the task
     * @param responsible	This is the person responsible for the task
     * @since 09-12-2019
     */
    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }
    /**
     * This method gets the status of the task.
     * @return Status of the task.
     * @since 09-12-2019
     */
	public double getStatus() {
		return status;
	}
    /**
     * This method sets the status of the task.
     * @param status	This is the status of the task.
     * @since 09-12-2019
     */
	public void setStatus(double status) {
		this.status = status;
	}
    /**
     * This method returns a string with informations about the task.
     * @return String with informations about the task.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        String out = this.getName()+" ("+this.getStatus()+"%) ---> " + this.getResponsible();
        return out;
    }


}