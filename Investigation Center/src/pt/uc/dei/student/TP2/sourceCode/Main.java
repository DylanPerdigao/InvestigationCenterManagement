package pt.uc.dei.student.TP2.sourceCode;

import pt.uc.dei.student.TP2.GUI.AdvisedStudentGUI;
import pt.uc.dei.student.TP2.GUI.InvestigationCenterGUI;
import pt.uc.dei.student.TP2.GUI.MainGUI;
import pt.uc.dei.student.TP2.GUI.PhDGUI;
import pt.uc.dei.student.TP2.GUI.TeacherGUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main class of the program
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @version	1.0
 * @since	05-12-2019
 */

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
		
		MainGUI mainGUI = new MainGUI(frame);
		mainGUI.initialize();

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

}
