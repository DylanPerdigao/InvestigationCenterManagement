package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represent the project.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	09-12-2019
 * @version	1.0
 */
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
    private String name, acronym;
    private LocalDate beginDate,endDate;
    private int duration;
    private Teacher principalInvestigator;
    private ArrayList<Person> members;
    private ArrayList<Task> tasks;
    private boolean status;

    /**
     * This is the constructor of the project object.
     * 
     * @param name	This is the name of the project.
     * @param acronym	This is the acronym of the project.
     * @param beginDate	This is date when begins the project.
     * @param endDate	This is date when ends the project.
     * @param duration	This is the duration in months of the project.
     * @param principalInvestigator	This is the principal Investigator involved in the project.
     * @param members	This is the ArrayList of the members of the project.
     * @param tasks	This is the ArrayList of the tasks of the project.
     * @param status	This is the status of the project.
     * @since 09-12-2019 
     */
    public Project(String name, String acronym, LocalDate beginDate, LocalDate endDate, int duration, Teacher principalInvestigator, ArrayList<Person> members, ArrayList<Task> tasks, boolean status){
        setName(name);
        setAcronym(acronym);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setDuration(duration);
        setPrincipalInvestigator(principalInvestigator);
        setMembers(members);
        setTasks(tasks);
        setStatus(status);
    }
    /**
     * This is the constructor of the project object with all attributes initialized with null.
     * 
     * @since 10-12-2019 
     */

	/**
     * This method gets the name of the project.
     * @return Name of the project.
     * @since 09-12-2019
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets the name of the project.
     * @param name	This is the name of the project.
     * @since 09-12-2019
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the acronym of the project.
     * @return Acronym of the project.
     * @since 09-12-2019
     */
    public String getAcronym() {
        return acronym;
    }
    /**
     * This method sets the acronym of the project.
     * @param acronym	This is the acronym of the project.
     * @since 09-12-2019
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    /**
     * This method gets the date where the project begins.
     * @return Date where the project begins.
     * @since 09-12-2019
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }
    /**
     * This method sets the date where the project begins.
     * @param beginDate	This is the date where the project begins.
     * @since 09-12-2019
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    /**
     * This method gets the date where the project ends.
     * @return Date where the project ends.
     * @since 09-12-2019
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    /**
     * This method sets the date where the project ends.
     * @param endDate	This is the date where the project ends.
     * @since 09-12-2019
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    /**
     * This method gets the duration of the project.
     * @return Duration of the project.
     * @since 09-12-2019
     */
    public int getDuration() {
        return duration;
    }
    /**
     * This method sets the duration of the project.
     * @param duration	This is the duration of the project.
     * @since 09-12-2019
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /**
     * This method gets the members of the project.
     * @return ArrayList of members of the project.
     * @since 09-12-2019
     */
    public ArrayList<Person> getMembers() {
        return members;
    }
    /**
     * This method sets the members of the project.
     * @param members	This is the ArrayList of the members of the project.
     * @since 09-12-2019
     */
    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }
    /**
     * This method gets the tasks of the project.
     * @return ArrayList of tasks of the project.
     * @since 09-12-2019
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    /**
     * This method sets the tasks of the project.
     * @param tasks	This is the ArrayList of the tasks of the project.
     * @since 09-12-2019
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    /**
     * This method gets the principal investigator for the project.
     * @return Principal investigator for the project.
     * @since 09-12-2019
     */
    public Teacher getPrincipalInvestigator() {
        return principalInvestigator;
    }
    /**
     * This method sets the principal investigator for the project.
     * @param principalInvestigator	This is the principal investigator for the project.
     * @since 09-12-2019
     */
    public void setPrincipalInvestigator(Teacher principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }
    /**
     * This method gets the status of the project.
     * @return Status of the project.
     * @since 09-12-2019
     */
	public boolean getStatus() {
		return status;
	}
    /**
     * This method sets the status of the project.
     * @param status	This is the status of the project.
     * @since 09-12-2019
     */
	public void setStatus(boolean status) {
		this.status = status;
	}
    /**
     * This method add a person to the members of the project.
     * @param person	This is the person who is added to the members of the project.
     * @since 09-12-2019
     */
    public void addMember(Person person){
        members.add(person);
    }
    /**
     * This method creates a task for the project.
     * @param task    This is the task who is added to the project.
     * @since 09-12-2019
     */
    public void createTask(Task task){
        tasks.add(task);
    }
    /**
     * This method deletes a task of the project.
     * @param task	This is the task who wants to be removed of the project.
     * @since 09-12-2019
     */
    public void deleteTask(Task task){
        tasks.remove(task);
    }
    /**
     * This method search in the list of tasks which are completed after that, it will returns the completed tasks of the project.
     * @return Completed tasks of the project.
     * @since 09-12-2019
     */
    public ArrayList<Task> getCompletedTasks(){
    	ArrayList<Task> completed = new ArrayList<Task>();
		for(Task task:tasks) {
			System.out.println("TASK:"+task);
			if(task.getStatus()==100.0) {
				completed.add(task);
			}
		}
		System.out.println(completed);
		return completed;
    }
    /**
     * This method search in the list of tasks which are unstarted after that, it will returns the unstarted tasks of the project.
     * @return Unstarted tasks of the project.
     * @since 09-12-2019
     */
    public ArrayList<Task> getUnstartedTasks(){
    	ArrayList<Task> unstarted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(LocalDate.now().isBefore(task.getBeginDate())) {
				unstarted.add(task);
			}
		}
		return unstarted;
    }
    /**
     * This method search in the list of tasks which are uncompleted after that, it will returns the uncompleted tasks of the project.
     * @return Uncompleted tasks of the project.
     * @since 09-12-2019
     */
    public ArrayList<Task> getUncompletedTasks(){
    	ArrayList<Task> uncompleted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getStatus()<100.0) {
				uncompleted.add(task);
			}
		}
		return uncompleted;
    }
    /**
     * This method search in the list of tasks which are uncompleted in the estimated time after that, it will return the uncompleted tasks in the estimated time of the project.
     * @return Uncompleted tasks in the estimated time of the project.
     * @since 09-12-2019
     */
    public ArrayList<Task> getUncompletedTasksIET(){
    	ArrayList<Task> uncompleted = new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getStatus()<100.0 && LocalDate.now().isAfter(task.getEndDate())) {
				uncompleted.add(task);
			}
		}
		return uncompleted;
    }
    /**
     * This method calculates and returns the cost of the project.
     * @return Cost of the project.
     * @since 09-12-2019
     */
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
    /**
     * This method ends the project.
     * @since 09-12-2019
     */
    public void endProject(){
        this.status=true;
    }
    /**
     * This method returns a string with informations about the project.
     * @return String with informations about the project.
     * @since 09-12-2019
     */
    @Override
    public String toString() {
        String out = this.getName()+"\t("+this.getAcronym()+")";
		return out;
    }


}
