import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSmallestSubarrayWithGivenSumApp {
	private Calc calc = new Calc();

	@Test
	public void testFindMinSubArray1() {
		int[] arr = new int[] { 2, 1, 5, 2, 3, 2 };
		int s = 7;
		int out = 2;		
		assertEquals(calc.findMinSubArray(arr, s),out);
	}
	
	@Test
	public void testFindMinSubArray2() {
		int[] arr = new int[] { 2, 1, 5, 2, 8 };
		int s = 7;
		int out = 1;		
		assertEquals(calc.findMinSubArray(arr, s),out);
	}
	
	@Test
	public void testFindMinSubArray3() {
		int[] arr = new int[] { 3, 4, 1, 1, 6 };
		int s = 8;
		int out = 3;		
		assertEquals(calc.findMinSubArray(arr, s),out);
	}
	
	@Test
	public void testFindMinSubArrayZero() {
		int[] arr = new int[] { 3, 4, 1, 1, 6 };
		int s = 180;
		int out = 0;		
		assertEquals(calc.findMinSubArray(arr, s),out);
	}
}
