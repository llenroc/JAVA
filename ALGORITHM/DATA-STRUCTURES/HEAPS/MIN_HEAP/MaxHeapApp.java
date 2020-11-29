/*2020-November-28. Oleksii Saiun. Max Heap
 * */

class MaxHeap {
	private int[] heap;
	private int size;
	private int currentIndexOfHeap;

	public MaxHeap(int size) {
		this.size = size;
		heap = new int[size];
		fillOutInitially();
	}

	public void fillOutInitially() {
		for (int j = 0; j < heap.length; j++) {
			heap[j] = -1;
		}
	}

	public void displayHeap() {
		for (int j : heap) {
			System.out.print(j + " ");
		}
		System.out.println();
	}

	public int[] getHeap() {
		return heap;
	}

	public void insert(int value) {
		if (heap[0] == -1) {
			heap[currentIndexOfHeap] = value;
			return;
		} else {
			currentIndexOfHeap = currentIndexOfHeap + 1;
		}

		if (currentIndexOfHeap < size) {
			heap[currentIndexOfHeap] = value;
			heapifyUp(currentIndexOfHeap);
		} else {
			System.out.println("Heap is full");
		}
	}

	public void remove() {
		int positionOfRoot = 0;
		if (currentIndexOfHeap > 0) {
			swap(positionOfRoot, currentIndexOfHeap);
			currentIndexOfHeap = currentIndexOfHeap - 1;
			heapifyDown(positionOfRoot);
		}
	}

	public void heapSort() {
		while (currentIndexOfHeap > 0) {
			remove();
		}
	}

	private void heapifyUp(int index) {
		int parentIndex = getParentIndex(index);

		while (heap[index] > heap[parentIndex]) {
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}
	}

	private void heapifyDown(int index) {
		while (!isLeaf(index) && heap[index] < heap[getMaxIndexOfChilds(index)]) {
			int tmp_MinIndexOfChilds = getMaxIndexOfChilds(index);
			swap(index, tmp_MinIndexOfChilds);
			index = tmp_MinIndexOfChilds;
		}
	}

	private int getMaxIndexOfChilds(int i) {
		Integer childLeftIndex = null;
		Integer childRightIndex = null;
		Integer outIndex = null;
		if (getLeftChildIndex(i) <= currentIndexOfHeap) {
			childLeftIndex = getLeftChildIndex(i);
		}

		if (getRightChildIndex(i) <= currentIndexOfHeap) {
			childRightIndex = getRightChildIndex(i);
		}

		if (childLeftIndex == null && childRightIndex != null) {
			outIndex = childRightIndex;
		} else if (childLeftIndex != null && childRightIndex == null) {
			outIndex = childLeftIndex;
		} else {
			if (heap[childLeftIndex] > heap[childRightIndex]) {
				outIndex = childLeftIndex;
			} else {
				outIndex = childRightIndex;
			}
		}
		return outIndex;
	}

	private void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	private boolean isLeaf(int i) {

		return getLeftChildIndex(i) > currentIndexOfHeap && getRightChildIndex(i) > currentIndexOfHeap;
	}

	private int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	private int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	private int getRightChildIndex(int i) {
		return 2 * i + 2;
	}
}

public class MaxHeapApp {
	public static void main(String[] args) {
		MaxHeap app = new MaxHeap(12);
		app.insert(12);
		app.insert(1);
		app.insert(11);
		app.insert(0);
		app.insert(13);
		app.insert(5);
		app.insert(99);
		app.insert(6);
		app.insert(7);
		app.insert(0);
		app.insert(1);
		app.insert(1);

		System.out.println("Max heap:");
		app.displayHeap();
		app.heapSort();
	//	System.out.println("Removing data - heap sorted in ascending:");
		app.displayHeap();

	}

}
