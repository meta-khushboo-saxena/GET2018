package PriorityQueue;

//Interface for Queue
public interface Queue {

    /**
     * Function to add element in queue
     * 
     * @param element
     */
    boolean addElement(int element, int priority);

    /**
     * Function to remove element
     * 
     * @param element
     */
    boolean deleteHighestPriorityElement();

    int getHighestPriorityElement();

    boolean isEmpty();

    boolean isFull();
    
    void show();
    
    QueueItem[] getQueue();

}
