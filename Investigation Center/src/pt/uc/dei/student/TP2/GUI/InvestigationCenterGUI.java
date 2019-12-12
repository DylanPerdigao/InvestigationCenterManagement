package pt.uc.dei.student.TP2.GUI;

import java.awt.*;
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
import java.util.ArrayList;


import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.*;

/**
 * This class represent the advised students of a project (Bachelor and Master students)
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */

public class InvestigationCenterGUI {
	
	//Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonProjectCREATE;
	private JButton buttonProjectREMOVE;
	private JButton buttonADDPeopleToProject;
	private JButton buttonREMOVEPeopleFromProject;
	private JButton buttonENTER;
	private JButton buttonRETURN;
	// Label
	JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel emptyLabel3;
	JLabel labelPeople;
	JLabel labelProjects;
	JLabel labelProjectMembers;
	// List
	DefaultListModel<Person> listValuesPeople;
	private DefaultListModel<Person> listValuesProjectMembers;
	DefaultListModel<Project> listValuesProjects;
	private JList<Person> listPeople;
	private JList<Person> listProjectMembers;
	private JList<Project> listProjects;
	private JScrollPane listScrollerPeople;
	private JScrollPane listScrollerProjectMembers;
	private JScrollPane listScrollerProjects;

	private JFrame frame;
	private InvestigationCenter IC;

	public InvestigationCenterGUI(JFrame frame,InvestigationCenter IC) {
		this.frame=frame;
		this.IC=IC;

		update();
	}


	public void initialize(){

		frame.setLayout(new GridBagLayout());
		listPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProjectMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		title = new JLabel(IC.getName());
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
		
		buttonRETURN = new JButton("Return");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 2;       	//posiçao celula x
		c.gridy = 9; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(buttonRETURN, c);
		
		/*
		 * PEOPLE
		 */
		
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

		buttonProjectCREATE = new JButton("Add Project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 2; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(buttonProjectCREATE, c);

		buttonProjectREMOVE = new JButton("Remove Project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 5;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(buttonProjectREMOVE, c);
		
		buttonADDPeopleToProject = new JButton("Add selected person to selected project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 4; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(buttonADDPeopleToProject, c);

		buttonREMOVEPeopleFromProject = new JButton("Remove selected person to selected project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 5;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(buttonREMOVEPeopleFromProject, c);
		
		labelProjects = new JLabel("Project Members");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(labelProjects, c);


		listScrollerProjectMembers = new JScrollPane(listProjectMembers);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 5;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(listScrollerProjectMembers, c);
		
		buttonENTER = new JButton("Enter in Project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 4;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(buttonENTER, c);

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
		InvestigationCenterGUI.Listener listener = new InvestigationCenterGUI.Listener();
		buttonENTER.addActionListener(listener);
		buttonProjectCREATE.addActionListener(listener);
		buttonProjectREMOVE.addActionListener(listener);
		buttonADDPeopleToProject.addActionListener(listener);
		buttonREMOVEPeopleFromProject.addActionListener(listener);
		buttonRETURN.addActionListener(listener);
		
		listPeople.addMouseListener(listener);
		listProjects.addMouseListener(listener);
		
		frame.addWindowListener(listener);

		frame.setVisible(true);
	}

	private void close(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	private void update() {
		// Lists
		listValuesPeople = new DefaultListModel<Person>();
		listValuesPeople.addAll(IC.getPeople());
		listPeople = new JList<Person>(listValuesPeople);
		listScrollerPeople = new JScrollPane(listPeople);
		
		listValuesProjectMembers = new DefaultListModel<Person>();
		listProjectMembers = new JList<Person>(listValuesProjectMembers);
		listScrollerProjectMembers = new JScrollPane(listProjectMembers);

		listValuesProjects = new DefaultListModel<Project>();
		listValuesProjects.addAll(IC.getProjects());
		listProjects = new JList<Project>(listValuesProjects);
		listScrollerProjects = new JScrollPane(listProjects);
	}
	private void save() {
		File outputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileOutputStream fos = new FileOutputStream(outputObjFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(IC);
			oos.close();
			} catch (FileNotFoundException ex) {
			System.out.println("Error creating file");
		} catch (IOException ex) {
			System.out.println("Error writing file");
		}
	}
	private class Listener implements ActionListener, MouseListener,WindowListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == buttonProjectCREATE) {
				try {
					ProjectCreatorGUI projectGUI = new ProjectCreatorGUI(frame,IC);
					close();
					projectGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectREMOVE) {
				try {
					if (listProjects.getSelectedValue() != null) {
						ArrayList<Project> projects= IC.getProjects();
						projects.remove(listProjects.getSelectedValue());
						IC.setProjects(projects);
						update();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				try {
					if (listProjects.getSelectedValue() != null) {
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame, IC, listProjects.getSelectedValue());
						close();
						projectManagementGUI.initialize();
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonADDPeopleToProject) {
				try {
					if (listPeople.getSelectedValue() != null && listProjects.getSelectedValue() != null) {
						Project project = listProjects.getSelectedValue();
						ArrayList<Project> projects= IC.getProjects();
						projects.remove(project);
						project.addMember(listPeople.getSelectedValue());
						projects.add(project);
						IC.setProjects(projects);
						listValuesProjectMembers.addAll(project.getMembers());
						update();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonREMOVEPeopleFromProject) {
				try {
					if (listProjects.getSelectedValue() != null) {
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame, IC, listProjects.getSelectedValue());
						close();
						projectManagementGUI.initialize();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonRETURN) {
				try {
					save();
					close();
					frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getSource() == listPeople) {
				Person p = listPeople.getSelectedValue();
				//listPeople.clearSelection();
				String message = "Name:\t"+p.getName()+"\nE-mail:\t"+p.getEmail();
				if(p instanceof Bachelor) {
					Bachelor bachelorStudent = (Bachelor) p;
					message += "\nBACHELOR STUDENT";
					message += "\nGrant begin:\t"+bachelorStudent.getGrantBegin();
					message += "\nGrant end:\t"+bachelorStudent.getGrantEnd();
					message += "\nCost per month:\t"+bachelorStudent.getCost()+"€";
				}if(p instanceof Master) {
					Master masterStudent = (Master) p;
					message += "\nMASTER STUDENT";
					message += "\nGrant begin:\t"+masterStudent.getGrantBegin();
					message += "\nGrant end:\t"+masterStudent.getGrantEnd();
					message += "\nCost per month:\t"+masterStudent.getCost()+"€";
				}if(p instanceof PhD) {
					PhD PhDStudent = (PhD) p;
					message += "\nPhD STUDENT";
					message += "\nGrant begin:\t"+PhDStudent.getGrantBegin();
					message += "\nGrant end:\t"+PhDStudent.getGrantEnd();
					message += "\nCost per month:\t"+PhDStudent.getCost()+"€";
				}if(p instanceof Teacher) {
					Teacher teacher = (Teacher) p;
					message += "\nTEACHER";
					message += "\nMecanographic Number:\t"+teacher.getMecanographicNumber();
					message += "\nInvestigation Area:\t"+teacher.getInvestigationArea();
				}
				JOptionPane.showMessageDialog(null, message,"People Description", JOptionPane.PLAIN_MESSAGE);
			}else if(e.getSource() == listProjects) {
				listProjectMembers.removeAll();
				listValuesProjectMembers.addAll(listProjects.getSelectedValue().getMembers());
				//TODO TIPO APAGAR E ATUALIZAR ESSA LISTA CADA VEZ QUE SE MUDA DE SELECAO NO PROJETO
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
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
	}
}
