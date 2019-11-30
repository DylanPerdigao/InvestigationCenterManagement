package pt.uc.dei.student.TP2.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TeacherGUI extends JPanel{
	private static final long serialVersionUID = 1L;

	// Constraints
	GridBagConstraints c = new GridBagConstraints();
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonCANCEL;
	// Label
	private JLabel title;
	JLabel emptyLabel1;
	JLabel emptyLabel2;
	JLabel emptyLabel3;
	JLabel labelName;
	JLabel labelEmail;
	JLabel labelMecanographicNumber;
	JLabel labelInvestigationArea;

	// Text
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textMecanographicNumber;
	private JTextField textInvestigationArea;

	private int x;
	private int y;

	public TeacherGUI(int x, int y) {
		super();

		// Buttons
		/*
		 * buttonCREATE.addActionListener(this); buttonREMOVE.addActionListener(this);
		 * buttonENTER.addActionListener(this);
		 */

		this.setLayout(new GridBagLayout());
		
		title = new JLabel("Add a new Teacher");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 9;
		this.add(title, c);

		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(emptyLabel2, c);
		
		emptyLabel3 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 8;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(emptyLabel3, c);
		
		labelName = new JLabel("Name");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(labelName, c);
		
		textName = new JTextField(10); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;       
		c.gridy = 1;
		c.gridheight = 1;  
		c.gridwidth = 6;
		this.add(getTextName(), c);
		
		labelEmail = new JLabel("Email");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(labelEmail, c);
		
		textEmail = new JTextField(10); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;       
		c.gridy = 2;
		c.gridheight = 1;  
		c.gridwidth = 6;
		this.add(getTextEmail(), c);
		
		labelMecanographicNumber = new JLabel("Mecanographic Number");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(labelMecanographicNumber, c);
		
		textMecanographicNumber = new JTextField(10); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 2;       
		c.gridy = 3;
		c.gridheight = 1;  
		c.gridwidth = 1;
		this.add(textMecanographicNumber, c);
		
		labelInvestigationArea = new JLabel("Investigation Area");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(labelInvestigationArea, c);
		
		textInvestigationArea = new JTextField(10); 
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;       
		c.gridy = 4;
		c.gridheight = 1;  
		c.gridwidth = 1;
		this.add(textInvestigationArea, c);

		 
		buttonCREATE = new JButton("Add Person");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5; // percentagem de largura celula em relacao as outras
		c.weighty = 0; // percentagem de altura celula em relacao as outras
		c.ipady = 10; // altura celula
		c.gridx = 5; // posiçao celula x
		c.gridy = 8; // posiçao celula y
		c.gridheight = 1; // quantos celulas de altura
		c.gridwidth = 1; // quantos celulas de largura
		this.add(buttonCREATE, c);
		
		buttonCANCEL = new JButton("Cancel");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5; // percentagem de largura celula em relacao as outras
		c.weighty = 0; // percentagem de altura celula em relacao as outras
		c.ipady = 10; // altura celula
		c.gridx = 1; // posiçao celula x
		c.gridy = 8; // posiçao celula y
		c.gridheight = 1; // quantos celulas de altura
		c.gridwidth = 1; // quantos celulas de largura
		this.add(buttonCANCEL, c);


		 
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
