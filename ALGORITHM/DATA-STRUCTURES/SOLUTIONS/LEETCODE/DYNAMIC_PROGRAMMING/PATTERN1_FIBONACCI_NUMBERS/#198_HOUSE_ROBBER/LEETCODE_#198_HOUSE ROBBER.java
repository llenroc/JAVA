/*
2021-Mar-04. Oleksii Saiun.
LeetCode_#198. House Robber
https://leetcode.com/problems/house-robber/

Time Complexity O(n)
Space Complexity O(n)
Pattern: bottom-up (tabulation)
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
        {
            return nums[0];
        }
        
        if(nums.length==1)
        {
            return nums[0];
        }       
        
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }  
        
        int[] dp = new int[nums.length];
        
        /* it's the trickies part: 
           we will go by formula
           Max( dp[1], dp[0] + arr[2])
           
        */
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        
        for(int j=2; j<nums.length; j++)
        {
            dp[j] = Math.max(dp[j-1], dp[j-2] + nums[j]);
        }
        displayArray(dp);
        return dp[nums.length-1];
    }
    
    public void displayArray(int[] arr)
    {
        for(int j=0; j<arr.length; j++)
        {
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
