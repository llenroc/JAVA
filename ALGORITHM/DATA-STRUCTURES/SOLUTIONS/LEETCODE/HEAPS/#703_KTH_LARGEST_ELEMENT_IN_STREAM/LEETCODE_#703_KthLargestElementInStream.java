/*
2020-Dec-07. Oleksii Saiun.
LeetCode_#703. Kth Largest Element in a Stream
https://leetcode.com/problems/minimum-size-subarray-sum/https://leetcode.com/problems/kth-largest-element-in-a-stream/
*/

class KthLargest {
    private int k;
    private int[] nums;
    //min heap
    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
     
    public KthLargest(int k, int[] nums) {
         this.k=k;
         this.nums=nums;
         populateHeapKlargestElement(k,nums);
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size()>k)
        {
            heap.poll();
        }
        return heap.peek(); // we peek here - not remove
    }
    
    private void populateHeapKlargestElement(int k, int[] nums)
    {
        for(int j=0; j<nums.length; j++)
        {
            heap.offer(nums[j]);
            if (heap.size()>k)
        {
            heap.poll();
        }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
