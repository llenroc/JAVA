public class QueueADT<T> {
	private DoubleEnded_DoublyLinkedList<T> list;

	public QueueADT() {
		list = new DoubleEnded_DoublyLinkedList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(T value) {
		list.insertFirst(value);
	}

	public Node<T> pop() {
		return list.removeFirst();
	}

}
