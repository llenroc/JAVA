/*
 * Implementation of Cirqular Queue (Ring Buffer)
 * It's a classic implementation. It is used wrap around approach to reset [front] and [rear]
 * counters when it reaches out max 
 * */
class Queue {
    private int maxSize;
    private int[] arr;
    private int rear;
    private int front;
    private int nItems;

    public Queue(int sizeOfQueue) {
        maxSize = sizeOfQueue;
        arr = new int[maxSize];
        rear = -1;
        front = 0;
        nItems = 0;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void enque(int value) {
        if (!isFull()) {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            arr[++rear] = value;
            nItems++;
        } else {
            System.out.println("Queue is full!");
        }
    }

    public int deque() {
        int value = arr[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return value;
    }
    
     public int peek() {
        return arr[front];
    }
}

public class QueueMain1 {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.deque();
        queue.deque();
        queue.deque();
        queue.enque(50);
        queue.enque(60);
        queue.enque(70);
        queue.enque(80);

        while (!queue.isEmpty()) {
            System.out.println(queue.deque());
        }

        /**
         * Output:
         * 40
           50
           60
           70
           80
         * 
         */
    }

}
