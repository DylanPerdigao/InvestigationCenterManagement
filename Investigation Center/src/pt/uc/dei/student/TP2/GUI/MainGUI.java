package pt.uc.dei.student.TP2.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import pt.uc.dei.student.TP2.sourceCode.InvestigationCenter;

public class MainGUI{

	private static final long serialVersionUID = 1L;
	// Buttons
	private JButton buttonCREATE;
	private JButton buttonREMOVE;
	private JButton buttonENTER;

	//Constraints
	private GridBagConstraints c = new GridBagConstraints();
	// Text
	private JTextField text;
	// List
	DefaultListModel<InvestigationCenter> listValues;
	private JList<InvestigationCenter> list;
	private JScrollPane listScroller;
	
	private JFrame frame;
	private ArrayList<InvestigationCenter> listIC;
	
	public MainGUI(JFrame frame,ArrayList<InvestigationCenter> listIC) {
		super();
		setFrame(frame);
		setListIC(listIC);

		update();
	}

	public void initialize(){
		
		getFrame().setLayout(new GridBagLayout());

		// Label
		JLabel title = new JLabel("Investigations Centers Manager");
		Font font = new Font("impact", 0, 50);
		title.setFont(font);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		getFrame().add(title, c);


		JLabel emptyLabel1 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(emptyLabel1, c);

		JLabel emptyLabel2 = new JLabel("");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 10;
		c.gridx = 5;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight= 1;
		getFrame().add(emptyLabel2, c);

		setButtonCREATE(new JButton("Create Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;	//percentagem de largura celula em relacao as outras
		c.weighty = 0;		//percentagem de altura celula em relacao as outras
		c.ipady = 10;		//altura celula
		c.gridx = 3;       	//posiçao celula x
		c.gridy = 1; 		//posiçao celula y
		c.gridheight = 1;   //quantos celulas de altura
		c.gridwidth = 1;	//quantos celulas de largura
		getFrame().add(getButtonCREATE(), c);

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
		getFrame().add(getText(), c);

		setButtonREMOVE(new JButton("Remove Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		getFrame().add(getButtonREMOVE(), c);

		setButtonENTER(new JButton("Enter in Investigation Center"));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipady = 10;
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		getFrame().add(getButtonENTER(), c);

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
		getFrame().add(listScroller, c);

		//Listeners
		ButtonListener buttonActionListener = new ButtonListener();
		buttonCREATE.addActionListener(buttonActionListener);
		buttonENTER.addActionListener(buttonActionListener);
		buttonREMOVE.addActionListener(buttonActionListener);

		getFrame().setVisible(true);
	}

	private void close(){
		getFrame().getContentPane().removeAll();
		getFrame().repaint();
	}

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource()== buttonCREATE){
				try{
					if (!text.getText().equals("")) {
						InvestigationCenter investigationCenter= new InvestigationCenter(text.getText(), null, null);
						listIC.add(investigationCenter);
						update();
						text.setText("");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonREMOVE) {
				try {
					if (list.getSelectedValue() != null) {
						listIC.remove(list.getSelectedValue());
						update();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource() == buttonENTER) {
				try {
					if (list.getSelectedValue() != null) {
						InvestigationCenterGUI investigationCenterGUI = new InvestigationCenterGUI(getFrame(),list.getSelectedValue());
						close();
						investigationCenterGUI.initialize();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	private void update() {
		// List
		listValues = new DefaultListModel<InvestigationCenter>();
		listValues.addAll(listIC);
		list = new JList<InvestigationCenter>(listValues);
		listScroller = new JScrollPane(list);
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

	private JFrame getFrame() {
		return frame;
	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private ArrayList<InvestigationCenter> getListIC() {
		return listIC;
	}

	private void setListIC(ArrayList<InvestigationCenter> listIC) {
		this.listIC = listIC;
	}
}