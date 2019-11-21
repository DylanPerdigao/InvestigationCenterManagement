package com.DEI.TP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        InvestigationCenter cisuc = new InvestigationCenter("CISUC", null, null);
        LocalDate begin = LocalDate.of(1999, 06, 10);
        System.out.print(begin.toString());
        LocalDate end = LocalDate.of(2000, 06, 10);
        ArrayList<Person> pess = new ArrayList<Person>();

        cisuc.addProject(new Project("P1","proj",begin,end,10,null, pess, null, false));
        cisuc.toString();
    }
}
