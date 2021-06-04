/*
2021-Mar-08. Oleksii Saiun.
LeetCode_#53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==1)
        {
            return nums[0];
        }
        

        int currentSum=nums[0];
        int maxOfMax=nums[0];
        
        for(int j=1; j<nums.length; j++)
        {
              currentSum=currentSum+nums[j];
//if a prev sum less than current element in array then move pointer to this element, without further accumulating
            if(currentSum<nums[j])
            { 
                currentSum=nums[j];  
            }

                maxOfMax=Math.max(maxOfMax,currentSum);            
         
        }
        
        return maxOfMax;
    }
}
