package com.DEI.TP2;

import java.util.ArrayList;
import java.util.Date;

public class Doctorate extends Grantee {
    //Variables
    private final double COST = 1200;

    //Constructor
    public Doctorate(String name, String email, ArrayList<Task> tasks, Date grantBegin, Date grantEnd, Project project) {
        super(name, email, tasks, grantBegin, grantEnd, project);
    }

    //Other Functions

    //toString
    @Override
    public String toString() {
        String out = "";
        //TODO: Function
        return out;
    }
}
