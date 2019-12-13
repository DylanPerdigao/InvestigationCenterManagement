package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.*;

/**
 * This class represent the Graphical User Interface of the menu for manage the project with his tasks.
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	13-12-2019
 * @version	1.0
 */

public class ProjectManagementGUI{
	//Constraints
	private GridBagConstraints c = new GridBagConstraints();

	//Formatter
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	// Buttons
	private JButton buttonTaskCREATE;
	private JButton buttonTaskREMOVE;
	private JButton buttonTaskUPDATE;
	private JButton buttonRETURN;
	private JButton buttonProjectEND;
	private JButton buttonPRINCIPALINVESTIGATOR;
	private JButton buttonPersonASSIGN;
	private JButton buttonPersonINFO;
	private JButton buttonTaskINFO;
	private JButton buttonAdvisorSET;

	// List
	private DefaultListModel<Task> listValuesTasks;
	private DefaultListModel<Task> listValuesUnstartedTasks;
	private DefaultListModel<Task> listValuesUnstartedTasksIET;
	private DefaultListModel<Task> listValuesCompletedTasks ;
	private DefaultListModel<Person> listValuesMembers ;

	private JList<Task> listTasks;
	private JList<Task> listUnstartedTasks;
	private JList<Task> listUnstartedTasksIET;
	private JList<Task> listCompletedTasks;
	private JList<Person> listMembers;
	private JScrollPane listScrollerTasks;
	private JScrollPane listScrollerUnstartedTasks;
	private JScrollPane listScrollerUnstartedTasksIET;
	private JScrollPane listScrollerCompletedTasks;
	private JScrollPane listScrollerMembers;

	//Labels
	private JLabel labelPRINCIPALINVESTIGATOR;

