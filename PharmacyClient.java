package aa.proj;

import java.net.*;
import java.io.*;
import java.util.*;

public class PharmacyClient {
    private String hostname;
    private int port;

    public PharmacyClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try(
            Socket clientSocket = new Socket(hostname, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
            ) {
                
            System.out.println("Connected to the Pharmacy server");
            
            out.println("open");

            String serverRes = in.readLine();
            while (serverRes != null && !serverRes.equals("close")) {    

                // display
                System.out.println("\tNow Serving:\t" + serverRes);  // get message from server

                out.println("next");
                serverRes = in.readLine();
            }

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
 
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java aa.proj.PharmacyClient <hostname> <port number>");
            System.exit(1);
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        PharmacyClient client = new PharmacyClient(hostname, port);
        client.execute();
    }
}