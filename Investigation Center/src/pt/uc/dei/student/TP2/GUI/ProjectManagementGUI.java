package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Person;
import pt.uc.dei.student.TP2.sourceCode.Project;
import pt.uc.dei.student.TP2.sourceCode.Task;

public class ProjectManagementGUI extends JPanel{
	private static final long serialVersionUID = 1L;
	//Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonTaskCREATE;
	private JButton buttonTaskREMOVE;
	private JButton buttonRETURN;
	private JButton buttonProjectEND;
	// Label
	private JLabel title;
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
		setListValuesUnstartedTasks(new DefaultListModel<Task>());
		listValuesUnstartedTasks.addAll(project.showUnstartedTasks());
		setListUnstartedTasks(new JList<Task>(listValuesUnstartedTasks));
		setListScrollerUnstartedTasks(new JScrollPane(listUnstartedTasks)); 
		// List UNSTARTED TASK IN ESTIMATED TIME
		setListValuesUnstartedTasksIET(new DefaultListModel<Task>());
		listValuesUnstartedTasksIET.addAll(project.showUnstartedTasks());
		setListUnstartedTasksIET(new JList<Task>(listValuesUnstartedTasksIET));
		setListScrollerUnstartedTasksIET(new JScrollPane(listUnstartedTasksIET)); 
		// List COMPLETED TASK
		setListValuesCompletedTasks(new DefaultListModel<Task>());
		listValuesCompletedTasks.addAll(project.showUnstartedTasks());
		setListCompletedTasks(new JList<Task>(listValuesCompletedTasks));
		setListScrollerCompletedTasks(new JScrollPane(listCompletedTasks)); 
		// List TASK
		setListValuesTasks(new DefaultListModel<Task>());
		listValuesTasks.addAll(project.getTasks());
		setListTasks(new JList<Task>(listValuesTasks));
		setListScrollerTasks(new JScrollPane(listTasks)); 
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
		
