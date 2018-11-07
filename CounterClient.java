package proj.client;

import java.io.*;
import java.net.*;

public class CounterClient {
    private String hostname;
    private int port;
    private String counterName;
 
    public CounterClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to Pharma server");

            new ReadThread (socket, this).start();
            new WriteThread(socket, this).start();

        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Syntax: java CounterClient <host_name> <port_nuumber>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        CounterClient client = new CounterClient(hostname, port);
        client.execute();

    }
}