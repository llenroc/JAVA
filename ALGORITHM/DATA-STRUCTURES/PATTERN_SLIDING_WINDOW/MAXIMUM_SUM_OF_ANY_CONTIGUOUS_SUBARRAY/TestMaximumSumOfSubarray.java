import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMaximumSumOfSubarray {
	Calc calc = new Calc();

	@Test
	public void testFindMaxSumSubArray1() {
		int arrInput[] = new int[] { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		int out=9;
		assertEquals(calc.findMaxSumSubArray(arrInput, k), out);
	}
	
	@Test
	public void testFindMaxSumSubArray2() {
		int arrInput[] = new int[] {2, 3, 4, 1, 5};
		int k = 2;
		int out=7;
		assertEquals(calc.findMaxSumSubArray(arrInput, k), out);
	}
}
