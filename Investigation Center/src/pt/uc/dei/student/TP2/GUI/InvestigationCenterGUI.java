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
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.*;

/**
 * This class represent the Graphical User Interface of the main menu of the application
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	13-12-2019
 * @version	1.0
 */

public class InvestigationCenterGUI{
	//Formatter
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	//Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonProjectCREATE;
	private JButton buttonProjectREMOVE;
	private JButton buttonADDPeopleToProject;
	private JButton buttonREMOVEPeopleFromProject;
	private JButton buttonENTER;
	private JButton buttonINFO;
	// List
	private DefaultListModel<Person> listValuesPeople;
	private DefaultListModel<Person> listValuesProjectMembers;
	private DefaultListModel<Project> listValuesProjects;
	private JList<Person> listPeople;
	private JList<Person> listProjectMembers;
	private JList<Project> listProjects;
	private JScrollPane listScrollerPeople;
	private JScrollPane listScrollerProjectMembers;
	private JScrollPane listScrollerProjects;
	//Frame
	private JFrame frame;
	//Investigation Center
	private InvestigationCenter IC;
    /**
     * This is the constructor of the main GUI of the program.
     * 
     * @param frame	This is the frame of the program
     * @param IC	This is the investigation center object which contains all the informations for the application
     * @since 13-12-2019
     */
	public InvestigationCenterGUI(JFrame frame,InvestigationCenter IC) {
		this.frame = frame;
		this.IC=IC;

		// Lists
		listValuesPeople = new DefaultListModel<>();
		listValuesPeople.addAll(IC.getPeople());
		listPeople = new JList<>(listValuesPeople);
		listScrollerPeople = new JScrollPane(listPeople);

		listValuesProjectMembers = new DefaultListModel<>();
		listProjectMembers = new JList<>(listValuesProjectMembers);
		listScrollerProjectMembers = new JScrollPane(listProjectMembers);

		listValuesProjects = new DefaultListModel<>();
		listValuesProjects.addAll(IC.getProjects());
		listProjects = new JList<>(listValuesProjects);
		listScrollerProjects = new JScrollPane(listProjects);
	}

