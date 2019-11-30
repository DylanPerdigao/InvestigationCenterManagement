package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	// Label
	private JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
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

	public InvestigationCenterGUI(int x, int y, String name) { 
		super();
		// List
		listValuesPeople = new DefaultListModel<Person>();
		listValuesProjects = new DefaultListModel<Project>();
		listPeople = new JList<Person>(listValuesPeople);
		listProjects = new JList<Project>(listValuesProjects);
		setListScrollerPeople(new JScrollPane(listPeople)); 
		setListScrollerProjects(new JScrollPane(listProjects)); 
		// Buttons	
		/*
			buttonCREATE.addActionListener(this);
			buttonREMOVE.addActionListener(this);
			buttonENTER.addActionListener(this);
		 */

		this.setLayout(new GridBagLayout());

		title = new JLabel(name);
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;       
		c.gridy = 0;
		c.gridwidth = 6;
		this.add(title, c);


		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;       
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 6;       
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(emptyLabel2, c);

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
		this.add(getButtonPersonBachelorCREATE(), c);
		
		setButtonPersonMasterCREATE(new JButton("Add Master Student"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 3; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		this.add(getButtonPersonMasterCREATE(), c);
		
		setButtonPersonPhDCREATE(new JButton("Add PhD Student"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 4; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		this.add(getButtonPersonPhDCREATE(), c);
		
		setButtonPersonTeacherCREATE(new JButton("Add Teacher"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 5; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		this.add(getButtonPersonTeacherCREATE(), c);

		setButtonPersonREMOVE(new JButton("Remove Person")); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 0;
		c.gridx = 3;       
		c.gridy = 6; 
		c.gridheight = 1;  
		c.gridwidth = 1;  
		this.add(getButtonPersonREMOVE(), c);
		
		labelPeople = new JLabel("People List");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;       
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(labelPeople, c);
		
		listScrollerPeople = new JScrollPane(listPeople); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;       
		c.gridy = 2;       
		c.gridheight = 5;   
		c.gridwidth = 1; 
		this.add(listScrollerPeople, c);
		
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
		this.add(getButtonProjectCREATE(), c);

		setButtonProjectREMOVE(new JButton("Remove Project")); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 5;       
		c.gridy = 3; 
		c.gridheight = 1;  
		c.gridwidth = 1;  
		this.add(getButtonProjectREMOVE(), c);

		setButtonENTER(new JButton("Enter in Project")); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 4;       
		c.gridy = 7; 
		c.gridheight = 1;  
		c.gridwidth = 1;
		this.add(getButtonENTER(), c);
		
		labelProjects = new JLabel("Projects List");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;       
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(labelProjects, c);
		
		listScrollerProjects = new JScrollPane(listProjects); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 4;       
		c.gridy = 2;       
		c.gridheight = 5;   
		c.gridwidth = 1; 
		this.add(listScrollerProjects, c);

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
}
