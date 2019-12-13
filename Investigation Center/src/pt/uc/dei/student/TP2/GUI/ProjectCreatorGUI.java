package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Project;

/**
 * This class represent the Graphical User Interface of the menu for creating a new project.
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	13-12-2019
 * @version	1.0
 */

public class ProjectCreatorGUI{
	// Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Text
	private JTextField textName;
	private JTextField textAcronym;
	private JTextField textDuration;
	//ComboBox
	private JComboBox<String> beginDayList,beginMonthList,beginYearList;
	private JComboBox<String> endDayList,endMonthList,endYearList;
	private String[] days = new String[31];
	private String[] months = new String[12];
	private String[] years = new String[LocalDate.now().getYear()-1970+1];
	//Frame
	private JFrame frame;
	//Investigation center
	private InvestigationCenter IC;
    /**
     * This is the constructor of the main GUI of the program.
     * 
     * @param frame	This is the frame of the program
     * @param IC	This is the investigation center object which contains all the informations for the application
     * @since 13-12-2019
     */
	public ProjectCreatorGUI(JFrame frame, InvestigationCenter IC) {
		this.frame=frame;
		this.IC=IC;
	}
    /**
     * This method initialize the Graphical User Interface with all components 
     * @since 13-12-2019
     */
	public void initialize(){
		frame.setLayout(new GridBagLayout());
		for(int d=1;d<=31;d++) {
			days[d-1]=String.valueOf(d);
		}
		for(int m=1;m<=12;m++) {
			months[m-1]=String.valueOf(m);
		}
		for(int y=1970;y<=LocalDate.now().getYear();y++) {
			years[y-1970]=String.valueOf(y);
		}
		//TITLE
		JLabel title = new JLabel("Add a new Project");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 9;
		frame.add(title, c);
		//SET BLANK SPACES
		placeComponent(new JLabel(""),0,9,1,1,10,10,0,0);
		placeComponent(new JLabel(""),8,9,1,1,10,10,0,0);
		placeComponent(new JLabel(""),8,7,1,1,0.5,10,0,0);
		//NAME
		placeComponent(new JLabel("Name"),1,1,1,1,0.5,0.5,0,0);
		textName = new JTextField(10);
		placeComponent(textName,2,1,6,1,0.5,0.5,0,0);
		//ACRONYM
		placeComponent(new JLabel("Acronym"),1,2,1,1,0.5,0.5,0,0);
		textAcronym = new JTextField(10);
		placeComponent(textAcronym,2,2,1,1,0.5,0.5,0,0);
		//BEGIN DATE
		placeComponent(new JLabel("Begin Date"),1,3,1,1,0,0.5,0, 0);
		beginDayList = new JComboBox<String>(days);
		placeComponent(beginDayList,2,3,1,1,0,0.5,0, 0);
		beginMonthList = new JComboBox<String>(months);
		placeComponent(beginMonthList,3,3,1,1,0,0.5,0, 0);
		beginYearList = new JComboBox<String>(years);
		placeComponent(beginYearList,4,3,1,1,0,0.5,0, 0);
		//END DATE
		placeComponent(new JLabel("End Date"),1,4,1,1,0.5,0.5,0, 0);
		endDayList = new JComboBox<String>(days);
		placeComponent(endDayList,2,4,1,1,0.5,0.5,0, 0);
		endMonthList = new JComboBox<String>(months);
		placeComponent(endMonthList,3,4,1,1,0.5,0.5,0, 0);
		endYearList = new JComboBox<String>(years);
		placeComponent(endYearList,4,4,1,1,0.5,0.5,0, 0);
		//DURATION
		placeComponent(new JLabel("Duration"),1,5,1,1,0.5,0.5,0, 0);
		textDuration = new JTextField(10);
		placeComponent(textDuration,2,5,1,1,0.5,0.5,0, 0);
		//CREATE
		buttonCREATE = new JButton("Add Project");
		placeComponent(buttonCREATE,4,8,4,1,0.5,0,0, 10);
		//CANCEL
		buttonCANCEL = new JButton("Cancel");
		placeComponent(buttonCANCEL,2,8,1,1,0.5,0,0, 10);
		//Listeners
		ProjectCreatorGUI.ButtonListener buttonActionListener = new ProjectCreatorGUI.ButtonListener();
		buttonCREATE.addActionListener(buttonActionListener);
		buttonCANCEL.addActionListener(buttonActionListener);
		//SET VISIBLE
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
    /**
     * This class overrides some listeners.
     * @since 13-12-2019
     */
	private class ButtonListener implements ActionListener {
	    /**
	     * This method gets events from buttons and treat them to do some work.
	     * @param e	This is the handled event
	     * @since 13-12-2019
	     */
		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonCREATE){
				try{
					if (!textName.getText().equals("") && !textAcronym.getText().equals("") && !textDuration.getText().equals("")) {
						int dur= Integer.parseInt(textDuration.getText());
						//maybe chekar estas proximas 2 linhas mais tarde
						LocalDate begin = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(beginYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginDayList.getSelectedItem())));
						LocalDate end = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(endYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endDayList.getSelectedItem())));

						if (end.isAfter(begin)) {
							Project project = new Project(textName.getText(), textAcronym.getText(), begin, end, dur, null, new ArrayList<>(), new ArrayList<>(), false);
							IC.addProject(project);

							close();
							InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame, IC);
							investigationCenterGUI.initialize();
						}
						else{
							JOptionPane.showMessageDialog(null, "Insert an end date greater than the begin date","", JOptionPane.PLAIN_MESSAGE);
						}
					}
				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Insert only numbers in the duration box","", JOptionPane.PLAIN_MESSAGE);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonCANCEL) {
				try {
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame,IC);
					close();
					investigationCenterGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
