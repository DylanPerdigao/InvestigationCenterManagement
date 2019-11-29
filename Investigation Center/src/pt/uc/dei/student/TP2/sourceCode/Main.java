package pt.uc.dei.student.TP2.sourceCode;

import java.awt.BorderLayout;

import pt.uc.dei.student.TP2.GUI.MainGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Investigation Center"); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x=frame.getWidth();
		int y=frame.getHeight();

		/*
		Image image=null;
		try {
			image = ImageIO.read(new File("ressources/dei.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image); 
		icon.setImage(image);
		JLabel label = new JLabel();
		label.setIcon(icon);
		frame.add(label);
		//frame.setIconImage(image);*/
		
		MainGUI m = new MainGUI(x, y);
	
		frame.add(m);

		frame.setVisible(true);
		/*File peopleFile = new File("people.txt");
		for(String line:read(peopleFile)) {
			
		}
		ArrayList<Person> pess = new ArrayList<Person>();
		// write your code here
		InvestigationCenter cisuc = new InvestigationCenter("CISUC", null, null);
		LocalDate begin = LocalDate.of(1999, 06, 10);
		System.out.print(begin.toString());
		LocalDate end = LocalDate.of(2000, 06, 10);

		cisuc.addProject(new Project("P1","proj",begin,end,10,null, pess, null, false));
		cisuc.toString();*/
	}

	/*
	public static ArrayList<String> read(File f) {
		ArrayList<String> lines = new ArrayList<String>();
		if(f.exists() && f.isFile()) { 
			try {
				FileReader fr = new FileReader(f); 
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null) {
					lines.add(line);
				}
				br.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Erro a abrir ficheiro de texto.");
			} catch (IOException ex) {
				System.out.println("Erro a ler ficheiro de texto."); 
			}
		} else {
			System.out.println("Ficheiro não existe.");
		}
		return lines;
	}*/

	/*
	private static JPanel projectGUI(int x, int y) {	
		// Buttons
		JButton buttonADDPROJECT = new JButton("Add Project"); 
		JButton buttonADDPERSON = new JButton("Add Person"); 
		// Lists
			//People
			DefaultListModel<InvestigationCenter> listValues = new DefaultListModel<InvestigationCenter>();
			listValues.add(0, new InvestigationCenter("CISUC", null, null));
			listValues.add(0, new InvestigationCenter("EPFL", null, null));
			listValues.add(0, new InvestigationCenter("ERSUC", null, null));
			JList<InvestigationCenter> list = new JList<InvestigationCenter>(listValues);
			JScrollPane listScroller = new JScrollPane(list); 
			//Projects
			DefaultListModel<InvestigationCenter> listValues = new DefaultListModel<InvestigationCenter>();
			listValues.add(0, new InvestigationCenter("CISUC", null, null));
			listValues.add(0, new InvestigationCenter("EPFL", null, null));
			listValues.add(0, new InvestigationCenter("ERSUC", null, null));
			JList<InvestigationCenter> list = new JList<InvestigationCenter>(listValues);
			JScrollPane listScroller = new JScrollPane(list); 
		// Buttons grid
		JPanel panelButtons = new JPanel();
		GridLayout gridButton = new GridLayout(3, 1);
		panelButtons.setLayout(gridButton);
		panelButtons.add(buttonCREATE); 
		panelButtons.add(new JLabel(""));
		panelButtons.add(buttonENTER); 
		panelButtons.setOpaque(false);
		// Main panel
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    Image backgroundImage=null;
			try {
				backgroundImage = ImageIO.read(new File("ressources/dei.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    g.drawImage(backgroundImage, 0, 0,x,y,this);
		    
			}
		};

		
		GridLayout grid = new GridLayout(3, 3);
		
		panel.setLayout(grid);
		panel.add(new JLabel(""));panel.add(new JLabel(""));panel.add(new JLabel(""));panel.add(new JLabel(""));
		panel.add(listScroller);
		panel.add(panelButtons);
		panel.add(new JLabel(""));panel.add(new JLabel(""));panel.add(new JLabel(""));
		return panel;
	}
	*/
	private static JPanel test(int x, int y) {
		JButton button;
		// Main panel
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    Image backgroundImage=null;
			try {
				backgroundImage = ImageIO.read(new File("ressources/dei.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    g.drawImage(backgroundImage, 0, 0,x,y,this);
		    
			}
		};
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		button = new JButton("Add Project");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 10;
		c.gridx = 0;
		c.gridy = 10;
		c.fill = GridBagConstraints.VERTICAL;
		c.weighty = 5;
		panel.add(button, c);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(button, c);

		button = new JButton("Button 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(button, c);

		button = new JButton("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(button, c);

		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		panel.add(button, c);
		return panel;
	}
}
