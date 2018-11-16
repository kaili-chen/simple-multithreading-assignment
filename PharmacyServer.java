package aa.proj;

import java.net.*;
import java.io.*;
import java.util.*;

import aa.proj.PatientQueue;

public class PharmacyServer {
    private int port;
    private PatientQueue queue = new PatientQueue(500); // add 500 patients into the queue
    private List<CounterThread> counters = new ArrayList<CounterThread>();
    private char counterNamer;

    /**
     * Creates an instance of PharmacyServer with the given port number. 
     * @param port int Port number to start the server
     */
    public PharmacyServer(int port) {
        this.port = port;
        counterNamer = 'A';
    }

    public void execute() {

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Pharmacy Server is listening on port " + port);
            while (true) {
                //for each connected client, start its own CounterThread
                Socket clientSocket = serverSocket.accept();

                String cName = getNextCounterName();
                CounterThread newCounter = new CounterThread(clientSocket, this, new Counter(cName, queue));
                newCounter.start();

                System.out.println(cName + " Connected");
                System.out.println("Num active threads = " + Thread.activeCount() + "\n");
                
            }
        } catch (IOException e) {
            System.out.println("Error in Pharmacy Server: " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * This method returns the number of patients in the queue. The queue is not altered after the invokation of this method.
     * @return int Number of patients in the queue
     */
    public int getRemaining() {
        return queue.getQueueSize();
    }

    /**
     * This method returns the queue number of patient at the head of the queue after removing the patient from the head of the queue. The queue is altered after the invokation of this method.
     * @return int Queue number of the next patient in line.
     */
    public synchronized int getNext() {
        return queue.serveNext();
    }

    /**
     * This method returns the name of the next counter to be opened.
     * @return String Name of the next Counter to be opened
     */
    public String getNextCounterName() {
        String newCounterName = "Pharmacy Counter " + counterNamer;
        counterNamer++;
        return newCounterName;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java aa.proj.PharmacyServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        PharmacyServer server = new PharmacyServer(port);
        server.execute();
    }
}