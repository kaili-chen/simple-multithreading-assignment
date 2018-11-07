package proj.classes;

import java.util.*;

public class Patient {
    
    private int patientID;
    private String patientName;
    private ArrayList<Medicine> prescriptions = new ArrayList<Medicine>();
    private String serviceAwaiting;
    private int qNum;

    public Patient(int patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
        qNum = 0;
    }

    //MANAGING PRESCRIPTIONS
    //mtd1: check if med already in prescriptions, if not, add, return boolean
    //mtd2: remove med from prescriptions, if doesnt exist in prescriptions, return false

    //GETTERS
    public int getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public ArrayList<Medicine> getPrescriptions() {
        return prescriptions;
    }

    public String getServiceAwaiting() {
        return serviceAwaiting;
    }

    public int getQNum() {
        return qNum;
    }

    //SETTERS
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setServiceAwaiting(String serviceAwaiting) {
        this.serviceAwaiting = serviceAwaiting;
    }

    public void setQNum(int qNum) {
        this.qNum = qNum;
    }
}