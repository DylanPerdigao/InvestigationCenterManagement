package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
	private JButton buttonRETURN;
	private JButton buttonProjectEND;
	// Label
	JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel emptyLabel3;
	JLabel labelUnstartedTasks;
	JLabel labelUnstartedTasksIET;
	JLabel labelCompletedTasks;
	JLabel labelPI, labelPRINCIPALINVESTIGATOR;
	JLabel labelMembers;
	JLabel labelCost, labelCOST;
	JLabel labelTasks;
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
		listValuesUnstartedTasks.addAll(project.getUnstartedTasks());
		listUnstartedTasks = new JList<Task>(listValuesUnstartedTasks);
		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks); 
		// List UNSTARTED TASK IN ESTIMATED TIME
		listValuesUnstartedTasksIET = new DefaultListModel<Task>();
		listValuesUnstartedTasksIET.addAll(project.getUnstartedTasks());
		listUnstartedTasksIET = new JList<Task>(listValuesUnstartedTasksIET);
		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET); 
		// List COMPLETED TASK
		listValuesCompletedTasks = new DefaultListModel<Task>();
		listValuesCompletedTasks.addAll(project.getUnstartedTasks());
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
		c.gridwidth = 6;
		getFrame().add(title, c);


		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 6;
		c.gridy = 12;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(emptyLabel2, c);
		
		emptyLabel3 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(emptyLabel3, c);
		
		buttonRETURN = new JButton("Return");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 2;       	//posiçao celula x
		c.gridy = 11; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(buttonRETURN, c);
		
		buttonProjectEND = new JButton("End Project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 4;       	//posiçao celula x
		c.gridy = 11; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 2;	//quantos celulas de largura
		getFrame().add(buttonProjectEND, c);
		
		/*
		 * TASKS
		 */

		labelUnstartedTasks = new JLabel("Unstarted Tasks");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelUnstartedTasks, c);

		listScrollerUnstartedTasks = new JScrollPane(listUnstartedTasks);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 2;
		c.gridwidth = 1;
		getFrame().add(listScrollerUnstartedTasks, c);
		
		labelUnstartedTasksIET = new JLabel("Uncompleted Tasks in Estimated Time");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelUnstartedTasksIET, c);

		listScrollerUnstartedTasksIET = new JScrollPane(listUnstartedTasksIET);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 2;
		c.gridwidth = 1;
		getFrame().add(listScrollerUnstartedTasksIET, c);
		
		labelCompletedTasks = new JLabel("Completed Tasks");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCompletedTasks, c);

		listScrollerCompletedTasks = new JScrollPane(listCompletedTasks);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		getFrame().add(listScrollerCompletedTasks, c);
		
		labelPI = new JLabel("Principal Investigator");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelPI, c);
		
		labelPRINCIPALINVESTIGATOR = new JLabel("INSERT NAME OF PRINCIPAL INVESTIGATOR");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelPRINCIPALINVESTIGATOR, c);
		
		labelMembers = new JLabel("Members");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(labelMembers, c);

		listScrollerMembers = new JScrollPane(listMembers);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(listScrollerMembers, c);

		labelTasks = new JLabel("Tasks");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(labelTasks, c);

		listScrollerTasks = new JScrollPane(listTasks);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(listScrollerTasks, c);
		

		buttonTaskCREATE = new JButton("Add Task");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 4;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(buttonTaskCREATE, c);

		buttonTaskREMOVE = new JButton("Remove Task");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(buttonTaskREMOVE, c);
		
		buttonTaskREMOVE= new JButton("Remove Task");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(buttonTaskREMOVE, c);

		labelCost = new JLabel("Project Cost");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCost, c);

		labelCOST = new JLabel(String.valueOf(getProject().projectCost()));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCOST, c);

		//Listeners
		ProjectManagementGUI.ButtonListener buttonActionListener = new ProjectManagementGUI.ButtonListener();

		buttonTaskCREATE.addActionListener(buttonActionListener);
		buttonTaskREMOVE.addActionListener(buttonActionListener);
		buttonRETURN.addActionListener(buttonActionListener);
		buttonProjectEND.addActionListener(buttonActionListener);

		getFrame().setVisible(true);
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
	
	private class ButtonListener implements ActionListener, MouseListener,WindowListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonTaskCREATE){
				try{
					//não é importante para ja
					System.out.println("não é importante para ja\n");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonTaskREMOVE) {
				try {

					//frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonRETURN) {
				try {
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(getFrame(),investigationCenter);
					close();
					investigationCenterGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectEND) {
				try {

					//frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
        @Override
        public void windowClosing(WindowEvent e) {
        	save();
            System.exit(0);
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
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
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