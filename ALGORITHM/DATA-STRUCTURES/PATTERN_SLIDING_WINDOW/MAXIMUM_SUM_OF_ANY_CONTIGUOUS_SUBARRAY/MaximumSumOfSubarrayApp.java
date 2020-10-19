/*
 * 2020-Oct-18. Oleksii Saiun. Maximum sum of any contiguous subarray of size ‘k’
 * Sliding window pattern
 * 
 * arr = {2, 1, 5, 1, 3, 2}
 * k = 3;
 * max sum of subbaray of = 9
 * */

class Calc {
	public int findMaxSumSubArray(int[] arr, int k) {
		int startWindow = 0;
		int endWindow = 0;
		int sum = 0;
		int maxVax = Integer.MIN_VALUE;

		for (endWindow = 0; endWindow < arr.length; endWindow++) {

			sum = sum + arr[endWindow];
			if (endWindow == k - 1) {
				maxVax = Math.max(maxVax, sum);
				System.out.println("endWindow:" + endWindow + "; sum:" + sum);
			} else if (endWindow > k - 1) {
				sum = sum - arr[startWindow++];
				System.out.println("endWindow:" + endWindow + "; sum:" + sum);
				maxVax = Math.max(maxVax, sum);
			}

		}
		return maxVax;
	}
}

public class MaximumSumOfSubarrayApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = new int[] { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		System.out.println(calc.findMaxSumSubArray(arr, k));
		/*
		 * * arr = {2, 1, 5, 1, 3, 2}; 
		 *   k = 3; 
		 *   max sum of subbaray of = 9;
		 */
	}

}
