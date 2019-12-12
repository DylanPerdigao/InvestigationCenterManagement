package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Person;
import pt.uc.dei.student.TP2.sourceCode.Project;
import pt.uc.dei.student.TP2.sourceCode.Teacher;

/**
 * This class represent the advised students of a project (Bachelor and Master students)
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @since	05-12-2019
 * @version	1.0
 */

public class ProjectCreatorGUI{

	private static final long serialVersionUID = 1L;
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

	private JFrame frame;
	private InvestigationCenter investigationCenter;

	public ProjectCreatorGUI(JFrame frame, InvestigationCenter investigationCenter) {
		super();
		this.frame=frame;
		this.investigationCenter=investigationCenter;

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

		JLabel labelAcronym = new JLabel("Acronym");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelAcronym, c);

		textAcronym = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textAcronym, c);

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
		ProjectCreatorGUI.ButtonListener buttonActionListener = new ProjectCreatorGUI.ButtonListener();

		buttonCREATE.addActionListener(buttonActionListener);
		buttonCANCEL.addActionListener(buttonActionListener);


		frame.setVisible(true);
	}

	private void close(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonCREATE){
				try{
					if (!textName.getText().equals("") && !textAcronym.getText().equals("") && !textDuration.getText().equals("")) {
						int dur= Integer.parseInt(textDuration.getText());
						//maybe chekar estas proximas 2 linhas mais tarde
						LocalDate begin = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(beginYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(beginDayList.getSelectedItem())));
						LocalDate end = LocalDate.of(Integer.parseInt((String) Objects.requireNonNull(endYearList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endMonthList.getSelectedItem())),Integer.parseInt((String) Objects.requireNonNull(endDayList.getSelectedItem())));

						if (end.isAfter(begin)) {
							Project project = new Project(textName.getText(), textAcronym.getText(), begin, end, dur, null, null, null, false);
							investigationCenter.addProject(project);


							InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame, investigationCenter);
							close();
							investigationCenterGUI.initialize();
						}
						else{
							JOptionPane.showMessageDialog(null, "Insert an end date greater than the starter","", JOptionPane.PLAIN_MESSAGE);
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
					InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(frame,investigationCenter);
					close();
					investigationCenterGUI.initialize();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
