package proj.networking.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class CounterThread extends Thread {
    private Socket socket;
    private PharmaServer server;
    private PrintWriter writer;

    public CounterThread (Socket socket, PharmaServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            printActiveCounters();

            String counterName = reader.readLine();
            server.addCounterName(counterName);

            String serverMsg = "New Counter connected: " + counterName;
            server.broadcast(serverMsg, this);

            String clientMsg = "";

            do {
                clientMsg = reader.readLine();
                serverMsg = "[" + counterName + "]" + clientMsg;
                server.broadcast(serverMsg, this);
            } while (!clientMsg.equals("bye"));

            server.removeCounter(counterName, this);
            socket.close();

            serverMsg = counterName + " has logged off.";
            server.broadcast(serverMsg, this);

        } catch (IOException i) {
            System.out.println("Error in CounterThread: " + i.getMessage());
            i.printStackTrace();
        }
    }

    public void printActiveCounters() {
        if (server.hasActiveCounters()) {
            writer.println("Connected counters: " + server.getActiveCounters());
        } else {
            writer.println("There are no active counters.");
        }
    }

    public void sendMessage(String msg) {
        writer.println(msg);
    }
}