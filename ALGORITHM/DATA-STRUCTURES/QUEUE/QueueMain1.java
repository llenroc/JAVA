/*
 * Implementation of Cirqular Queue (Ring Buffer)
 * It's a classic implementation. It is used wrap around approach to reset [front] and [rear]
 * counters when it reaches out max 
 
 Queue -[FIFO]
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

    public void enqueue(int value) {
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

    public int dequeue() {
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
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);

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
