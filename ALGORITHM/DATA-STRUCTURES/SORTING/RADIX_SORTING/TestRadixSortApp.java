import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestRadixSortApp {
	private MySort mysort = new MySort();

	@Test
	public void testCountingSort1() {
		int[] arrIn = new int[] { 4, 2, 9, 4, 7, 6 };
		// sorting
		mysort.radixSort(arrIn);
		int[] arrExpected = new int[] { 2, 4, 4, 6, 7, 9 };
		Assert.assertArrayEquals(arrIn, arrExpected);
	}

	@Test
	public void testCountingSort2() {
		int[] arrIn = new int[] { 0, 0, 0 };
		// sorting
		mysort.radixSort(arrIn);
		int[] arrExpected = new int[] { 0, 0, 0 };
		Assert.assertArrayEquals(arrIn, arrExpected);
	}

	@Test
	public void testCountingSort3() {
		int[] arrIn = new int[] { 90, 3, 0, 0, 0, 0, 0, 6, 12, 0, 12, 56, 1, 4 };
		// sorting
		mysort.radixSort(arrIn);
		int[] arrExpected = new int[] { 0, 0, 0, 0, 0, 0, 1, 3, 4, 6, 12, 12, 56, 90 };
		Assert.assertArrayEquals(arrIn, arrExpected);
	}

}
