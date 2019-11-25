package pt.uc.dei.student.TP2.sourceCode;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
	//constants
	public static final boolean COMPLETED = true;
	public static final boolean UNCOMPLETED = false;
	
	//Variables
    private String name, acronym;
    private LocalDate beginDate;
	private LocalDate endDate;
    private int duration;               //months
    private Teacher principalInvestigator;
    private ArrayList<Person> members;
    private ArrayList<Task> tasks;
    private boolean status;


    //Constructor
    Project(String name, String acronym, LocalDate begin, LocalDate end, int duration, Teacher principalInvestigator,ArrayList<Person> members,ArrayList<Task> tasks, boolean status){
        setName(name);
        setAcronym(acronym);
        setBeginDate(begin);
        setEndDate(end);
        setDuration(duration);
        setPrincipalInvestigator(principalInvestigator);
        setMembers(members);
        setTasks(tasks);
        setStatus(status);
    }

    //Getter - Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAcronym() {
        return acronym;
    }
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDate begin) {
        this.beginDate = begin;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate end) {
        this.endDate = end;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public ArrayList<Person> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    public Teacher getPrincipalInvestigator() {
        return principalInvestigator;
    }
    public void setPrincipalInvestigator(Teacher principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

    //Other Functions
    public void addMember(Person person){
        members.add(person);
    }

    public ArrayList<Task> showTask(){
        return this.getTasks();
    }

    public Task createTask(Task task){
        tasks.add(task);
        return task;
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> showCompletedTasks(){
    	ArrayList<Task> completed = new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getStatus()==COMPLETED) {
				completed.add(task);
			}
		}
		return completed;
    }

    public ArrayList<Task> showUnstartedTasks(){
    	ArrayList<Task> unstarted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(LocalDate.now().isBefore(task.getBeginDate())) {
				unstarted.add(task);
			}
		}
		return unstarted;
    }

    public ArrayList<Task> showUncompletedTasks(){
    	ArrayList<Task> uncompleted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getStatus()==UNCOMPLETED) {
				uncompleted.add(task);
			}
		}
		return uncompleted;
    }

    public ArrayList<Task> showUncompletedTasksIET(){
    	ArrayList<Task> uncompleted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getStatus()==UNCOMPLETED && LocalDate.now().isAfter(task.getEndDate())) {
				uncompleted.add(task);
			}
		}
		return uncompleted;
    }

    public double projectCost(){
        double cost=0;
		for(Person member:members) {
			if(member instanceof Bachelor) {
				Bachelor bachelorStudent = (Bachelor) member;
				cost += bachelorStudent.getCost();
			}if(member instanceof Master) {
				Master master = (Master) member;
				cost += master.getCost();
			}if(member instanceof PhD) {
				PhD PhDStudent = (PhD) member;
				cost += PhDStudent.getCost();
			}
		}
        return cost;
    }

    public void endProject(){
        this.status=COMPLETED;
    }

    //toString
    @Override
    public String toString() {
        String out = "Name: "+this.getName()+
        		"\nEffort: "+this.getAcronym()+
        		"\nPr. Investigator: "+this.getPrincipalInvestigator()+
        		"\nMembers: "+this.getMembers()+
        		"\nTasks: "+this.getTasks()+
        		"\nDuration: "+this.getDuration()+
        		"\nBegin Date: "+this.getBeginDate()+
        		"\nEnd Date: "+this.getEndDate();
		return out;
    }


}
