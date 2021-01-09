/*
2021-Jan-09. Oleksii Saiun.
LeetCode_#1099. Two Sum Less Than K
https://leetcode.com/problems/two-sum-less-than-k/
*/

class Solution {
    private int maxTargetValue=Integer.MIN_VALUE;
    public int twoSumLessThanK(int[] nums, int k) {
        populateHeap(nums, k);
        
        if( maxTargetValue != Integer.MIN_VALUE )
        {
            return maxTargetValue;
        }
        else
        {
         return -1;            
        }
    }
    
    public void populateHeap(int[] nums, int k)
    {
        int leftPointer=0;
        int rightPointer=nums.length-1;
        Arrays.sort(nums);
        
        while(leftPointer<rightPointer)
        {
            int currSum=nums[leftPointer]+nums[rightPointer];
            if(currSum<k)
            {
        //       maxHeap.offer(currSum); 
               maxTargetValue=Math.max(maxTargetValue,currSum);
               leftPointer++;
            }
            else 
            {
                rightPointer--;
            }
        }
        
    }
}
