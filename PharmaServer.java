package proj.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class PharmaServer {
    private int port;
    private Set<String> counterNames = new HashSet<String>();
    private Set<CounterThread> counterThreads = new HashSet<CounterThread>();
    private int[] queue;

    public PharmaServer(int port) {
        this.port = port;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            
            System.out.println("Pharma Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New counter connected");

                CounterThread newCounter = new CounterThread(socket, this);
                counterThreads.add(newCounter);
                newCounter.start();
            }

        } catch (IOException i) {
            System.out.println("Error in PharmaServer: " + i.getMessage());
            i.printStackTrace();
        }
    }

    public void broadcast(String msg, CounterThread excludeCounter) {
        for (CounterThread c : counterThreads) {
            if (c != excludeCounter) {
                c.sendMessage(msg);
            }
        }
    }

    public void addCounterName(String counterName) {
        counterNames.add(counterName);
    }

    public void removeCounter(String counterName, CounterThread counter) {
        // boolean isRemoved = counterNames.remove(counterName);
        if (counterNames.remove(counterName)) { //returns true if set contains object
            counterThreads.remove(counter);
            System.out.println("Counter " + counterName + " has logged off.");
        }
    }

    public Set<String> getActiveCounters() {
        return this.counterNames;
    }

    public boolean hasActiveCounters() {
        return !this.counterNames.isEmpty();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java PharmaServer <port_nuumber>");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        PharmaServer server = new PharmaServer(port);
        server.execute();
    }

    public void startQueue() {
        
    }

}