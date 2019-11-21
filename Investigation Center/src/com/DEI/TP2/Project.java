package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    //Variables
    private String name, acronym;
    private LocalDate beginDate;
	private LocalDate endDate;
    private int duration;               //months
    private ArrayList<Person> members;
    private Teacher principalInvestigator;
    private ArrayList<Task> tasks;


    //Constructor
    Project(String name, String acronym, LocalDate begin, LocalDate end, int duration, ArrayList<Person> members){
        setName(name);
        setAcronym(acronym);
        setBeginDate(begin);
        setEndDate(end);
        setDuration(duration);
        setMembers(members);
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

    //Other Functions
    public void addMember(Person person){
        members.add(person);
    }

    public void showTask(){
        //TODO: printa tasks
    }

    public Task createTask(Task task){
        tasks.add(task);
        return task;
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public void refreshCompletedTasks(){
        //TODO: Function
    }

    public void showUnstartedTasks(){
        //TODO: Function
    }

    public void showUncompletedTasks(){
        //TODO: Function
    }

    public void showUncompletedTasksIET(){
        //TODO: Function
    }

    public double projectCost(){
        double cost=0;
        //TODO: Function- iterar pelos members e ver o custo de cada um e somar ao cost.
        return cost;
    }

    public void endProject(){
        //TODO: Function
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
