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
import javax.swing.JTextField;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;

public class PersonGUI extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Label
	private JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel labelName;
	JLabel labelEmail;
	JLabel labelGrantBegin;
	JLabel labelGrantEnd;
	JLabel labelCategory;
	// Text
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textGrantBeginDay;
	private JTextField textGrantBeginMonth;
	private JTextField textGrantBeginYear;
	private JTextField textGrantEndDay;
	private JTextField textGrantEndMonth;
	private JTextField textGrantEndYear;
	private JTextField textMecanographicNumber;
	private JTextField textInvestigationArea;
	// List
	private DefaultListModel<InvestigationCenter> listValues;
	private JList<InvestigationCenter> list;
	private JScrollPane listScroller;

	private int x;
	private int y;

	public PersonGUI(int x, int y) { 
		super();
		// List
		listValues = new DefaultListModel<InvestigationCenter>();
		list = new JList<InvestigationCenter>(listValues);
		listScroller = new JScrollPane(list); 
		// Buttons	
		/*
			buttonCREATE.addActionListener(this);
			buttonREMOVE.addActionListener(this);
			buttonENTER.addActionListener(this);
		 */


		this.setLayout(new GridBagLayout());

		title = new JLabel("Investigations Centers Manager");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;       
		c.gridy = 0;
		c.gridwidth = 5;
		this.add(title, c);


		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;       
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 5;       
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		this.add(emptyLabel2, c);

		setButtonCREATE(new JButton("Create Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 1; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		this.add(getButtonCREATE(), c);
/*
		setText(new JTextField(10)); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 2;
		c.weighty = 0;
		c.ipadx = 10;
		c.ipady = 10;
		c.gridx = 4;       
		c.gridy = 1;
		c.gridheight = 1;  
		c.gridwidth = 1;
		this.add(getText(), c);

		setButtonREMOVE(new JButton("Remove Investigation Center")); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 3;       
		c.gridy = 2; 
		c.gridheight = 1;  
		c.gridwidth = 1;  
		this.add(getButtonREMOVE(), c);

		setButtonENTER(new JButton("Enter in Investigation Center")); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 2;       
		c.gridy = 5; 
		c.gridheight = 1;  
		c.gridwidth = 1;
		this.add(getButtonENTER(), c);

		listScroller = new JScrollPane(list); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.ipady = 10;
		c.ipadx = 100;
		c.gridx = 2;       
		c.gridy = 1;       
		c.gridheight = 4;   
		c.gridwidth = 1; 
		this.add(listScroller, c);
*/
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

	public JTextField getTextMecanographicNumber() {
		return textMecanographicNumber;
	}

	public void setTextMecanographicNumber(JTextField textMecanographicNumber) {
		this.textMecanographicNumber = textMecanographicNumber;
	}

	public JTextField getTextInvestigationArea() {
		return textInvestigationArea;
	}

	public void setTextInvestigationArea(JTextField textInvestigationArea) {
		this.textInvestigationArea = textInvestigationArea;
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
