/*
2020-Dec-03. Oleksii Saiun.
LeetCode_#215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/

O(N*Log(K)) - time complexity, where K- largest element, N - length of array
*/

class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public int findKthLargest(int[] nums, int k) {
        for(int j=0; j<nums.length; j++)
        {
            minHeap.offer(nums[j]);
            
            if(minHeap.size()>k)
            {
              minHeap.poll();  
            }
        }
        
        int kLargestElement = minHeap.poll();  
        return kLargestElement;
    }
}