	private JFrame frame;
	private InvestigationCenter IC;
	private Project project;
    /**
     * This is the constructor of the GUI for the project management.
     * 
     * @param frame	This is the frame of the program.
     * @param IC	This is the investigation center object which contains all the informations for the application.
     * @param project	This is the project object which contains all the informations about the selected project by the user.
     * @since 13-12-2019
     */
	public ProjectManagementGUI(JFrame frame,InvestigationCenter IC,Project project) {
		this.frame = frame;
		this.IC=IC;
		this.project=project;
		// List UNSTARTED TASK
		listValuesUnstartedTasks = new DefaultListModel<>();
		listValuesUnstartedTasks.addAll(project.getUnstartedTasks());
		listUnstartedTasks = new JList<>(listValuesUnstartedTasks);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks); 
		// List UNSTARTED TASK IN ESTIMATED TIME
		listValuesUnstartedTasksIET = new DefaultListModel<>();
		listValuesUnstartedTasksIET.addAll(project.getUncompletedTasksIET());
		listUnstartedTasksIET = new JList<>(listValuesUnstartedTasksIET);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET); 
		// List COMPLETED TASK
		listValuesCompletedTasks = new DefaultListModel<>();
		listValuesCompletedTasks.addAll(project.getCompletedTasks());
		listCompletedTasks = new JList<>(listValuesCompletedTasks);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks); 
		// List TASK
		listValuesTasks = new DefaultListModel<>();
		listValuesTasks.addAll(project.getTasks());
		listTasks = new JList<>(listValuesTasks);
		listScrollerTasks = new JScrollPane(listTasks); 
		// List Members
		listValuesMembers = new DefaultListModel<>();
		listValuesMembers.addAll(project.getMembers());
		listMembers = new JList<>(listValuesMembers);
		listScrollerMembers = new JScrollPane(listMembers); 
	}

    /**
     * This method initialize the Graphical User Interface with all components 
     * @since 13-12-2019
     */
	public void initialize(){
		frame.setLayout(new GridBagLayout());
		/*
		 * LABELS AND TITLE
		 */
		JLabel title = new JLabel(project.getName());
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 50;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		frame.add(title, c);
		//SET BLANK SPACES
		placeComponent(new JLabel(""),0,16,1,1,0.5,10, 0, 0);
		placeComponent(new JLabel(""),7,19,1,1,0.5,50, 0, 0);
		placeComponent(new JLabel(""),3,18,1,1,0.5,50, 0, 0);
		//RETURN
		buttonRETURN = new JButton("Return");
		placeComponent(buttonRETURN,2,17,1,1,0.5,0, 0, 10);
		/*
		 * TASKS
		 */
		//UNSTARTED
		placeComponent(new JLabel("Unstarted Tasks"),2,1,1,1,0.5,0.5, 0, 0);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks);
		placeComponent(listScrollerUnstartedTasks,2,2,1,3,0.5,5,100, 10);
		//UNCOMPLETED IN ESTIMATED TIME
		placeComponent(new JLabel("Uncompleted Tasks in Estimated Time"),2,5,1,1,0.5,0.5,0, 0);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET);
		placeComponent(listScrollerUnstartedTasksIET,2,6,1,3,0.5,5,100, 10);
		//COMPLETED
		placeComponent(new JLabel("Completed Tasks"),2,10,1,1,0.5,0.5,0,0);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks);
		placeComponent(listScrollerCompletedTasks,2,11,1,4,0.5,5,100, 10);
		//TASKS
		placeComponent(new JLabel("Tasks"),4,5,2,1,0.5,0.5,0,0);
		listScrollerTasks = new JScrollPane(listTasks);
		placeComponent(listScrollerTasks,4,6,2,2,0.5,10,100,10);
		//TASK INFO
		buttonTaskINFO = new JButton("Show Task Information");
		placeComponent(buttonTaskINFO,6,6,1,1,0.5,0, 0, 50);
		/*
		 * PEOPLE
		 */
		//PRINCIPAL INVESTIGATOR
		placeComponent(new JLabel("Principal Investigator"),4,1,1,1,0.5,0.5,0, 0);
		if(project.getPrincipalInvestigator()!=null) {
			labelPRINCIPALINVESTIGATOR = new JLabel(project.getPrincipalInvestigator().getName());
		}
		else{
			labelPRINCIPALINVESTIGATOR = new JLabel("NO PRINCIPAL INVESTIGATOR");
		}
		placeComponent(labelPRINCIPALINVESTIGATOR,5,1,1,1,0.5,0.5,0,0);
		//MEMBERS
		placeComponent(new JLabel("Members"),4,2,2,1,0.5,0.5,0,0);
		listScrollerMembers = new JScrollPane(listMembers);
		placeComponent(listScrollerMembers,4,3,2,2,0.5,10,100,10);
		//MEMBERS INFO
		buttonPersonINFO = new JButton("Show Member Information");
		placeComponent(buttonPersonINFO,6,3,1,1,0.5,0.5,0,0);
		/*
		 * PROJECT
		 */
		placeComponent(new JLabel("Begin"),4,11,2,1,0.5,0.5, 0, 0);
		placeComponent(new JLabel(project.getBeginDate().format(formatter)),5,11,2,1,0.5,0.5, 0, 0);
		placeComponent(new JLabel("Duration"),4,12,2,1,0.5,0.5, 0, 0);
		placeComponent(new JLabel(project.getDuration()+ " Month(s)"),5,12,2,1,0.5,0.5, 0, 0);
		placeComponent(new JLabel("End"),4,13,2,1,0.5,0.5, 0, 0);
		if (project.getEndDate()!=null) { placeComponent(new JLabel(project.getEndDate().format(formatter)), 5, 13, 2, 1, 0.5, 0.5, 0, 0);
		} else { placeComponent(new JLabel("Project not ended yet"), 5, 13, 2, 1, 0.5, 0.5, 0, 0); }
		placeComponent(new JLabel("Cost\t"),4,14,2,1,0.5,0.5, 0, 0);
		placeComponent(new JLabel(project.projectCost() + "€"),5,14,2,1,0.5,0.5, 0, 0);

		/*
		 * LISTENERS AND OTHER BUTTONS
		 */
		ProjectManagementGUI.Listener listener = new ProjectManagementGUI.Listener();
		buttonRETURN.addActionListener(listener);
		buttonPersonINFO.addActionListener(listener);
		buttonTaskINFO.addActionListener(listener);

		//if project not terminated
		if (!project.getStatus()){

			buttonTaskUPDATE = new JButton("Update Completion");
			placeComponent(buttonTaskUPDATE,6,8,1,2,0.5,0, 0, 10);

			buttonProjectEND = new JButton("Archive Project");
			placeComponent(buttonProjectEND,4,16,2,1,0.5,0, 0, 10);

			buttonPRINCIPALINVESTIGATOR = new JButton("Set Principal Investigator");
			placeComponent(buttonPRINCIPALINVESTIGATOR,6,1,1,1,0.5,0.5,0,0);
			
			buttonAdvisorSET = new JButton("Set Advisor");
			placeComponent(buttonAdvisorSET,6,4,1,1,0.5,0.5,0,0);

			buttonPersonASSIGN = new JButton("Assign Member to Task");
			placeComponent(buttonPersonASSIGN,6,7,1,1,0.5,0.5,0,0);

			buttonTaskCREATE = new JButton("Add Task");
			placeComponent(buttonTaskCREATE,4,8,1,1,0.5,0, 0, 10);

			buttonTaskREMOVE = new JButton("Remove Task");
			placeComponent(buttonTaskREMOVE,5,8,1,1,0.5,0, 0, 10);

			buttonProjectEND.addActionListener(listener);
			buttonPersonASSIGN.addActionListener(listener);
			buttonTaskCREATE.addActionListener(listener);
			buttonTaskREMOVE.addActionListener(listener);
			buttonTaskUPDATE.addActionListener(listener);
			buttonPRINCIPALINVESTIGATOR.addActionListener(listener);
			buttonAdvisorSET.addActionListener(listener);
		}


		frame.setVisible(true);
	}
	/**
     * This method clears the frame
     * @since 13-12-2019
     */
	public void close(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	/**
	 * This method updates lists in the frame
	 * @since 13-12-2019
	 */
	private void update(){
		listValuesTasks.removeAllElements();
		listValuesTasks.addAll(project.getTasks());

		listValuesUnstartedTasks.removeAllElements();
		listValuesUnstartedTasks.addAll(project.getUnstartedTasks());

		listValuesUnstartedTasksIET.removeAllElements();
		listValuesUnstartedTasksIET.addAll(project.getUncompletedTasksIET());

		listValuesCompletedTasks.removeAllElements();
		listValuesCompletedTasks.addAll(project.getCompletedTasks());

		listValuesMembers.removeAllElements();
		listValuesMembers.addAll(project.getMembers());
	}
	/**
	 * This method places the component in the specified position in grid and format. 
	 * @param component	This is the component we want to place.
	 * @param gx	This is the grid position in axis X.
	 * @param gy	This is the grid position in axis Y.
	 * @param gw	This specify the number of columns in the component's display area.
	 * @param gh	This specify the number of rows in the component's display area.
	 * @param wx	This determine how to distribute space among columns.
	 * @param wy	This determine how to distribute space among rows
	 * @param ix	This specifies the internal padding in axis X
	 * @param iy	This specifies the internal padding in axis Y
	 * @since 13-12-2019
	 */
	public void placeComponent(JComponent component,int gx, int gy,int gw,int gh,double wx,double wy, int ix, int iy) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = gx;       	//posiçao celula x
		c.gridy = gy; 			//posiçao celula y
		c.gridwidth = gw;		//quantos celulas de largura
		c.gridheight = gh;   	//quantos celulas de altura
		c.weightx = wx;			//percentagem de largura celula em relacao as outras
		c.weighty = wy;			//percentagem de altura celula em relacao as outras
		c.ipady = iy;			//altura celula
		c.ipadx = ix;
		frame.add(component, c);
	}

    /**
     * This class overrides some listeners.
     * @since 13-12-2019
     */
	private class Listener implements ActionListener{
	    /**
	     * This method gets events from buttons and treat them to do some work.
	     * @param e	This is the handled event
	     * @since 13-12-2019
	     */
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == buttonRETURN) {
				try {
					close();
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame,IC);
					investigationCenterGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonINFO) {
				try {
					if (listMembers.getSelectedValue()!=null) {
						Person p = listMembers.getSelectedValue();

						String message = "Name:\t" + p.getName() + "\nE-mail:\t" + p.getEmail();
						if (p instanceof Bachelor) {
							Bachelor bachelorStudent = (Bachelor) p;
							message = "BACHELOR STUDENT\n" + message;
							message += "\nGrant begin:\t" + bachelorStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + bachelorStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + bachelorStudent.getCost() + "€";
						} else if (p instanceof Master) {
							Master masterStudent = (Master) p;
							message = "MASTER STUDENT\n" + message;
							message += "\nGrant begin:\t" + masterStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + masterStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + masterStudent.getCost() + "€";
						} else if (p instanceof PhD) {
							PhD PhDStudent = (PhD) p;
							message = "PhD STUDENT\n" + message;
							message += "\nGrant begin:\t" + PhDStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + PhDStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + PhDStudent.getCost() + "€";
						} else if (p instanceof Teacher) {
							Teacher teacher = (Teacher) p;
							message = "TEACHER\n" + message;
							message += "\nMecanographic Number:\t" + teacher.getMecanographicNumber();
							message += "\nInvestigation Area:\t" + teacher.getInvestigationArea();
						}
						JOptionPane.showMessageDialog(null, message, "People Description", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a member first.","Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonTaskINFO) {
				try {
					if(listTasks.getSelectedValue()!=null) {
						Task t = listTasks.getSelectedValue();

						String message = "Name:\t" + t.getName() + "\nBegin Date:\t" + t.getBeginDate().format(formatter);
						if (t.getStatus()!=100){  message+= "\nEnd Date:\tTask not terminated yet" ;
						} else { message+= "\nEnd Date:\t" + t.getEndDate().format(formatter);}
						message+= "\nDuration:\t" + t.getDuration();
						if(t.getResponsible()==null) { message += "\nResponsible:\tTask has no responsible yet";
						}else{message += "\nResponsible:\t" + t.getResponsible().getName();}
						message+= "\nStatus:\t" + t.getStatus();
						if (t instanceof Design) {
							message = "DESIGN\n"+message;
							message += "\nEffort rate:\t0.50";
						} else if (t instanceof Development) {
							message = "DEVELOPMENT\n"+message;
							message += "\nEffort rate:\t1.00";
						} else if (t instanceof Documentation) {
							message = "\nDOCUMENTATION"+message;
							message += "\nEffort rate:\t0.25";
						}
						JOptionPane.showMessageDialog(null, message, "People Description", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a task first.","Error", JOptionPane.PLAIN_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if (!project.getStatus()){
			 	if(e.getSource() == buttonPRINCIPALINVESTIGATOR) {
					try {
						if(listMembers.getSelectedValue()!=null){
							if (listMembers.getSelectedValue() instanceof Teacher) {
								project.setPrincipalInvestigator((Teacher) listMembers.getSelectedValue());
								labelPRINCIPALINVESTIGATOR.setText(project.getPrincipalInvestigator().getName());
							}
							else {
								JOptionPane.showMessageDialog(null, "Only Teachers can be a Principal Investigator","Error", JOptionPane.PLAIN_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Select a member of the list first","Error", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource() == buttonPersonASSIGN) {
					try {
						if(listTasks.getSelectedValue()!=null && listMembers.getSelectedValue()!=null ){
							if(listMembers.getSelectedValue().isSurcharged(listTasks.getSelectedValue())) {
								//if grantee end date >= task end date
								if (!(listMembers.getSelectedValue() instanceof Grantee) || !(((Grantee) listMembers.getSelectedValue()).getGrantEnd()).isAfter(listTasks.getSelectedValue().getBeginDate().plusDays(listTasks.getSelectedValue().getDuration()))) {
									//add responsible to task
									listTasks.getSelectedValue().setResponsible(listMembers.getSelectedValue());
									//add task to member
									listMembers.getSelectedValue().addTask(listTasks.getSelectedValue());
									update();
								}
								else {
									JOptionPane.showMessageDialog(null, "Grantee scholarship deadline is less than task end date", "Error", JOptionPane.PLAIN_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "That person would be overcharged", "Error", JOptionPane.PLAIN_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Select a member and a task first","Error", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource() == buttonAdvisorSET) {
					try {
						if(listMembers.getSelectedValue()!=null && listMembers.getSelectedValue() instanceof AdvisedStudent){
							ArrayList<String> choices = new ArrayList<>();
							for (Person tea : project.getTeachers()){
								choices.add(tea.getName());
							}
							String teacher = (String) JOptionPane.showInputDialog(null, "Choose teacher.", "Choose", JOptionPane.QUESTION_MESSAGE, null, choices.toArray(), choices.toArray()[0]);
							for (Teacher tea : project.getTeachers()){
								if (tea.getName().equals(teacher)){
									if(((AdvisedStudent) listMembers.getSelectedValue()).getAdvisors().contains(tea)){
										JOptionPane.showMessageDialog(null, teacher+" is already advisor of this student!", "Error", JOptionPane.PLAIN_MESSAGE);
									}
									else {
										((AdvisedStudent) listMembers.getSelectedValue()).addAdvisor(tea);
									}
									break;
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Select an advised student first","Error", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource() == buttonProjectEND) {
					try {
						project.endProject();
						project.setEndDate(LocalDate.now());
						//cleans task from person
						for (Task task : project.getTasks()){
							task.getResponsible().removeTask(task);
						}
						//removes project form people and cleans Advisors of AdvisedStudents
						for (Person person : project.getMembers()){
							if (person instanceof Grantee){
								((Grantee) person).setProject(null);
								if(person instanceof AdvisedStudent){
									((AdvisedStudent) person).setAdvisors(new ArrayList<>());
								}
							}
							else{
								((Teacher) person).removeProject(project);
							}
						}
						close();
						initialize();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource()== buttonTaskCREATE){
					try{
						close();
						TaskCreatorGUI taskCreatorGUI = new TaskCreatorGUI(frame,IC,project);
						taskCreatorGUI.initialize();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource() == buttonTaskREMOVE) {
					try {
						if(listTasks.getSelectedValue()!=null){
							if (listTasks.getSelectedValue().getResponsible()!=null){
								//removes task from responsible if it has one
								listTasks.getSelectedValue().getResponsible().removeTask(listTasks.getSelectedValue());
							}
							project.deleteTask(listTasks.getSelectedValue());
							listTasks.getSelectedValue().getResponsible().removeTask(listTasks.getSelectedValue());
							update();
						}
						else {
							JOptionPane.showMessageDialog(null, "Select a task first","Error", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getSource() == buttonTaskUPDATE) {
					try {
						if (listTasks.getSelectedValue()!=null) {
							//is selected
							if(listTasks.getSelectedValue().getResponsible()!=null){
								//has responsible
								if (listTasks.getSelectedValue().getStatus() < 100) {
									//isn't completed
									String input = JOptionPane.showInputDialog("Update Conclusion of " + listTasks.getSelectedValue().getName());
									if (input != null) {
										//has input
										double status = Double.parseDouble(input);
										if (status < 0 || status > 100) {
											JOptionPane.showMessageDialog(null, "Invalid input!\nStatus should be from 0% to 100%", "Error", JOptionPane.PLAIN_MESSAGE);
										}
										else {
											if (status == 100) {
												listTasks.getSelectedValue().setEndDate(LocalDate.now());
												listTasks.getSelectedValue().getResponsible().removeTask(listTasks.getSelectedValue());
											}
											listTasks.getSelectedValue().setStatus(status);
											update();
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Nothing detected on input.", "Error", JOptionPane.PLAIN_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Task is already completed!", "Error", JOptionPane.PLAIN_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Task has no responsible!", "Error", JOptionPane.PLAIN_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Select a task first.","Error", JOptionPane.PLAIN_MESSAGE);
						}
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Insert only numbers in the duration box", "", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}