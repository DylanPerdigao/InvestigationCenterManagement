package pt.uc.dei.student.TP2.sourceCode;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFrame;

import pt.uc.dei.student.TP2.GUI.InvestigationCenterGUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Main class of the program
 *
 * @author	Dylan Gonçalves Perdigão
 * @author	Bruno Ricardo Leitão Faria
 * @version	1.0
 * @since	05-12-2019
 */
public class Main {
    /**
     * This is the main function of the program
     * 
     * @param args This is input parameters
     * @since 01-12-2019 
     */
	public static void main(String[] args){
		InvestigationCenter IC = new InvestigationCenter(null,new ArrayList<>(), new ArrayList<>());
		/*
		 * READ OBJECT FILE
		 */
		File inputObjFile = new File("ressources/InvestigationsCenter.obj");
		try {
			FileInputStream fis = new FileInputStream(inputObjFile); 
			ObjectInputStream ois = new ObjectInputStream(fis);
			IC = (InvestigationCenter)ois.readObject();
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
					double completion = 0;
					boolean isCompleted = false;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					while((line = br.readLine()) != null) {
						try {
							if(line.startsWith("INVESTIGATION CENTER:\t")) {
								//SPLIT
								String[] stringIC = line.split("INVESTIGATION CENTER:\t",0);
								//ADD TO LIST
								IC.setName(stringIC[1]);
							}
							else if(line.startsWith("PROJECT:\t")) {
								//SPLIT
								String[] stringP = line.split("PROJECT:\t",0);
								String[] projectInfo;
								projectInfo = stringP[1].split("/",0);
								//PROJECT OBJECT
								String name = projectInfo[0];
								String acronym = projectInfo[1];
								LocalDate begin = LocalDate.parse(projectInfo[2],formatter);
								int duration = Integer.parseInt(projectInfo[3]);
								Project project = new Project(name, acronym,begin,null,duration,new Teacher(),new ArrayList<>(), new ArrayList<>(),isCompleted);
								IC.addProject(project);
							}
							else if(line.startsWith("\tTASK:\t")) {
								//SPLIT
								String[] stringT = line.split("\tTASK:\t",0);
								String[] taskInfo = stringT[1].split("/",0);
								//TASK OBJECT
								String name = taskInfo[0];
								String taskType = taskInfo[1];
								LocalDate begin = LocalDate.parse(taskInfo[2],formatter);
								int duration = Integer.parseInt(taskInfo[3]);
								//ADD TO LIST
								int projectCounter = IC.getProjects().size()-1;
								switch(taskType) {	
								case "DOC":
									IC.getProjects().get(projectCounter).createTask(new Documentation(name,begin, null, duration,null,completion));
									break;
								case "DES":
									IC.getProjects().get(projectCounter).createTask(new Design(name,begin, null, duration,null,completion));
									break;
								case "DEV":
									IC.getProjects().get(projectCounter).createTask(new Development(name,begin, null, duration,null,completion));
									break;
								default:
									System.out.print("Error reading task Type");
								}
							}
							else if(line.startsWith("\tTEACHER:\t")) {
								//SPLIT
								String[] stringTeacher = line.split("\tTEACHER:\t",0);
								String[] teacherInfo = stringTeacher[1].split("/",0);
								//TEACHER OBJECT
								String name = teacherInfo[0];
								String email = teacherInfo[1];
								int mecanographicNumber = Integer.parseInt(teacherInfo[2]);
								String investigationArea = teacherInfo[3];
								Teacher teacher = new Teacher(name,email,mecanographicNumber,investigationArea,new ArrayList<>(), new ArrayList<>());
								//ADD TO LIST
								IC.getPeople().add(teacher);
							}
							else if(line.startsWith("\tBACHELOR:\t")) {
								String[] stringBachelor = line.split("\tBACHELOR:\t",0);
								String[] bachelorInfo = stringBachelor[1].split("/",0);
								//BACHELOR OBJECT
								String name = bachelorInfo[0];
								String email = bachelorInfo[1];
								LocalDate begin = LocalDate.parse(bachelorInfo[2],formatter);
								LocalDate end = LocalDate.parse(bachelorInfo[3],formatter);
								Bachelor bachelor = new Bachelor(name, email, new ArrayList<>(),begin,end, null, new ArrayList<>());
								//ADD TO LIST
								IC.getPeople().add(bachelor);
							}
							else if(line.startsWith("\tMASTER:\t")) {
								String[] stringMaster = line.split("\tMASTER:\t",0);
								String[] masterInfo = stringMaster[1].split("/",0);
								//MASTER OBJECT
								String name = masterInfo[0];
								String email = masterInfo[1];
								LocalDate begin = LocalDate.parse(masterInfo[2],formatter);
								LocalDate end = LocalDate.parse(masterInfo[3],formatter);
								Master master = new Master(name, email, new ArrayList<>(),begin,end, null, new ArrayList<>());
								//ADD TO LIST
								IC.getPeople().add(master);
							}
							else if(line.startsWith("\tPhD:\t")) {
								String[] stringPhD = line.split("\tPhD:\t",0);
								String[] phdInfo = stringPhD[1].split("/",0);
								//MASTER OBJECT
								String name = phdInfo[0];
								String email = phdInfo[1];
								LocalDate begin = LocalDate.parse(phdInfo[2],formatter);
								LocalDate end = LocalDate.parse(phdInfo[3],formatter);
								PhD phd = new PhD(name, email, new ArrayList<>(),begin,end, null);
								//ADD TO LIST
								IC.getPeople().add(phd);
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
		frame.setTitle(IC.getName()); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		InvestigationCenterGUI main = new InvestigationCenterGUI(frame,IC);
		main.initialize();
		main.listenWindow();
	}
}
