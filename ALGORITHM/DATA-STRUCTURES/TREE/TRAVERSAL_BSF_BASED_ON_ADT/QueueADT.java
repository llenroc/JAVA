public class QueueADT<T> {
	private LinkedListCustom<T> list;

	public QueueADT() {

		list = new LinkedListCustom<>();
	}

	public void offer(Node<T> newNode) {
		list.insertFirst(newNode);

	}

	public Node<T> poll() {
		return list.removeLast();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
