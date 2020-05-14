/* 2020-May-13. Oleksii Saiun
 * Implementation of Queue from [Single LinkedList]
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

    public void insert(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public String delete() {
        Node nodeToDelete = head;
        String outValue = head.getValue();
        if (head.next == null) {
            head = null;
        } else {
            head = nodeToDelete.next;
        }
        return outValue;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}

class Queue {
    LinkedList linkedList;

    Queue() {
        linkedList = new LinkedList();
    }

    public void enqueu(String value) {
        linkedList.insert(value);
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

public class QueueFromSingleLinkedList {
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
