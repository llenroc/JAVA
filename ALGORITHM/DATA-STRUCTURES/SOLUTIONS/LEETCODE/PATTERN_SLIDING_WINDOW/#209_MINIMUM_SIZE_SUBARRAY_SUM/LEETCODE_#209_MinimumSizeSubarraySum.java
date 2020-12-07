/*
2020-Dec-07. Oleksii Saiun.
LeetCode_#209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/
*/


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        Integer minLength=Integer.MAX_VALUE;
        int sum=0;
        
        for(endIndex=0;endIndex<nums.length;endIndex++)
        {
            sum=sum+nums[endIndex];
                while(sum>=s)
                {
   
                  int currLenght= endIndex - startIndex +1;
                  minLength = Math.min(minLength,currLenght);                
                  sum=sum - nums[startIndex++];
                }
        }
        
        if(minLength!=Integer.MAX_VALUE)
        {
           return minLength;
        }
        else
        {
            return 0;
        }
        
    }
}
