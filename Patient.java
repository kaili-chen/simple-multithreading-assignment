package proj.classes;

import java.util.*;

public class Patient {
    
    private String name;
    private ArrayList<Medicine> precriptions = new ArrayList<Medicine>();
    private int qNum;

    public Patient(String name) {
        this.name = name;
        qNum = 0;
    }
}