		setButtonRETURN(new JButton("Return"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 2;       	//posiçao celula x
		c.gridy = 11; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(getButtonRETURN(), c);
		
		setButtonProjectEND(new JButton("End Project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 4;       	//posiçao celula x
		c.gridy = 11; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 2;	//quantos celulas de largura
		getFrame().add(getButtonProjectEND(), c);
		
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

		setListScrollerUnstartedTasks(new JScrollPane(listUnstartedTasks));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 2;
		c.gridwidth = 1;
		getFrame().add(getListScrollerUnstartedTasks(), c);
		
		labelUnstartedTasksIET = new JLabel("Uncompleted Tasks in Estimated Time");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelUnstartedTasksIET, c);

		setListScrollerUnstartedTasksIET(new JScrollPane(listUnstartedTasksIET));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 2;
		c.gridwidth = 1;
		getFrame().add(getListScrollerUnstartedTasksIET(), c);
		
		labelCompletedTasks = new JLabel("Completed Tasks");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCompletedTasks, c);

		setListScrollerCompletedTasks(new JScrollPane(listCompletedTasks));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 5;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		getFrame().add(getListScrollerCompletedTasks(), c);
		
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

		setListScrollerMembers(new JScrollPane(getListMembers()));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(getListScrollerMembers(), c);
		
		labelTasks = new JLabel("Tasks");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(labelTasks, c);

		setListScrollerTasks(new JScrollPane(getListTasks()));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight= 1;
		getFrame().add(getListScrollerTasks(), c);
		

		setButtonTaskCREATE(new JButton("Add Task"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 4;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(getButtonTaskCREATE(), c);

		setButtonTaskREMOVE(new JButton("Remove Task"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(getButtonTaskREMOVE(), c);
		
		setButtonTaskREMOVE(new JButton("Remove Task"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 6; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(getButtonTaskREMOVE(), c);
		
		labelCost = new JLabel("Project Cost");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCost, c);
		
		labelCOST = new JLabel(String.valueOf(project.projectCost()));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(labelCOST, c);
		//Listeners
		/*InvestigationCenterGUI.ButtonListener buttonActionListener = new InvestigationCenterGUI.ButtonListener();

		buttonENTER.addActionListener(buttonActionListener);
		buttonPersonTeacherCREATE.addActionListener(buttonActionListener);
		buttonPersonBachelorCREATE.addActionListener(buttonActionListener);
		buttonPersonMasterCREATE.addActionListener(buttonActionListener);
		buttonPersonPhDCREATE.addActionListener(buttonActionListener);
		buttonPersonREMOVE.addActionListener(buttonActionListener);
		buttonProjectCREATE.addActionListener(buttonActionListener);
		buttonProjectREMOVE.addActionListener(buttonActionListener);*/

		getFrame().setVisible(true);
	}

	private void close(){
		getFrame().getContentPane().removeAll();
		getFrame().repaint();
	}
/*
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonPersonTeacherCREATE){
				try{
					//não é importante para ja
					System.out.println("não é importante para ja\n");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonBachelorCREATE) {
				try {
					AdvisedStudentGUI advisedStudentGUI = new AdvisedStudentGUI(frame,investigationCenter,"Bachelor");
					close();
					advisedStudentGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonMasterCREATE) {
				try {
					AdvisedStudentGUI advisedStudentGUI = new AdvisedStudentGUI(frame,investigationCenter,"Master");
					close();
					advisedStudentGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonPhDCREATE) {
				try {

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonREMOVE) {
				try {

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectCREATE) {
				try {

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectREMOVE) {
				try {

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				try {

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}*/


	public JButton getButtonRETURN() {
		return buttonRETURN;
	}


	public void setButtonRETURN(JButton buttonRETURN) {
		this.buttonRETURN = buttonRETURN;
	}


	private DefaultListModel<Task> getListValuesUnstartedTasks() {
		return listValuesUnstartedTasks;
	}


	private void setListValuesUnstartedTasks(DefaultListModel<Task> listValuesUnstartedTasks) {
		this.listValuesUnstartedTasks = listValuesUnstartedTasks;
	}


	public DefaultListModel<Task> getListValuesUnstartedTasksIET() {
		return listValuesUnstartedTasksIET;
	}


	public void setListValuesUnstartedTasksIET(DefaultListModel<Task> listValuesUnstartedTasksIET) {
		this.listValuesUnstartedTasksIET = listValuesUnstartedTasksIET;
	}


	public DefaultListModel<Task> getListValuesCompletedTasks() {
		return listValuesCompletedTasks;
	}


	public void setListValuesCompletedTasks(DefaultListModel<Task> listValuesCompletedTasks) {
		this.listValuesCompletedTasks = listValuesCompletedTasks;
	}


	public JList<Task> getListUnstartedTasks() {
		return listUnstartedTasks;
	}


	public void setListUnstartedTasks(JList<Task> listUnstartedTasks) {
		this.listUnstartedTasks = listUnstartedTasks;
	}


	public JList<Task> getListUnstartedTasksIET() {
		return listUnstartedTasksIET;
	}


	public void setListUnstartedTasksIET(JList<Task> listUnstartedTasksIET) {
		this.listUnstartedTasksIET = listUnstartedTasksIET;
	}


	public JList<Task> getListCompletedTasks() {
		return listCompletedTasks;
	}


	public void setListCompletedTasks(JList<Task> listCompletedTasks) {
		this.listCompletedTasks = listCompletedTasks;
	}


	private JScrollPane getListScrollerUnstartedTasks() {
		return listScrollerUnstartedTasks;
	}


	private void setListScrollerUnstartedTasks(JScrollPane listScrollerUnstartedTasks) {
		this.listScrollerUnstartedTasks = listScrollerUnstartedTasks;
	}


	private JScrollPane getListScrollerUnstartedTasksIET() {
		return listScrollerUnstartedTasksIET;
	}


	private void setListScrollerUnstartedTasksIET(JScrollPane listScrollerUnstartedTasksIET) {
		this.listScrollerUnstartedTasksIET = listScrollerUnstartedTasksIET;
	}


	private JScrollPane getListScrollerCompletedTasks() {
		return listScrollerCompletedTasks;
	}


	private void setListScrollerCompletedTasks(JScrollPane listScrollerCompletedTasks) {
		this.listScrollerCompletedTasks = listScrollerCompletedTasks;
	}


	public JButton getButtonTaskCREATE() {
		return buttonTaskCREATE;
	}


	public void setButtonTaskCREATE(JButton buttonTaskCREATE) {
		this.buttonTaskCREATE = buttonTaskCREATE;
	}


	public JButton getButtonTaskREMOVE() {
		return buttonTaskREMOVE;
	}


	public void setButtonTaskREMOVE(JButton buttonTaskREMOVE) {
		this.buttonTaskREMOVE = buttonTaskREMOVE;
	}


	public DefaultListModel<Person> getListValuesMembers() {
		return listValuesMembers;
	}


	public void setListValuesMembers(DefaultListModel<Person> listValuesMembers) {
		this.listValuesMembers = listValuesMembers;
	}


	private JList<Person> getListMembers() {
		return listMembers;
	}


	private void setListMembers(JList<Person> listMembers) {
		this.listMembers = listMembers;
	}


	public JScrollPane getListScrollerMembers() {
		return listScrollerMembers;
	}


	public void setListScrollerMembers(JScrollPane listScrollerMembers) {
		this.listScrollerMembers = listScrollerMembers;
	}


	public DefaultListModel<Task> getListValuesTasks() {
		return listValuesTasks;
	}


	public void setListValuesTasks(DefaultListModel<Task> listValuesTasks) {
		this.listValuesTasks = listValuesTasks;
	}


	public JList<Task> getListTasks() {
		return listTasks;
	}


	public void setListTasks(JList<Task> listTasks) {
		this.listTasks = listTasks;
	}


	public JScrollPane getListScrollerTasks() {
		return listScrollerTasks;
	}


	public void setListScrollerTasks(JScrollPane listScrollerTasks) {
		this.listScrollerTasks = listScrollerTasks;
	}


	public JButton getButtonProjectEND() {
		return buttonProjectEND;
	}


	public void setButtonProjectEND(JButton buttonProjectEND) {
		this.buttonProjectEND = buttonProjectEND;
	}


	public InvestigationCenter getInvestigationCenter() {
		return investigationCenter;
	}


	public void setInvestigationCenter(InvestigationCenter investigationCenter) {
		this.investigationCenter = investigationCenter;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	private JFrame getFrame() {
		return frame;
	}


	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

