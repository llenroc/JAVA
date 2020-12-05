/*
2020-Dec-05. Oleksii Saiun.
LeetCode_#1167. Minimum Cost to Connect Sticks
https://leetcode.com/problems/minimum-cost-to-connect-sticks/

Solution:

 [2,3,1,4,5]
 if put it in sorted order we will get a min cost
 
  [1,2,3,4,5] ->[1+2=3,3,4,5] ->   [3,3,4,5]
  [3,3,4,5] -> [3+3=6,4,5] -> [4,5,6]
  [4,5,6] -> [4+5=9,6] -> [6,9] 
  [6,9] - > [15]
  
  total = 3 + 6 + 9 + 15 = 33
*/


class Solution {
	private PriorityQueue<Integer> heap = new PriorityQueue<>();
	public int connectSticks(int[] arr) {
		populateHeap(arr);
		int total = 0;

		while (heap.size() > 1) {
			int val1 = heap.poll();
			int val2 = heap.poll();
			total = total + val1 + val2;
			heap.offer(val1 + val2);

		}
		return total;
	}
    
    private void populateHeap(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			heap.offer(arr[j]);
		}
	}
}
