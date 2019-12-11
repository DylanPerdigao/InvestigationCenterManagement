package pt.uc.dei.student.TP2.sourceCode;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;

import pt.uc.dei.student.TP2.GUI.MainGUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Main class of the program
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Leitão Faria
 * @version	1.0
 * @since	05-12-2019
 */

public class Main {


	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		ArrayList<InvestigationCenter> listIC = new ArrayList<InvestigationCenter>();
		/*
		 * READ OBJECT FILE
		 */
		File inputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileInputStream fis = new FileInputStream(inputObjFile); 
			ObjectInputStream ois = new ObjectInputStream(fis);
			listIC = (ArrayList<InvestigationCenter>)ois.readObject();
			ois.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Object File not found, it will read init.txt file"); 
			/*
			 * READ FILE TXT IF OBJECT FILE DOES NOT EXIST
			 */
			File f = new File("ressources/init.txt");
			if(f.exists() && f.isFile()) { 
				try {
					FileReader fr = new FileReader(f); 
					BufferedReader br = new BufferedReader(fr);
					String line;
					String token = null;
					int ICCounter=0;
					int projectCounter=0;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					while((line = br.readLine()) != null) {
						try {
							token = "INVESTIGATION CENTER:\t";
							if(line.startsWith(token)) {
								//SPLIT
								String[] stringIC = line.split(token,0);
								//ADD TO LIST
								listIC.add(new InvestigationCenter(stringIC[1], new ArrayList<Person>(), new ArrayList<Project>()));
							}
							token = "PROJECT:\t";
							if(line.startsWith(token)) {
								//SPLIT
								String[] stringP = line.split(token,0);
								String[] projectInfo = stringP[1].split("/",0);
								//PROJECT OBJECT
								String name = projectInfo[0];
								String acronym = projectInfo[1];
								LocalDate begin = LocalDate.parse(projectInfo[2],formatter);
								LocalDate end = LocalDate.parse(projectInfo[3],formatter);
								int duration = Integer.parseInt(projectInfo[4]);
								boolean isCompleted = Boolean.parseBoolean(projectInfo[5]);
								Project project = new Project(name, acronym,begin,end,duration,new Teacher(),new ArrayList<Person>(), new ArrayList<Task>(),isCompleted);
								//ADD TO LIST
								ICCounter = listIC.size()-1;
								listIC.get(ICCounter).addProject(project);
							}
							token = "\tTASK:\t";
							if(line.startsWith(token)) {
								//SPLIT
								String[] stringT = line.split(token,0);
								String[] taskInfo = stringT[1].split("/",0);
								//TASK OBJECT
								String name = taskInfo[0];
								double effortRate = Double.parseDouble(taskInfo[1]);
								LocalDate begin = LocalDate.parse(taskInfo[2],formatter);
								LocalDate end = LocalDate.parse(taskInfo[3],formatter);
								int duration = Integer.parseInt(taskInfo[4]);
								double completion = Double.parseDouble(taskInfo[5]);
								//ADD TO LIST
								projectCounter = listIC.get(ICCounter).getProjects().size()-1;
								if(effortRate==0.25) {		
									Documentation task = new Documentation(name, effortRate,begin, end, duration,new Person(),completion);
									listIC.get(ICCounter).getProjects().get(projectCounter).createTask(task);
								}else if(effortRate==0.5) {
									Design task = new Design(name, effortRate,begin, end, duration,new Person(),completion);
									listIC.get(ICCounter).getProjects().get(projectCounter).createTask(task);
								}else if(effortRate==1) {
									Development task = new Development(name, effortRate,begin, end, duration,new Person(),completion);
									listIC.get(ICCounter).getProjects().get(projectCounter).createTask(task);
								}else{
									System.out.printf("Error with effort rate");
								}
							}
							token = "\tTEACHER:\t";
							if(line.startsWith(token)) {
								//SPLIT
								String[] stringTeacher = line.split(token,0);
								String[] teacherInfo = stringTeacher[1].split("/",0);
								//TEACHER OBJECT
								String name = teacherInfo[0];
								String email = teacherInfo[1];
								int mecanographicNumber = Integer.parseInt(teacherInfo[2]);
								String investigationArea = teacherInfo[3];
								Teacher teacher = new Teacher(name,email,mecanographicNumber,investigationArea,new ArrayList<Task>(), new ArrayList<Project>());
								//ADD TO LIST
								projectCounter = listIC.get(ICCounter).getPeople().size()-1;
								listIC.get(ICCounter).getPeople().add(teacher);
							}
							token = "\tBACHELOR:\t";
							if(line.startsWith(token)) {
								String[] stringBachelor = line.split(token,0);
								String[] bachelorInfo = stringBachelor[1].split("/",0);
								//BACHELOR OBJECT
								String name = bachelorInfo[0];
								String email = bachelorInfo[1];
								LocalDate begin = LocalDate.parse(bachelorInfo[2],formatter);
								LocalDate end = LocalDate.parse(bachelorInfo[3],formatter);
								Bachelor bachelor = new Bachelor(name, email, new ArrayList<Task>(),begin,end, new Project(), new ArrayList<Teacher>());
								//ADD TO LIST
								projectCounter = listIC.get(ICCounter).getPeople().size()-1;
								listIC.get(ICCounter).getPeople().add(bachelor);
							}
							token = "\tMASTER:\t";
							if(line.startsWith(token)) {
								String[] stringMaster = line.split(token,0);
								String[] masterInfo = stringMaster[1].split("/",0);
								//MASTER OBJECT
								String name = masterInfo[0];
								String email = masterInfo[1];
								LocalDate begin = LocalDate.parse(masterInfo[2],formatter);
								LocalDate end = LocalDate.parse(masterInfo[3],formatter);
								Master master = new Master(name, email, new ArrayList<Task>(),begin,end, new Project(), new ArrayList<Teacher>());
								//ADD TO LIST
								projectCounter = listIC.get(ICCounter).getPeople().size()-1;
								listIC.get(ICCounter).getPeople().add(master);
							}
							token = "\tPhD:\t";
							if(line.startsWith(token)) {
								String[] stringPhD = line.split(token,0);
								String[] phdInfo = stringPhD[1].split("/",0);
								//MASTER OBJECT
								String name = phdInfo[0];
								String email = phdInfo[1];
								LocalDate begin = LocalDate.parse(phdInfo[2],formatter);
								LocalDate end = LocalDate.parse(phdInfo[3],formatter);
								PhD phd = new PhD(name, email, new ArrayList<Task>(),begin,end, new Project());
								//ADD TO LIST
								projectCounter = listIC.get(ICCounter).getPeople().size()-1;
								listIC.get(ICCounter).getPeople().add(phd);
							}
						}catch(Exception e){
							System.out.println("Invalid line format: "+line); 
						}
					}
					br.close();
				} catch (FileNotFoundException e) {
					System.out.println("Error opening text file"); 
				} catch (IOException e) {
					System.out.println("Error reading text file"); 
				}
			} else {
				System.out.println("File does not exist");
			}
		} catch (IOException ex) {
			System.out.println("Erro a ler ficheiro."); 
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro a converter objeto."); 
		}
		/*
		 * GRAPHICAL USER INTERFACE
		 */
		JFrame frame = new JFrame();
		frame.setTitle("Investigation Center"); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//int x=frame.getWidth();
		//int y=frame.getHeight();
		MainGUI mainGUI = new MainGUI(frame,listIC);
		mainGUI.initialize();
		/*TODO: put it everywhere
		 * WRITE OBJECT FILE
		 */
		/*
		File outputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileOutputStream fos = new FileOutputStream(outputObjFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listIC);
			oos.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error creating file"); 
		} catch (IOException ex) {
			System.out.println("Error writing file"); 
		}*/

	}
}
