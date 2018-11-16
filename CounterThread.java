package aa.proj;

import java.io.*;
import java.net.*;
import java.util.*;

import aa.proj.Counter;
import aa.proj.PharmacyServer;

public class CounterThread extends Thread {
    private String name;
    private Socket client;
    private PharmacyServer server;
    private PrintWriter writer;
    private Counter counter;

    /**
     * Creates a CounterThread with the given paramaters.
     * @param client Socket 
     * @param server PharmacyServer
     * @param counter Counter
     */
    public CounterThread(Socket client, PharmacyServer server, Counter counter) {
        this.client = client;
        this.server = server;
        this.counter = counter;
    }

    @Override
    public void run() {

        try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
            
            String inputLine = in.readLine();  // to get message from Pharmacy client (client's out is server's in)            
            while (server.getRemaining() > 0) {
                int nowServing = server.getNext();
                String responseLine = "" + nowServing;
                counter.setNowServing(nowServing);

                // display
                System.out.println(counter.getName() + " now serving : " + counter.getNowServing());
                System.out.println();
                
                out.println(responseLine);  // to client (server's out is client's in)
                inputLine = in.readLine();  // to get message from Pharmacy client
            }
            out.println("close");

            // display overall report
            System.out.println("\t[ REPORT FOR " + counter.getName() + " ]\n\t---Report Start---");
            System.out.println("\t\t=> Total Patients Served : " + counter.getTotalServed());
            System.out.println("\t---Report End---\nClosing " + counter.getName()+"\n");

        } catch (IOException e) {
            System.err.println("Client disconnected.");
        }
    }
}