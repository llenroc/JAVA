import java.util.LinkedList;
import java.util.Deque;

public class HashTable {

	private int index;
	private int arraySize;
	Deque<Node>[] arr;

	public HashTable(int arraySize) {
		this.arraySize = arraySize;
		arr = new LinkedList[arraySize];

		for (int index = 0; index < arraySize; index++) {
			arr[index] = new LinkedList<>();
		}
	}

	public void insert(int index, Node newNode) {
		arr[index].addFirst(newNode);
	}

	public void displayDequeForward(Deque<Node> deque) {
		while (!deque.isEmpty()) {
			deque.pollFirst().displayValue();
		}
	}

	public void displayDequeBackward(Deque<Node> deque) {
		while (!deque.isEmpty()) {
			deque.pollLast().displayValue();
		}
	}

	public void displaySpiralAll() {
		for (int index = 0; index < arraySize; index++) {
			if (arr[index].size() != 0) {
				if (index % 2 == 0) {
					System.out.print("[" + index + "] ");
					displayDequeForward(arr[index]);
				} else {
					System.out.print("[" + index + "] ");
					displayDequeBackward(arr[index]);
				}
			}
			System.out.println();
		}
	}

}
