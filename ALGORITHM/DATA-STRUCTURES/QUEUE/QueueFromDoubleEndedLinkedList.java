
/* 2020-May-13. Oleksii Saiun
 * Implementation of Queue from [Double Ended LinkedList]
 */

class Node {
    String value;
    Node next;

    Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void display() {
        System.out.println("{" + value + "}");
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void insertLast(String value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public String delete() {
        Node nodeToDelete = head;
        String outValue;
        if (nodeToDelete.next == null) {
            head = null;
            tail = null;
            outValue = nodeToDelete.getValue();
        } else {
            head = nodeToDelete.next;
            tail = head;
            outValue = nodeToDelete.getValue();
        }
        return outValue;
    }
}

class Queue {
    LinkedList linkedList;

    Queue() {
        linkedList = new LinkedList();
    }

    public void enqueu(String value) {
        linkedList.insertLast(value);
    }

    public String dequeu() {
        return linkedList.delete();
    }

    public String peek() {
        return linkedList.head.getValue();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}

public class QueueFromDoubleEndedLinkedList {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueu("10");
        queue.enqueu("20");
        queue.enqueu("30");
        queue.enqueu("40");
        queue.enqueu("50");
        queue.enqueu("60");
        queue.enqueu("70");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeu());
        }

    }

}
