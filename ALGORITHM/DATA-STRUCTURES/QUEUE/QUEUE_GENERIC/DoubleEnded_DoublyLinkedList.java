public class DoubleEnded_DoublyLinkedList<T> {
	Node<T> head;
    Node<T>  tail;

    public void insertFirst(T value) {
        Node<T> newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertLast(T value) {
        Node<T> node = new Node(value);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public Node<T> removeFirst() {
        Node<T> nodeToDelete = null;
        if (!isEmpty()) {
            nodeToDelete = head;

            if (nodeToDelete.next == null) {
                head = null;
                tail = null;

            } else {
                Node<T> nodeNext = nodeToDelete.next;
                head = nodeNext;
                nodeNext.prev = head;
                return nodeToDelete;
            }
        }
        return nodeToDelete;
    }
    
    public Node<T> removeLast() {
        Node<T> nodeToDelete=null;
        if (!isEmpty()) {
            nodeToDelete = tail;

            if (nodeToDelete.prev == null) {
                head = null;
                tail = null;
   
            } else {               
                Node<T> nodePrev = nodeToDelete.prev;
                tail = nodePrev;
                return nodeToDelete;
            }
        }
        return nodeToDelete;
    }
    public void displayForward() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            currentNode.displayValue();
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        Node<T> currentNode = tail;
        while (currentNode != null) {
            currentNode.displayValue();
            currentNode = currentNode.prev;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
