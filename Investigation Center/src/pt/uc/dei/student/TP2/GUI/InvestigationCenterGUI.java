package pt.uc.dei.student.TP2.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.*;

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
	private InvestigationCenter investigationCenter;

	public InvestigationCenterGUI(JFrame frame,InvestigationCenter investigationCenter) {
		this.frame=frame;
		this.investigationCenter=investigationCenter;

		update();
	}


	public void initialize(){

		frame.setLayout(new GridBagLayout());
		listPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getListProjectMembers().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		
		setButtonADDPeopleToProject(new JButton("Add selected person to selected project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 5;       	//posiçao celula x
		c.gridy = 4; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonADDPeopleToProject(), c);

		setButtonREMOVEPeopleFromProject(new JButton("Remove selected person to selected project"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 5;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonREMOVEPeopleFromProject(), c);
		
		labelProjects = new JLabel("Project Members");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(labelProjects, c);


		setListScrollerProjectMembers(new JScrollPane(getListProjectMembers()));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 5;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getListScrollerProjectMembers(), c);
		
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
		InvestigationCenterGUI.Listener actionListener = new InvestigationCenterGUI.Listener();
		buttonENTER.addActionListener(actionListener);
		buttonProjectCREATE.addActionListener(actionListener);
		buttonProjectREMOVE.addActionListener(actionListener);
		buttonADDPeopleToProject.addActionListener(actionListener);
		buttonREMOVEPeopleFromProject.addActionListener(actionListener);
		buttonRETURN.addActionListener(actionListener);

		listPeople.addMouseListener(actionListener);
		listProjects.addMouseListener(actionListener);


		frame.setVisible(true);
	}

	private void close(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}

	private class Listener implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == buttonProjectCREATE) {
				try {
					ProjectCreatorGUI projectGUI = new ProjectCreatorGUI(frame,investigationCenter);
					close();
					projectGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectREMOVE) {
				try {
					if (listProjects.getSelectedValue() != null) {
						ArrayList<Project> projects= investigationCenter.getProjects();
						projects.remove(listProjects.getSelectedValue());
						investigationCenter.setProjects(projects);
						update();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				try {
					if (listProjects.getSelectedValue() != null) {
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame, investigationCenter, listProjects.getSelectedValue());
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
						ArrayList<Project> projects= investigationCenter.getProjects();
						projects.remove(project);
						project.addMember(listPeople.getSelectedValue());
						projects.add(project);
						investigationCenter.setProjects(projects);
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
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame, investigationCenter, listProjects.getSelectedValue());
						close();
						projectManagementGUI.initialize();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonRETURN) {
				try {
					/*MainGUI mainGUI = new MainGUI(frame, listaIC);
					close();
					mainGUI.initialize();*/
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
	}

	private void update() {
		// Lists
		listValuesPeople = new DefaultListModel<Person>();
		listValuesPeople.addAll(investigationCenter.getPeople());
		listPeople = new JList<Person>(listValuesPeople);
		setListScrollerPeople(new JScrollPane(listPeople));
		
		listValuesProjectMembers = new DefaultListModel<Person>();
		listProjectMembers = new JList<Person>(getListValuesProjectMembers());
		setListScrollerProjectMembers(new JScrollPane(getListProjectMembers()));

		listValuesProjects = new DefaultListModel<Project>();
		listValuesProjects.addAll(investigationCenter.getProjects());
		listProjects = new JList<Project>(listValuesProjects);
		setListScrollerProjects(new JScrollPane(listProjects));
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

	public void setListScrollerProjects(JScrollPane listScrollerProjects) { this.listScrollerProjects = listScrollerProjects; }

	public JButton getButtonRETURN() {
		return buttonRETURN;
	}

	public void setButtonRETURN(JButton buttonRETURN) {
		this.buttonRETURN = buttonRETURN;
	}


	public JButton getButtonADDPeopleToProject() {
		return buttonADDPeopleToProject;
	}


	public void setButtonADDPeopleToProject(JButton buttonADDPeopleToProject) {
		this.buttonADDPeopleToProject = buttonADDPeopleToProject;
	}


	public JButton getButtonREMOVEPeopleFromProject() {
		return buttonREMOVEPeopleFromProject;
	}


	public void setButtonREMOVEPeopleFromProject(JButton buttonREMOVEPeopleFromProject) {
		this.buttonREMOVEPeopleFromProject = buttonREMOVEPeopleFromProject;
	}


	DefaultListModel<Person> getListValuesProjectMembers() {
		return listValuesProjectMembers;
	}


	void setListValuesProjectMembers(DefaultListModel<Person> listValuesProjectMembers) {
		this.listValuesProjectMembers = listValuesProjectMembers;
	}


	private JList<Person> getListProjectMembers() {
		return listProjectMembers;
	}


	private void setListProjectMembers(JList<Person> listProjectMembers) {
		this.listProjectMembers = listProjectMembers;
	}


	private JScrollPane getListScrollerProjectMembers() {
		return listScrollerProjectMembers;
	}


	private void setListScrollerProjectMembers(JScrollPane listScrollerProjectMembers) {
		this.listScrollerProjectMembers = listScrollerProjectMembers;
	}
}
