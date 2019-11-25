package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;

public class Task {
    //Variables
    private String name;
    private double effortRate;
    private int duration;
    private LocalDate beginDate, endDate;
    private Person responsible;
    private boolean status;

    //Constructor
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

    //Other Functions

    //toString
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