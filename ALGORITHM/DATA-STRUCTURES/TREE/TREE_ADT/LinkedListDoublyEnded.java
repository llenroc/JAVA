public class LinkedListDoublyEnded<T> {
	Node<T> head;
	Node<T> tail;

	public void insertFirst(Node<T> newNode) {
	// 	Node<T> newNode = new Node<>(value);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertLast(Node<T> newNode) {
	//	Node<T> newNode = new Node<>(value);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void displayForward() {
		Node<T> tmpNode = head;
		while (tmpNode != null) {
			tmpNode.displayValue();
			tmpNode = tmpNode.next;
		}
		System.out.println();
	}

	public void displayBackward() {
		Node<T> tmpNode = tail;
		while (tmpNode != null) {
			tmpNode.displayValue();
			tmpNode = tmpNode.prev;
		}
		System.out.println();
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
		Node<T> nodeToDelete = null;
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

	public boolean isEmpty() {
		return head == null;
	}
}
