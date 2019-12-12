package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
	// Label
	JLabel title;
	JLabel labelPRINCIPALINVESTIGATOR;
	JLabel labelCOST;
	// List
	private DefaultListModel<Task> listValuesTasks;
	private DefaultListModel<Task> listValuesUnstartedTasks;
	private DefaultListModel<Task> listValuesUnstartedTasksIET;
	private DefaultListModel<Task> listValuesCompletedTasks;
	private DefaultListModel<Person> listValuesMembers;
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
	private InvestigationCenter investigationCenter;
	private Project project;

	public ProjectManagementGUI(JFrame frame,InvestigationCenter investigationCenter,Project project) {
		super();
		setFrame(frame);
		setInvestigationCenter(investigationCenter);
		setProject(project);
		// List UNSTARTED TASK
		listValuesUnstartedTasks = new DefaultListModel<Task>();
		listUnstartedTasks = new JList<Task>(listValuesUnstartedTasks);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks); 
		// List UNSTARTED TASK IN ESTIMATED TIME
		listValuesUnstartedTasksIET = new DefaultListModel<Task>();
		listValuesUnstartedTasksIET.addAll(project.getUncompletedTasksIET());
		listUnstartedTasksIET = new JList<Task>(listValuesUnstartedTasksIET);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET); 
		// List COMPLETED TASK
		listValuesCompletedTasks = new DefaultListModel<Task>();
		listValuesCompletedTasks.addAll(project.getCompletedTasks());
		listCompletedTasks = new JList<Task>(listValuesCompletedTasks);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks); 
		// List TASK
		listValuesTasks = new DefaultListModel<Task>();
		listValuesTasks.addAll(project.getTasks());
		listTasks = new JList<Task>(listValuesTasks);
		listScrollerTasks = new JScrollPane(listTasks); 
		// List Members
		listValuesMembers = new DefaultListModel<Person>();
		listValuesMembers.addAll(project.getMembers());
		listMembers = new JList<Person>(listValuesMembers);
		listScrollerMembers = new JScrollPane(listMembers); 
	}


	public void initialize(){

		getFrame().setLayout(new GridBagLayout());

		title = new JLabel(getProject().getName());
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		getFrame().add(title, c);

		placeComponent(new JLabel(""),0,10,1,1,0.5,10, 0, 0);
		placeComponent(new JLabel(""),7,13,1,1,0.5,10, 0, 0);
		placeComponent(new JLabel(""),3,12,1,1,0.5,10, 0, 0);
		
		buttonRETURN = new JButton("Return");
		placeComponent(buttonRETURN,2,11,1,1,0.5,0, 0, 10);
		
		buttonProjectEND = new JButton("Archive Project");
		placeComponent(buttonProjectEND,4,11,2,1,0.5,0, 0, 10);
		
		/*
		 * TASKS
		 */

		placeComponent(new JLabel("Unstarted Tasks"),2,1,1,1,0.5,0.5, 0, 0);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks);
		placeComponent(listScrollerUnstartedTasks,2,2,1,2,0.5,5,100, 10);
		
		placeComponent(new JLabel("Uncompleted Tasks in Estimated Time"),2,4,1,1,0.5,0.5,0, 0);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET);
		placeComponent(listScrollerUnstartedTasksIET,2,5,1,2,0.5,5,100, 10);
		
		placeComponent(new JLabel("Completed Tasks"),2,8,1,1,0.5,0.5,0,0);
		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks);
		placeComponent(listScrollerCompletedTasks,2,9,1,1,0.5,5,100, 10);
		
		placeComponent(new JLabel("Principal Investigator"),4,1,1,1,0.5,0.5,0, 0);
		labelPRINCIPALINVESTIGATOR = new JLabel("NO PRINCIPAL INVESTIGATOR");
		placeComponent(labelPRINCIPALINVESTIGATOR,5,1,1,1,0.5,0.5,0,0);
		
		buttonPRINCIPALINVESTIGATOR = new JButton("Set Principal Investigator");
		placeComponent(buttonPRINCIPALINVESTIGATOR,6,1,1,1,0.5,0.5,0,0);
		
		placeComponent(new JLabel("Members"),4,2,2,1,0.5,0.5,0,0);
		listScrollerMembers = new JScrollPane(listMembers);
		placeComponent(listScrollerMembers,4,3,2,1,0.5,10,100,10);
		
		buttonPersonASSIGN = new JButton("Assign Member to Task");
		placeComponent(buttonPersonASSIGN,6,3,1,1,0.5,0.5,0,0);

		placeComponent(new JLabel("Tasks"),4,4,2,1,0.5,0.5,0,0);
		listScrollerTasks = new JScrollPane(listTasks);
		placeComponent(listScrollerTasks,4,5,3,1,0.5,10,100,10);
		
		buttonTaskCREATE = new JButton("Add Task");
		placeComponent(buttonTaskCREATE,4,6,1,1,0.5,0, 0, 10);

		buttonTaskREMOVE = new JButton("Remove Task");
		placeComponent(buttonTaskREMOVE,5,6,1,1,0.5,0, 0, 10);
		
		buttonTaskSTATUS = new JButton("Update Completion");
		placeComponent(buttonTaskSTATUS,6,6,1,1,0.5,0, 0, 10);

		placeComponent(new JLabel("Project Cost"),4,10,1,1,0.5,0.5, 0, 0);
		labelCOST = new JLabel(String.valueOf(getProject().projectCost())+"€");
		placeComponent(labelCOST,5,10,1,1,0.5,0.5, 0, 0);

		//Listeners
		ProjectManagementGUI.Listener listener = new ProjectManagementGUI.Listener();

		buttonTaskCREATE.addActionListener(listener);
		buttonTaskREMOVE.addActionListener(listener);
		buttonTaskSTATUS.addActionListener(listener);
		buttonRETURN.addActionListener(listener);
		buttonProjectEND.addActionListener(listener);
		
		frame.addWindowListener(listener);

		getFrame().setVisible(true);
	}
	private void placeComponent(JComponent component,int gx, int gy,int gw,int gh,double wx,double wy, int ix, int iy) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = gx;       	//posiçao celula x
		c.gridy = gy; 		//posiçao celula y
		c.gridwidth = gw;	//quantos celulas de largura
		c.gridheight = gh;   //quantos celulas de altura
		c.weightx = wx;	//percentagem de largura celula em relacao as outras
		c.weighty = wy;		//percentagem de altura celula em relacao as outras
		c.ipady = iy;		//altura celula
		c.ipadx = ix;
		getFrame().add(component, c);
	}
	private void close(){
		getFrame().getContentPane().removeAll();
		getFrame().repaint();
	}
	
	private void save() {
		File outputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileOutputStream fos = new FileOutputStream(outputObjFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(getInvestigationCenter());
			oos.close();
			JOptionPane.showMessageDialog(null, "Work saved successfully","Save", JOptionPane.PLAIN_MESSAGE);
			} catch (FileNotFoundException ex) {
			System.out.println("Error creating file");
		} catch (IOException ex) {
			System.out.println("Error writing file");
		}
	}
	
	private class Listener implements ActionListener, WindowListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonTaskCREATE){
				try{
					//não é importante para ja
					System.out.println("não é importante para ja\n");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonTaskREMOVE) {
				try {

					//frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonRETURN) {
				try {
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(getFrame(),investigationCenter);
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
		@Override
		public void windowClosing(WindowEvent e) {
			save();
			frame.dispose();
		}
		@Override
		public void windowOpened(WindowEvent e) {}
		@Override
		public void windowClosed(WindowEvent e) {}
		@Override
		public void windowIconified(WindowEvent e) {}
		@Override
		public void windowDeiconified(WindowEvent e) {}
		@Override
		public void windowActivated(WindowEvent e) {}
		@Override
		public void windowDeactivated(WindowEvent e) {}
	}

	public InvestigationCenter getInvestigationCenter() {
		return investigationCenter;
	}

	public void setInvestigationCenter(InvestigationCenter investigationCenter) { 
		this.investigationCenter = investigationCenter; 
	}

	private JFrame getFrame() {
		return frame;
	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}


	private Project getProject() {
		return project;
	}


	private void setProject(Project project) {
		this.project = project;
	}
}