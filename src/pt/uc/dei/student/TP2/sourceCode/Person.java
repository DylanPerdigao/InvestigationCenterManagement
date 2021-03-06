package pt.uc.dei.student.TP2.sourceCode;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represent a person.
 * 
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
    //Variables
    private  String name, email;
    private ArrayList<Task> tasks;

    /**
     * This is the constructor of the person object.
     * 
     * @param name	This is the name of the person.
     * @param email	This is the email of the person.
     * @param tasks	This is an ArrayList of Tasks of the person.
     * @since 05-12-2019 
     */
    Person(String name, String email, ArrayList<Task> tasks){
        setName(name);
        setEmail(email);
        setTasks(tasks);

	}
	/**
     * This method gets the name of the person.
     * @return Name of the person.
     * @since 05-12-2019
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets the name of the person.
     * @param name	This is the name of the person.
     * @since 05-12-2019
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the email of the person.
     * @return email of the person.
     * @since 05-12-2019
     */
    public String getEmail() {
        return email;
    }
    /**
     * This method sets the email of the person.
     * @param email	This is the email of the person.
     * @since 05-12-2019
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * This method gets ArrayList of tasks of the person.
     * @return ArrayList of tasks of the person.
     * @since 05-12-2019
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    /**
     * This method sets the ArrayList of tasks of the person.
     * @param tasks	This is the ArrayList of tasks of the person.
     * @since 05-12-2019
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    /**
     * This method adds a task to the ArrayList of tasks of the person.
     * @param task	This is the tasks that is going to be added to the person.
     * @since 12-12-2019
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    /**
     * This method removes a task from the ArrayList of tasks of the person.
     * @param task	This is the tasks that is going to be removed from the person.
     * @since 12-12-2019
     */
    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    /**
     * This method verify if the person is surcharged with his task and if he can have another one.
     * @param newTask This is a potential task that can be added (or not) to the person.
     * @return boolean Says if the task can be added.
     * @since 05-12-2019
     */
    public boolean isSurcharged(Task newTask) {
    	double effort = newTask.getEffortRate();
    	for(Task task: tasks) {
    		effort+=task.getEffortRate();
    	}
        return (effort > 1.0);
    }

    /**
     * This method returns a string with informations about the person.
     * @return String with informations about the person.
     * @since 05-12-2019
     */
    @Override
    public String toString() {
        return this.getName();
    }
}

