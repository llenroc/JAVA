/*
 * Implementation of Cirqular Queue (Ring Buffer)
 * It's a classic implementation of Queue from [array]. It is used wrap around approach to reset [front] and [rear]
 * counters when it reaches out max 
 
 Queue -[FIFO]
 * */
class Queue {
    int maxSize;
    int numberOfElements;
    int front;
    int rear;
    int[] arr;

    Queue(int sizeOfQueue) {
        maxSize = sizeOfQueue;
        numberOfElements = 0;
        rear = -1;
        front = 0;
        arr = new int[maxSize];
    }

    // insert elements at the rear of queue
    public void enqueueElement(int value) {
        if (!isFull()) {

            arr[++rear] = value;
            numberOfElements++;
            if(rear== maxSize-1)
            {
                rear=-1;
            }
        } else {
            System.out.println("Queue is full!");
        }
    }

    // return elements from the front of queue
    public int dequeueElement() {
        int out = arr[front++];
        if(front== maxSize)
        {
            front=0;
        }

        numberOfElements--;
        return out;
    }

    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    public boolean isFull() {
        return (numberOfElements == maxSize );
    }
}

public class QueueMain1 {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueueElement(10);
        queue.enqueueElement(20);
        queue.enqueueElement(30);
        queue.enqueueElement(40);
        queue.dequeueElement();
        queue.dequeueElement();
        queue.dequeueElement();
        queue.enqueueElement(50);
        queue.enqueueElement(60);
        queue.enqueueElement(70);
        queue.enqueueElement(80);
     
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeueElement());
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
