package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the Bachelor student
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */
public class Bachelor extends AdvisedStudent {
    //Variables
    private final double COST = 800;

    //Constructor
    public Bachelor(String name, String email, ArrayList<Task> tasks, LocalDate grantBegin, LocalDate grantEnd, Project project, ArrayList<Teacher> advisors) {
        super(name, email, tasks, grantBegin, grantEnd, project,advisors);
    }

    //Getters and Setters
    public double getCost() {
        return COST;
    }

    //Other Functions

    //toString
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
    			"\nEmail: "+this.getEmail()+
        		"\nGrant Begin: "+this.getGrantBegin()+
        		"\nGrant End: "+this.getGrantEnd()+
        		"\nTasks: "+this.getTasks()+
    			"\nProject: "+this.getProject()+
    			"\nAdvisors: "+this.getAdvisors()+
    			"\nCost: "+this.getCost();
        return out;
    }
}
