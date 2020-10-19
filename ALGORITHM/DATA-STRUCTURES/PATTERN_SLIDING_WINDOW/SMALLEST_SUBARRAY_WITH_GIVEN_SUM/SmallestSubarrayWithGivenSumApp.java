/*
 * 2020-Oct-19. Oleksii Saiun. Smallest Subarray with a given sum 
 * Sliding window pattern
 * 
 * arr={ 2, 1, 5, 2, 3, 2 };
 * sum=7;
 * result: 2;
 * 
 * Space complexity: O(N+N)=O(N)
 * Time complexity: O(1)
 * */
class Calc {
	public int findMinSubArray(int[] arr, int s) {
		int startWindow = 0;
		int endWindow = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		boolean flagSumExists=false;

		for (endWindow = 0; endWindow < arr.length; endWindow++) {
			sum = sum + arr[endWindow];

			while (sum >= s) {
				int lengthOfSubarray = endWindow - startWindow + 1;
				minLength = Math.min(minLength, lengthOfSubarray);
				System.out.println("startWindow:" + startWindow + "; endWindow:" + endWindow + "; sum:" + sum
						+ "; minLength: " + minLength);
				sum = sum - arr[startWindow++];
				
				flagSumExists=true;//the tasks require if you can find sum [s] than rturn [0]. This flag is just a marker that there is a sum
			}
		}

		if(flagSumExists)
		{
			return minLength;
		}
		else
		{
			return 0;
		}
		
	}
}
