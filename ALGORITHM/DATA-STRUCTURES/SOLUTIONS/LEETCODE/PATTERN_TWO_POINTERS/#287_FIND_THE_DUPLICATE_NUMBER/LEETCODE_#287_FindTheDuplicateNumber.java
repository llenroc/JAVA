/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/
*/

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int j=1; j<nums.length; j++)
        {
            if(nums[j] == nums[j-1])
            {
                return nums[j];
            }
        }
        
        return Integer.MAX_VALUE;
    }
}
