package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Person;
import pt.uc.dei.student.TP2.sourceCode.Project;
import pt.uc.dei.student.TP2.sourceCode.Teacher;

public class ProjectGUI{

	private static final long serialVersionUID = 1L;
	// Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Label
	private JLabel title;
	private JLabel emptyLabel1;
	private JLabel emptyLabel2;
	private JLabel emptyLabel3;
	private JLabel labelName;
	private JLabel labelAcronym;
	private JLabel labelGrantBegin;
	private JLabel labelGrantEnd;
	private JLabel labelDuration;
	// Text
	private JTextField textName;
	private JTextField textAcronym;
	private JTextField textGrantBeginDay;
	private JTextField textGrantBeginMonth;
	private JTextField textGrantBeginYear;
	private JTextField textGrantEndDay;
	private JTextField textGrantEndMonth;
	private JTextField textGrantEndYear;
	private JTextField textDuration;

	private JFrame frame;
	private InvestigationCenter investigationCenter;

	public ProjectGUI(JFrame frame, InvestigationCenter investigationCenter) {
		super();
		this.frame=frame;
		this.investigationCenter=investigationCenter;

	}
	public void initialize(){
		frame.setLayout(new GridBagLayout());

		title = new JLabel("Add a new Project");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 9;
		frame.add(title, c);

		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel2, c);

		emptyLabel3 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(emptyLabel3, c);

		labelName = new JLabel("Name");
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

		labelAcronym = new JLabel("Acronym");
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

		labelGrantBegin = new JLabel("Begin Date");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelGrantBegin, c);

		textGrantBeginDay = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantBeginDay, c);

		textGrantBeginMonth = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantBeginMonth, c);

		textGrantBeginYear = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantBeginYear, c);

		labelGrantEnd = new JLabel("End Date");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelGrantEnd, c);

		textGrantEndDay = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantEndDay, c);

		textGrantEndMonth = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantEndMonth, c);

		textGrantEndYear = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(textGrantEndYear, c);
		
		labelDuration = new JLabel("Duration");
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
		ProjectGUI.ButtonListener buttonActionListener = new ProjectGUI.ButtonListener();

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
					//não é importante para ja
					System.out.println("não é importante para ja\n");
				} catch (Exception ex) {
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
