package aa.proj;

import java.util.concurrent.*;
import java.util.Random;

import aa.proj.PatientQueue;

public class Counter {
    //attributes
    private PatientQueue q;
    private String name;
    private int nowServing;
    private int totalServed;

    //constructor
    /**
     * Creates a Counter instance with the specified name to serve the specific PatientQueue
     * @param name String Name of the Counter
     * @param q PatientQueue 
     */
    public Counter(String name, PatientQueue q) {
        this.name = name;
        this.q = q;
    }

    //getters
    /**
     * This method returns the Counter's name
     * @return String Name of Counter
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the q number of the patient that the Counter is currently serving
     * @return int Queue number of patient
     */
    public int getNowServing() {
        return nowServing;
    }

    /**
     * This method returns the total number of patients served by the Counter
     * @return int Total number of patients served by the Counter 
     */
    public int getTotalServed() {
        return totalServed;
    }

    //setters
    /** This method sets the Counter's name
     * @param name A String containing the Counter's name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the queue number of the patient the Counter is currently serving
     * @param nowServing int Queue number of patient Counter is currently serving
     */
    public void setNowServing(int nowServing) {
        this.nowServing = nowServing;
        simulateDelay();
        totalServed++;
    }

    /**
     * Adapted from Week 2 ICE Ex4 (Coffee Shop Robot Problem) CoffeeShop.java
     * This method is to simulate delay when "serving" patients.
     */
    public void simulateDelay() {
        Random rand = new Random();
        int randDelay =(rand.nextInt(1000) + 500);

        try {
            Thread.sleep(randDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}