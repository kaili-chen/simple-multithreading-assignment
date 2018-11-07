package proj.client;
 
import java.io.*;
import java.net.*;
 
/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private CounterClient client;
 
    public WriteThread(Socket socket, CounterClient client) {
        this.socket = socket;
        this.client = client;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException e) {
            System.out.println("Error getting output stream: " + e.getMessage());
            e.printStackTrace();
        }
    }
 
    public void run() {
 
        // Console console = System.console();
 
        // String counterName = console.readLine("\nEnter your name: ");
        // client.setCounterName(counterName);
        // writer.println(counterName);
 
        // String text;
 
        // do {
        //     // text = console.readLine("[" + counterName + "]: ");
        //     // writer.println(text);
 
        // } while (!text.equals("bye"));
 
        // try {
        //     socket.close();
        // } catch (IOException e) {
 
        //     System.out.println("Error writing to server: " + e.getMessage());
        // }
    }
}