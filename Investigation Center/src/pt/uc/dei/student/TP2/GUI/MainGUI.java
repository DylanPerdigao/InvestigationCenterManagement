package pt.uc.dei.student.TP2.GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGUI extends JPanel{

	private JButton buttonIC = new JButton("Create Investigation Center");
	private JTextField text = new JTextField(10); 
	private JButton buttonENTER = new JButton("Enter");
	private JPanel panel = new JPanel();
	private GridLayout grid = new GridLayout(6, 5);
	
	public MainGUI() { 
		panel.setLayout(grid);
		for(int i=1; i<=grid.getColumns()*grid.getRows();i++) {
			switch(i) {
				case 13:
					panel.add(buttonIC);
					break;
				case 22:
					panel.add(text);
					break;
				case 24:
					panel.add(buttonENTER);
					break;
				default:
					panel.add(new JLabel("\t"+String.valueOf(i)));
			}
		}

		/*
		DefaultListModel listValues = new DefaultListModel();
		JList list = new JList(listValues);
		
		JScrollPane listScroller = new JScrollPane(list); 
		listScroller.setBounds(50, 35, 300, 150);*/
	}

}
