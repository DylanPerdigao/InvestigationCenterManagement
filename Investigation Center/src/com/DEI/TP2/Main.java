package com.DEI.TP2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
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
