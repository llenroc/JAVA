import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestMaxHeapApp {
	private MaxHeap heap = new MaxHeap(12);
	@Test
	public void testHeapSort1()
	{		
		// sorting
		
		heap.insert(12);
		heap.insert(1);
		heap.insert(11);
		heap.insert(0);
		heap.insert(13);
		heap.insert(5);
		heap.insert(99);
		heap.insert(6);
		heap.insert(7);
		heap.insert(0);
		heap.insert(1);
		heap.insert(1);
		
		heap.heapSort();
		int[] arrSorted = heap.getHeap();
		int[] arrExpected = new int[] { 0, 0, 1, 1, 1, 5, 6, 7, 11, 12, 13, 99 };
		Assert.assertArrayEquals(arrSorted, arrExpected);
	}
}
