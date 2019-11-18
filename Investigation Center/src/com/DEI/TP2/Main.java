package com.DEI.TP2;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        InvestigationCenter cisuc = new InvestigationCenter( "CISUC");
        @Deprecated
        Date begin = new Date(100,0,5,10,10);
        @Deprecated
        Date end = new Date(100,1,8,10,10);
        ArrayList<Person> pess = new ArrayList<Person>();

        cisuc.addProject(new Project("P1","proj",begin,end,10,pess));
        cisuc.toString();
    }
}
