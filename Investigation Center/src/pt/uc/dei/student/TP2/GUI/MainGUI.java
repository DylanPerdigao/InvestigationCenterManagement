package pt.uc.dei.student.TP2.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;

public class MainGUI extends JPanel{

	private static final long serialVersionUID = 1L;
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonREMOVE;
	private JButton buttonENTER;

	//Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Label
	private JLabel title;
	private JLabel emptyLabel1;
	private JLabel emptyLabel2;
	// Text
	private JTextField text;
	// List
	private DefaultListModel<InvestigationCenter> listValues;
	private JList<InvestigationCenter> list;
	private JScrollPane listScroller;

	private int x;
	private int y;
	
	public MainGUI(/*int x, int y*/) {
		super();

		//TODO: read config

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


	}

	public void initialize(){
		JFrame frame = new JFrame();
		frame.setTitle("Investigation Center");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x=frame.getWidth();
		int y=frame.getHeight();


		frame.setLayout(new GridBagLayout());

		title = new JLabel("Investigations Centers Manager");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		frame.add(title, c);


		emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(emptyLabel1, c);

		emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 5;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		frame.add(emptyLabel2, c);

		setButtonCREATE(new JButton("Create Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 1; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		frame.add(getButtonCREATE(), c);

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
		frame.add(getText(), c);

		setButtonREMOVE(new JButton("Remove Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonREMOVE(), c);

		setButtonENTER(new JButton("Enter in Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		frame.add(getButtonENTER(), c);

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
		frame.add(listScroller, c);

		//Listeners
		ButtonListener buttonActionListener = new ButtonListener();
		buttonCREATE.addActionListener(buttonActionListener);
		buttonENTER.addActionListener(buttonActionListener);
		buttonREMOVE.addActionListener(buttonActionListener);

		frame.setVisible(true);
	}

	public JScrollPane getListScroller() {
		return listScroller;
	}

	public void setListScroller(JScrollPane listScroller) {
		this.listScroller = listScroller;
	}

	private JTextField getText() {
		return text;
	}

	private void setText(JTextField text) {
		this.text = text;
	}

	private JButton getButtonENTER() {
		return buttonENTER;
	}

	private void setButtonENTER(JButton buttonENTER) {
		this.buttonENTER = buttonENTER;
	}

	private JButton getButtonREMOVE() {
		return buttonREMOVE;
	}

	private void setButtonREMOVE(JButton buttonREMOVE) {
		this.buttonREMOVE = buttonREMOVE;
	}

	private JButton getButtonCREATE() {
		return buttonCREATE;
	}

	private void setButtonCREATE(JButton buttonCREATE) {
		this.buttonCREATE = buttonCREATE;
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

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonCREATE){
				try{
					//
					listValues.add(0, new InvestigationCenter(text.getText(), null, null));
					text.setText("");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonREMOVE) {
				try {
					listValues.removeElement(list.getSelectedValue());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				InvestigationCenterGUI investigationCenterGUI= new InvestigationCenterGUI(list.getSelectedValue().getName());
				investigationCenterGUI.initialize(list.getSelectedValue().getName());
			}
		}
		
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		InvestigationCenter IC = list.getSelectedValue();
		String name = text.getText();
		if(e.getSource() == buttonCREATE) {
			System.out.println("TEST");
			listValues.add(0, new InvestigationCenter(name, null, null));
			emptyLabel1.setText(name);
		}else if(e.getSource() == buttonREMOVE) {
			listValues.removeElement(IC);
		}else if(e.getSource() == buttonENTER) {

		}


	}*/
}

