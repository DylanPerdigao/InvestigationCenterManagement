package pt.uc.dei.student.TP2.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.AdvisedStudent;
import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Person;
import pt.uc.dei.student.TP2.sourceCode.Project;

public class InvestigationCenterGUI extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonPersonTeacherCREATE;
	private JButton buttonPersonBachelorCREATE;
	private JButton buttonPersonMasterCREATE;
	private JButton buttonPersonPhDCREATE;
	private JButton buttonPersonREMOVE;
	private JButton buttonProjectCREATE;
	private JButton buttonProjectREMOVE;
	private JButton buttonENTER;
	private JButton buttonRETURN;
	// Label
	private JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel emptyLabel3;
	JLabel labelPeople;
	JLabel labelProjects;
	// List
	private DefaultListModel<Person> listValuesPeople;
	private DefaultListModel<Project> listValuesProjects;
	private JList<Person> listPeople;
	private JList<Project> listProjects;
	private JScrollPane listScrollerPeople;
	private JScrollPane listScrollerProjects;

	private int x;
	private int y;
	private JFrame frame;
	InvestigationCenter investigationCenter;

	public InvestigationCenterGUI(JFrame frame,InvestigationCenter investigationCenter) {
		super();
		this.frame=frame;
		this.investigationCenter=investigationCenter;

		// List
		listValuesPeople = new DefaultListModel<Person>();
		listValuesPeople.addAll(investigationCenter.getPeople());
		listValuesProjects = new DefaultListModel<Project>();
		listValuesProjects.addAll(investigationCenter.getProjects());
		listPeople = new JList<Person>(listValuesPeople);
		listProjects = new JList<Project>(listValuesProjects);
		setListScrollerPeople(new JScrollPane(listPeople)); 
		setListScrollerProjects(new JScrollPane(listProjects)); 
	}


	public void initialize(){

		frame.setLayout(new GridBagLayout());

		title = new JLabel(investigationCenter.getName());
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;
		frame.add(title, c);


		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 6;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(emptyLabel2, c);
		
		setButtonRETURN(new JButton("Return"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 2;       	//posiçao celula x
		c.gridy = 9; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonRETURN(), c);
		
		/*
		 * PEOPLE
		 */

		setButtonPersonBachelorCREATE(new JButton("Add Bachelor"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 2; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonPersonBachelorCREATE(), c);

		setButtonPersonMasterCREATE(new JButton("Add Master Student"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 3; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonPersonMasterCREATE(), c);

		setButtonPersonPhDCREATE(new JButton("Add PhD Student"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 4; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonPersonPhDCREATE(), c);

		setButtonPersonTeacherCREATE(new JButton("Add Teacher"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 5; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonPersonTeacherCREATE(), c);

		setButtonPersonREMOVE(new JButton("Remove Person"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonPersonREMOVE(), c);
		
		emptyLabel3 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(emptyLabel3, c);
		
		labelPeople = new JLabel("People List");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(labelPeople, c);

		listScrollerPeople = new JScrollPane(listPeople);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = 1;
		frame.add(listScrollerPeople, c);

		/*
		 * PROJECTS
		 */

		setButtonProjectCREATE(new JButton("Add Project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 2; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonProjectCREATE(), c);

		setButtonProjectREMOVE(new JButton("Remove Project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 5;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonProjectREMOVE(), c);

		setButtonENTER(new JButton("Enter in Project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 4;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonENTER(), c);

		labelProjects = new JLabel("Projects List");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(labelProjects, c);

		listScrollerProjects = new JScrollPane(listProjects);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = 1;
		frame.add(listScrollerProjects, c);


		//Listeners
		InvestigationCenterGUI.ButtonListener buttonActionListener = new InvestigationCenterGUI.ButtonListener();

		buttonENTER.addActionListener(buttonActionListener);
		buttonPersonTeacherCREATE.addActionListener(buttonActionListener);
		buttonPersonBachelorCREATE.addActionListener(buttonActionListener);
		buttonPersonMasterCREATE.addActionListener(buttonActionListener);
		buttonPersonPhDCREATE.addActionListener(buttonActionListener);
		buttonPersonREMOVE.addActionListener(buttonActionListener);
		buttonProjectCREATE.addActionListener(buttonActionListener);
		buttonProjectREMOVE.addActionListener(buttonActionListener);

		frame.setVisible(true);
	}

	private void close(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonPersonTeacherCREATE){
				try{
					TeacherGUI teacherGUI = new TeacherGUI(frame,investigationCenter);
					close();
					teacherGUI.initialize();
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
					//initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonPersonPhDCREATE) {
				try {
					PhDGUI phDGUI = new PhDGUI(frame,investigationCenter);
					close();
					phDGUI.initialize();
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
					/*ProjectGUI projectGUI = new ProjectGUI(frame,investigationCenter);
					close();
					phDGUI.initialize();*/
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

	}

	public JButton getButtonPersonREMOVE() {
		return buttonPersonREMOVE;
	}

	public void setButtonPersonREMOVE(JButton buttonPersonREMOVE) {
		this.buttonPersonREMOVE = buttonPersonREMOVE;
	}

	public JButton getButtonProjectCREATE() {
		return buttonProjectCREATE;
	}

	public void setButtonProjectCREATE(JButton buttonProjectCREATE) {
		this.buttonProjectCREATE = buttonProjectCREATE;
	}

	public JButton getButtonProjectREMOVE() {
		return buttonProjectREMOVE;
	}

	public void setButtonProjectREMOVE(JButton buttonProjectREMOVE) {
		this.buttonProjectREMOVE = buttonProjectREMOVE;
	}

	public JButton getButtonENTER() {
		return buttonENTER;
	}

	public void setButtonENTER(JButton buttonENTER) {
		this.buttonENTER = buttonENTER;
	}

	public JScrollPane getListScrollerPeople() {
		return listScrollerPeople;
	}

	public void setListScrollerPeople(JScrollPane listScrollerPeople) {
		this.listScrollerPeople = listScrollerPeople;
	}

	public JScrollPane getListScrollerProjects() {
		return listScrollerProjects;
	}

	public void setListScrollerProjects(JScrollPane listScrollerProjects) {
		this.listScrollerProjects = listScrollerProjects;
	}

	public JButton getButtonPersonTeacherCREATE() {
		return buttonPersonTeacherCREATE;
	}

	public void setButtonPersonTeacherCREATE(JButton buttonPersonTeacherCREATE) {
		this.buttonPersonTeacherCREATE = buttonPersonTeacherCREATE;
	}

	public JButton getButtonPersonBachelorCREATE() {
		return buttonPersonBachelorCREATE;
	}

	public void setButtonPersonBachelorCREATE(JButton buttonPersonBachelorCREATE) {
		this.buttonPersonBachelorCREATE = buttonPersonBachelorCREATE;
	}

	public JButton getButtonPersonMasterCREATE() {
		return buttonPersonMasterCREATE;
	}

	public void setButtonPersonMasterCREATE(JButton buttonPersonMasterCREATE) {
		this.buttonPersonMasterCREATE = buttonPersonMasterCREATE;
	}

	public JButton getButtonPersonPhDCREATE() {
		return buttonPersonPhDCREATE;
	}

	public void setButtonPersonPhDCREATE(JButton buttonPersonPhDCREATE) {
		this.buttonPersonPhDCREATE = buttonPersonPhDCREATE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public JButton getButtonRETURN() {
		return buttonRETURN;
	}


	public void setButtonRETURN(JButton buttonRETURN) {
		this.buttonRETURN = buttonRETURN;
	}
}
