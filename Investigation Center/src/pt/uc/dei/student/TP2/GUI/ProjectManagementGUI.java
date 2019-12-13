package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Person;
import pt.uc.dei.student.TP2.sourceCode.Project;
import pt.uc.dei.student.TP2.sourceCode.Task;

/**
 * This class represent the advised students of a project (Bachelor and Master students)
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */

public class ProjectManagementGUI{
	//Constraints
	private GridBagConstraints c = new GridBagConstraints();

	// Buttons
	private JButton buttonTaskCREATE;
	private JButton buttonTaskREMOVE;
	private JButton buttonTaskSTATUS;
	private JButton buttonRETURN;
	private JButton buttonProjectEND;

	private JButton buttonPRINCIPALINVESTIGATOR;
	private JButton buttonPersonASSIGN;
	private JButton buttonPersonINFO;
	private JButton buttonTaskINFO;
	// Label
	JLabel title;
	JLabel labelPRINCIPALINVESTIGATOR;
	JLabel labelCOST;

	// List
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

	private JFrame frame;
	private InvestigationCenter IC;
	private Project project;

	public ProjectManagementGUI(JFrame frame,InvestigationCenter IC,Project project) {
		this.frame = frame;
		this.IC=IC;
		this.project=project;
		// List UNSTARTED TASK
		DefaultListModel<Task> listValuesUnstartedTasks = new DefaultListModel<Task>();
		listUnstartedTasks = new JList<Task>(listValuesUnstartedTasks);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks); 
		// List UNSTARTED TASK IN ESTIMATED TIME
		DefaultListModel<Task> listValuesUnstartedTasksIET = new DefaultListModel<Task>();
		listValuesUnstartedTasksIET.addAll(project.getUncompletedTasksIET());
		listUnstartedTasksIET = new JList<Task>(listValuesUnstartedTasksIET);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET); 
		// List COMPLETED TASK
		DefaultListModel<Task> listValuesCompletedTasks = new DefaultListModel<Task>();
		listValuesCompletedTasks.addAll(project.getCompletedTasks());
		listCompletedTasks = new JList<Task>(listValuesCompletedTasks);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks); 
		// List TASK
		DefaultListModel<Task> listValuesTasks = new DefaultListModel<Task>();
		listValuesTasks.addAll(project.getTasks());
		listTasks = new JList<Task>(listValuesTasks);
		listScrollerTasks = new JScrollPane(listTasks); 
		// List Members
		DefaultListModel<Person> listValuesMembers = new DefaultListModel<Person>();
		listValuesMembers.addAll(project.getMembers());
		listMembers = new JList<Person>(listValuesMembers);
		listScrollerMembers = new JScrollPane(listMembers); 
	}


	public void initialize(){

		frame.setLayout(new GridBagLayout());

		// Label
		JLabel title = new JLabel(getProject().getName());
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 50;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		frame.add(title, c);

		placeComponent(new JLabel(""),0,12,1,1,0.5,10, 0, 0);
		placeComponent(new JLabel(""),7,15,1,1,0.5,50, 0, 0);
		placeComponent(new JLabel(""),3,14,1,1,0.5,50, 0, 0);
		
		buttonRETURN = new JButton("Return");
		placeComponent(buttonRETURN,2,13,1,1,0.5,0, 0, 10);
		
		buttonProjectEND = new JButton("Archive Project");
		placeComponent(buttonProjectEND,4,13,2,1,0.5,0, 0, 10);
		
		/*
		 * TASKS
		 */

		placeComponent(new JLabel("Unstarted Tasks"),2,1,1,1,0.5,0.5, 0, 0);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks);
		placeComponent(listScrollerUnstartedTasks,2,2,1,3,0.5,5,100, 10);
		
		placeComponent(new JLabel("Uncompleted Tasks in Estimated Time"),2,5,1,1,0.5,0.5,0, 0);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET);
		placeComponent(listScrollerUnstartedTasksIET,2,6,1,3,0.5,5,100, 10);
		
		placeComponent(new JLabel("Completed Tasks"),2,10,1,1,0.5,0.5,0,0);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks);
		placeComponent(listScrollerCompletedTasks,2,11,1,1,0.5,5,100, 10);
		
		placeComponent(new JLabel("Principal Investigator"),4,1,1,1,0.5,0.5,0, 0);
		JLabel labelPRINCIPALINVESTIGATOR = new JLabel("NO PRINCIPAL INVESTIGATOR");
		placeComponent(labelPRINCIPALINVESTIGATOR,5,1,1,1,0.5,0.5,0,0);

		JButton buttonPRINCIPALINVESTIGATOR = new JButton("Set Principal Investigator");
		placeComponent(buttonPRINCIPALINVESTIGATOR,6,1,1,1,0.5,0.5,0,0);

		placeComponent(new JLabel("Members"),4,2,2,1,0.5,0.5,0,0);
		listScrollerMembers = new JScrollPane(listMembers);
		placeComponent(listScrollerMembers,4,3,2,2,0.5,10,100,10);
		
		buttonPersonINFO = new JButton("Show Member Information");
		placeComponent(buttonPersonINFO,6,3,1,1,0.5,0.5,0,0);
		
		buttonPersonASSIGN = new JButton("Assign Member to Task");
		placeComponent(buttonPersonASSIGN,6,4,1,1,0.5,0.5,0,0);

		placeComponent(new JLabel("Tasks"),4,5,2,1,0.5,0.5,0,0);
		listScrollerTasks = new JScrollPane(listTasks);
		placeComponent(listScrollerTasks,4,6,2,2,0.5,10,100,10);
		
		buttonTaskINFO = new JButton("Show Task Information");
		placeComponent(buttonTaskINFO,6,6,1,2,0.5,0, 0, 10);
		
		buttonTaskSTATUS = new JButton("Update Completion");
		placeComponent(buttonTaskSTATUS,6,8,1,2,0.5,0, 0, 10);
		
		buttonTaskCREATE = new JButton("Add Task");
		placeComponent(buttonTaskCREATE,4,8,1,1,0.5,0, 0, 10);
		
		buttonTaskREMOVE = new JButton("Remove Task");
		placeComponent(buttonTaskREMOVE,5,8,1,1,0.5,0, 0, 10);

		placeComponent(new JLabel("Project Cost"),4,12,1,1,0.5,0.5, 0, 0);
		labelCOST = new JLabel(String.valueOf(getProject().projectCost())+"€");
		placeComponent(labelCOST,5,12,1,1,0.5,0.5, 0, 0);

		//Listeners
		ProjectManagementGUI.Listener listener = new ProjectManagementGUI.Listener();

		buttonTaskCREATE.addActionListener(listener);
		buttonTaskREMOVE.addActionListener(listener);
		buttonTaskSTATUS.addActionListener(listener);
		buttonRETURN.addActionListener(listener);
		buttonProjectEND.addActionListener(listener);

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
	public void update(){}
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

	
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonTaskCREATE){
				try{
					close();
					TaskCreatorGUI taskCreatorGUI = new TaskCreatorGUI(frame,IC,project);
					taskCreatorGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonTaskREMOVE) {
				try {
					if(listTasks.getSelectedValue()!=null){
						project.deleteTask(listTasks.getSelectedValue());
						//update();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonRETURN) {
				try {
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame,IC);
					close();
					investigationCenterGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonProjectEND) {
				try {

					//frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonTaskSTATUS) {
				try {
					String input = JOptionPane.showInputDialog("Update Conclusion of "+listTasks.getSelectedValue().getName());
					double status = Double.parseDouble(input);
					if(status<0 || status>100) {
						JOptionPane.showMessageDialog(null, "Invalid input","Error", JOptionPane.PLAIN_MESSAGE);
					}else {
						listTasks.getSelectedValue().setStatus(status);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	private Project getProject() {
		return project;
	}
}