package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.*;

/**
 * This class represent the Graphical User Interface of the menu for creating a new task.
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	13-12-2019
 * @version	1.0
 */
public class TaskCreatorGUI{
	// Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Text
	private JTextField textName;
	private JTextField textDuration;
	//Combo Box
	private JComboBox<String> tasksTypeList;
	private String[] tasksType = {"Documentation","Design","Development"};
	private JComboBox<String> beginDayList,beginMonthList,beginYearList;
	private JComboBox<String> endDayList,endMonthList,endYearList;
	private String[] days = new String[31];
	private String[] months = new String[12];
	private String[] years = new String[LocalDate.now().getYear()-1970+1];
	//Frame
	private JFrame frame;
	//Investigation Center
	private InvestigationCenter IC;
	//Project
	private Project project;
    /**
     * This is the constructor of the main GUI of the program.
     * 
     * @param frame	This is the frame of the program.
     * @param IC	This is the investigation center object which contains all the informations for the application.
     * @param project	This is the project object which contains all the informations about the selected project by the user.
     * @since 13-12-2019
     */
	public TaskCreatorGUI(JFrame frame, InvestigationCenter IC, Project project) {
		this.frame=frame;
		this.IC=IC;
		this.project=project;

	}
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

		// Label
		JLabel title = new JLabel("Add a new Task");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 9;
		frame.add(title, c);

		JLabel emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel1, c);

		JLabel emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel2, c);

		JLabel emptyLabel3 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel3, c);

		JLabel labelName = new JLabel("Name");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelName, c);

		textName = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 6;
		frame.add(textName, c);

		JLabel labelTaskType = new JLabel("Task Type");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelTaskType, c);

		tasksTypeList = new JComboBox<String>(tasksType);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(tasksTypeList, c);

		JLabel labelBegin = new JLabel("Begin Date");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelBegin, c);

		beginDayList = new JComboBox<String>(days);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(beginDayList, c);

		beginMonthList = new JComboBox<String>(months);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(beginMonthList, c);

		beginYearList = new JComboBox<String>(years);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(beginYearList, c);

		JLabel labelEnd = new JLabel("End Date");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelEnd, c);

		endDayList = new JComboBox<String>(days);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(endDayList, c);

		endMonthList = new JComboBox<String>(months);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(endMonthList, c);

		endYearList = new JComboBox<String>(years);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(endYearList, c);

		JLabel labelDuration = new JLabel("Duration");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelDuration, c);

		textDuration = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textDuration, c);
		
		buttonCREATE = new JButton("Add Project");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5; // percentagem de largura celula em relacao as outras
		c.weighty = 0; // percentagem de altura celula em relacao as outras
		c.ipady = 10; // altura celula
		c.gridx = 4; // posiçao celula x
		c.gridy = 8; // posiçao celula y
		c.gridheight = 1; // quantos celulas de altura
		c.gridwidth = 4; // quantos celulas de largura
		frame.add(buttonCREATE, c);

		buttonCANCEL = new JButton("Cancel");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5; // percentagem de largura celula em relacao as outras
		c.weighty = 0; // percentagem de altura celula em relacao as outras
		c.ipady = 10; // altura celula
		c.gridx = 2; // posiçao celula x
		c.gridy = 8; // posiçao celula y
		c.gridheight = 1; // quantos celulas de altura
		c.gridwidth = 1; // quantos celulas de largura
		frame.add(buttonCANCEL, c);

		//Listeners
		TaskCreatorGUI.ButtonListener buttonActionListener = new TaskCreatorGUI.ButtonListener();

		buttonCREATE.addActionListener(buttonActionListener);
		buttonCANCEL.addActionListener(buttonActionListener);


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
					int duration = Integer.parseInt(textDuration.getText());
					String name = textName.getText();
					//maybe checkar estas proximas 2 linhas mais tarde
					LocalDate begin = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(beginYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginDayList.getSelectedItem())));
					LocalDate end = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(endYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endDayList.getSelectedItem())));
					if (end.isAfter(begin)) {
						Task task=null;
						//checkar o switch
						switch ((String) Objects.requireNonNull(tasksTypeList.getSelectedItem())) {
							case "Documentation":
								task = new Documentation(name, begin, end, duration, null, 0);
								break;
							case "Design":
								task = new Design(name, begin, end, duration, null, 0);
								break;
							case "Development":
								task = new Development(name, begin, end, duration, null, 0);
								break;
						}

						project.createTask(task);

						close();
						ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame,IC,project);
						projectManagementGUI.initialize();;
					}
					else{
						JOptionPane.showMessageDialog(null, "Insert an end date greater than the starter","", JOptionPane.PLAIN_MESSAGE);
					}

				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Insert only numbers in the duration box","", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == buttonCANCEL) {
				try {
					close();
					ProjectManagementGUI projectManagementGUI = new ProjectManagementGUI(frame,IC,project);
					projectManagementGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
