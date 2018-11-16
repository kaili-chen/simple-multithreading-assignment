package aa.proj;

import java.util.*;

public class PatientQueue {
    // attributes
    private Queue<Integer> q = new LinkedList<Integer>();

    // constructor
    /**
     * Creates a PatientQueue instance with the specified number of patients in the queue
     * @param numHumans int Number of patients to be in the queue
     */
    public PatientQueue(int numHumans) {
        Random rand = new Random();
        Set<Integer> temp = new LinkedHashSet<Integer>();
        for (int i = 0; temp.size() < numHumans; i++) {
            temp.add(rand.nextInt(9000) + 1000);    // always generate a 4 digit number
        }
        q.addAll(temp);
    }

    // methods
    /**
     * This method returns the queue number of the next patient to be served but does not remove the patient from the queue
     * @return int queue number of the next patient
     */
    public synchronized int whosNext() {
        return q.peek();
    }

    /**
     * This method returns the queue number of the next patient to be served and removes the patient from the queue.
     * @return int queue number of the next patient to serve
     */
    public synchronized int serveNext() {
        return q.remove();
    }

    //getters
    /**
     * This method is used to obtain the current Queue object.
     * @return Queue<Integer> the current queue object
     */
    public Queue<Integer> getQueue() {
        return q;
    }

    /**
     * This method returns the number of patients in the queue
     * @return int number of patients in the queue
     */
    public int getQueueSize() {
        return q.size();
    }
}