    /**
     * This method initialize the Graphical User Interface with all components 
     * @since 13-12-2019
     */
	public void initialize(){
		frame.setLayout(new GridBagLayout());
		listPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProjectMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*
		 * LABELS AND TITLE
		 */
		JLabel title = new JLabel(IC.getName());
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		frame.add(title, c);
		placeComponent(new JLabel(""),0,10,1,1,0.5,10,0,0);
		placeComponent(new JLabel(""),7,10,1,1,0.5,10,0,0);
		placeComponent(new JLabel(""),3,7,1,1,0.5,0.5,0,0);
		placeComponent(new JLabel(""),5,7,1,1,0.5,0.5,0,0);
		/*
		 * PEOPLE
		 */
		placeComponent(new JLabel("People List"),2,1,1,1,0.5,0.5,0,0);
		listScrollerPeople = new JScrollPane(listPeople);
		placeComponent(listScrollerPeople,2,2,1,6,0.5,10,10,100);

		buttonINFO = new JButton("Show Person Informations");
		placeComponent(buttonINFO,2,8,1,1,0.5,0,0,10);
		/*
		 * PROJECTS
		 */
		buttonProjectCREATE = new JButton("Add Project");
		placeComponent(buttonProjectCREATE,6,2,1,1,0.5,0,0,10);

		buttonProjectREMOVE = new JButton("Remove Project");
		placeComponent(buttonProjectREMOVE,6,3,1,1,0.5,0,0,10);
		
		buttonADDPeopleToProject = new JButton("Add Person to Project");
		placeComponent(buttonADDPeopleToProject,6,4,1,1,0.5,0,0,10);

		buttonREMOVEPeopleFromProject = new JButton("Remove Person to Project");
		placeComponent(buttonREMOVEPeopleFromProject,6,5,1,1,0.5,0,0,10);
		
		buttonENTER = new JButton("Enter in Project");
		placeComponent(buttonENTER,4,8,1,1,0.5,0.5,0,10);

		placeComponent(new JLabel("Projects List"),4,1,1,1,0.5,0.5,0,0);
		listScrollerProjects = new JScrollPane(listProjects);
		placeComponent(listScrollerProjects,4,2,1,6,0.5,10, 100, 10);
		/*
		 * MEMBERS
		 */
		placeComponent(new JLabel("Project Members"),6,6,1,1,0.5,0.5,0,0);
		listScrollerProjectMembers = new JScrollPane(listProjectMembers);
		placeComponent(listScrollerProjectMembers,6,7,1,1,0.5,10,100,10);
		/*
		 * LISTENERS
		 */
		InvestigationCenterGUI.Listener actionListener = new InvestigationCenterGUI.Listener();
		buttonENTER.addActionListener(actionListener);
		buttonProjectCREATE.addActionListener(actionListener);
		buttonProjectREMOVE.addActionListener(actionListener);
		buttonADDPeopleToProject.addActionListener(actionListener);
		buttonREMOVEPeopleFromProject.addActionListener(actionListener);
		buttonINFO.addActionListener(actionListener);
		listPeople.addMouseListener(actionListener);
		listProjects.addMouseListener(actionListener);
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
	public void update(){
		// List People
		listValuesPeople.removeAllElements();
		listValuesPeople.addAll(IC.getPeople());
		// List Project
		listValuesProjects.removeAllElements();
		listValuesProjects.addAll(IC.getProjects());
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
     * This method add window listener to the frame
     * @since 13-12-2019
     */
	public void listenWindow() {
		frame.addWindowListener(new InvestigationCenterGUI.Listener());
	}
    /**
     * This method saves the Investigation Center Object in a ObjectFile.
     * @since 13-12-2019
     */
	private void save() {
		File outputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileOutputStream fos = new FileOutputStream(outputObjFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(IC);
			oos.close();
			JOptionPane.showMessageDialog(null, "Work saved successfully","Save", JOptionPane.PLAIN_MESSAGE);
		} catch (FileNotFoundException ex) {
			System.out.println("Error creating file");
		} catch (IOException ex) {
			System.out.println("Error writing file");
		}
	}
    /**
     * This class overrides some listeners.
     * @since 13-12-2019
     */
	private class Listener implements ActionListener, MouseListener,WindowListener {
	    /**
	     * This method gets events from buttons and treat them to do some work.
	     * @param e	This is the handled event
	     * @since 13-12-2019
	     */
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == buttonProjectCREATE) {
				try {
					close();
					ProjectCreatorGUI projectGUI = new ProjectCreatorGUI(frame,IC);
					projectGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonProjectREMOVE) {
				try {
					if (listProjects.getSelectedValue() != null) {
						IC.removeProject(listProjects.getSelectedValue());
						update();
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a project first.","Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				try {
					if (listProjects.getSelectedValue() != null) {
						close();
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame, IC, listProjects.getSelectedValue());
						projectManagementGUI.initialize();
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a project first.","Error", JOptionPane.PLAIN_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonADDPeopleToProject) {
				try {
					if (listPeople.getSelectedValue() != null && listProjects.getSelectedValue() != null) {
						if (listProjects.getSelectedValue().getMembers().contains(listPeople.getSelectedValue())) {
							JOptionPane.showMessageDialog(null, "This person already belongs to this project","", JOptionPane.PLAIN_MESSAGE);
						}
						else{
							Project project = listProjects.getSelectedValue();
							IC.removeProject(project);
							project.addMember(listPeople.getSelectedValue());
							IC.addProject(project);
							listValuesProjectMembers.removeAllElements();
							listValuesProjectMembers.addAll(project.getMembers());
							update();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a person and a project first.","Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonREMOVEPeopleFromProject) {
				try {
					if (listProjects.getSelectedValue() != null && listProjectMembers.getSelectedValue() != null) {
						listProjects.getSelectedValue().removeMember(listProjectMembers.getSelectedValue());

						listValuesProjectMembers.removeAllElements();
						listValuesProjectMembers.addAll(listProjects.getSelectedValue().getMembers());
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a person and a project first.","Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonINFO) {
				try {
					if(listPeople.getSelectedValue()!=null) {
						Person p = listPeople.getSelectedValue();
						//listPeople.clearSelection();
						String message = "Name:\t" + p.getName() + "\nE-mail:\t" + p.getEmail();
						if (p instanceof Bachelor) {
							Bachelor bachelorStudent = (Bachelor) p;
							message += "\nBACHELOR STUDENT";
							message += "\nGrant begin:\t" + bachelorStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + bachelorStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + bachelorStudent.getCost() + "€";
						} else if (p instanceof Master) {
							Master masterStudent = (Master) p;
							message += "\nMASTER STUDENT";
							message += "\nGrant begin:\t" + masterStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + masterStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + masterStudent.getCost() + "€";
						} else if (p instanceof PhD) {
							PhD PhDStudent = (PhD) p;
							message += "\nPhD STUDENT";
							message += "\nGrant begin:\t" + PhDStudent.getGrantBegin().format(formatter);
							message += "\nGrant end:\t" + PhDStudent.getGrantEnd().format(formatter);
							message += "\nCost per month:\t" + PhDStudent.getCost() + "€";
						} else if (p instanceof Teacher) {
							Teacher teacher = (Teacher) p;
							message += "\nTEACHER";
							message += "\nMecanographic Number:\t" + teacher.getMecanographicNumber();
							message += "\nInvestigation Area:\t" + teacher.getInvestigationArea();
						}
						JOptionPane.showMessageDialog(null, message, "People Description", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Select a person first.","Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}
	    /**
	     * This method is overrided for update informations in the list
	     * @param e	This is the handled event
	     * @since 13-12-2019
	     */
		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getSource() == listProjects) {
				listValuesProjectMembers.removeAllElements();
				listValuesProjectMembers.addAll(listProjects.getSelectedValue().getMembers());
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	    /**
	     * This method is overrided for saving informations in object file when the window is closed
	     * @param e	This is the handled event
	     * @since 13-12-2019
	     */
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
}
