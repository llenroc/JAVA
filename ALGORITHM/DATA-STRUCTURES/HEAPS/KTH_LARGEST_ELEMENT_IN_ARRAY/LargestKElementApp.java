import java.util.PriorityQueue;

/*2020-Dec-01. Oleksii Saiun. Find k-th largest element in array
 
Solution-2nd approach:
approach is to choose(!) minHeap data structure to find k-st largest element
1) We are processing all array and add elements in a heap. 
2) When a size of array is (k+1) we remove a root element - the lowest element and the heap has k largest elements
3) Step #2 is checked for each element of array
 * */

class Calc {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int j = 0; j < nums.length; j++) {
			minHeap.offer(nums[j]);
			if (minHeap.size() == k + 1) {
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}

}

public class LargestKElementApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(calc.findKthLargest(nums, k));
	}

}
