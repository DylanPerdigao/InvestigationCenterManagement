package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;

public class Documentation extends Task {
    //Constructor
    public Documentation(String name, double effortRate, LocalDate beginDate, LocalDate endDate, int duration, Person responsible, boolean status) {
        super(name, effortRate, beginDate, endDate, duration, responsible, status);
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
