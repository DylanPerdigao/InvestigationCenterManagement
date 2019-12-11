package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;
import pt.uc.dei.student.TP2.sourceCode.Teacher;

public class AdvisedStudentGUI{

	// Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Label
	JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel emptyLabel3;
	JLabel labelName;
	JLabel labelEmail;
	JLabel labelGrantBegin;
	JLabel labelGrantEnd;
	JLabel labelAdvisors;
	// Text
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textGrantBeginDay;
	private JTextField textGrantBeginMonth;
	private JTextField textGrantBeginYear;
	private JTextField textGrantEndDay;
	private JTextField textGrantEndMonth;
	private JTextField textGrantEndYear;

	// List
	DefaultListModel<Teacher> listValues;
	private JList<Teacher> list;
	private JScrollPane listScroller;

	private int x;
	private int y;
	private JFrame frame;
	private InvestigationCenter investigationCenter;
	private String type;

	public AdvisedStudentGUI(JFrame frame, InvestigationCenter investigationCenter, String type) {
		super();
		this.frame=frame;
		this.investigationCenter=investigationCenter;
		this.type=type;

		// List
		listValues = new DefaultListModel<Teacher>();
		list = new JList<Teacher>(listValues);
		setListScroller(new JScrollPane(list));
		// Buttons
		/*
		 * buttonCREATE.addActionListener(this); buttonREMOVE.addActionListener(this);
		 * buttonENTER.addActionListener(this);
		 */
		 
	}
	public void initialize(){
		frame.setLayout(new GridBagLayout());

		title = new JLabel("Add a new "+type);
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
		frame.add(getTextName(), c);

		labelEmail = new JLabel("Email");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelEmail, c);

		textEmail = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 6;
		frame.add(getTextEmail(), c);

		labelGrantBegin = new JLabel("Grant Begin");
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
		frame.add(getTextGrantBeginDay(), c);

		textGrantBeginMonth = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getTextGrantBeginMonth(), c);

		textGrantBeginYear = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getTextGrantBeginYear(), c);

		labelGrantEnd = new JLabel("Grant End");
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
		frame.add(getTextGrantEndDay(), c);

		textGrantEndMonth = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getTextGrantEndMonth(), c);

		textGrantEndYear = new JTextField(10);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getTextGrantEndYear(), c);

		labelAdvisors = new JLabel("Select Advisors");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(labelAdvisors, c);

		listScroller = new JScrollPane(list);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 2;
		c.gridwidth = 3;
		frame.add(listScroller, c);

		buttonCREATE = new JButton("Add Person");
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
		AdvisedStudentGUI.ButtonListener buttonActionListener = new AdvisedStudentGUI.ButtonListener();

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

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	public JTextField getTextGrantBeginDay() {
		return textGrantBeginDay;
	}

	public void setTextGrantBeginDay(JTextField textGrantBeginDay) {
		this.textGrantBeginDay = textGrantBeginDay;
	}

	public JTextField getTextGrantBeginMonth() {
		return textGrantBeginMonth;
	}

	public void setTextGrantBeginMonth(JTextField textGrantBeginMonth) {
		this.textGrantBeginMonth = textGrantBeginMonth;
	}

	public JTextField getTextGrantBeginYear() {
		return textGrantBeginYear;
	}

	public void setTextGrantBeginYear(JTextField textGrantBeginYear) {
		this.textGrantBeginYear = textGrantBeginYear;
	}

	public JTextField getTextGrantEndDay() {
		return textGrantEndDay;
	}

	public void setTextGrantEndDay(JTextField textGrantEndDay) {
		this.textGrantEndDay = textGrantEndDay;
	}

	public JTextField getTextGrantEndMonth() {
		return textGrantEndMonth;
	}

	public void setTextGrantEndMonth(JTextField textGrantEndMonth) {
		this.textGrantEndMonth = textGrantEndMonth;
	}

	public JTextField getTextGrantEndYear() {
		return textGrantEndYear;
	}

	public void setTextGrantEndYear(JTextField textGrantEndYear) {
		this.textGrantEndYear = textGrantEndYear;
	}

	public JButton getButtonCREATE() {
		return buttonCREATE;
	}

	public void setButtonCREATE(JButton buttonCREATE) {
		this.buttonCREATE = buttonCREATE;
	}

	public JButton getButtonCANCEL() {
		return buttonCANCEL;
	}

	public void setButtonCANCEL(JButton buttonCANCEL) {
		this.buttonCANCEL = buttonCANCEL;
	}

	public JScrollPane getListScroller() {
		return listScroller;
	}

	public void setListScroller(JScrollPane listScroller) {
		this.listScroller = listScroller;
	}
}
