/*
2021-Mar-30. Oleksii Saiun.
LeetCode_#268. Missing Number. Approach3. HashSet
https://leetcode.com/problems/missing-number/

*/


class Solution {
    public int missingNumber(int[] nums) {
        HashSet set = new HashSet<>();
        for(int j=0; j<nums.length; j++)
        {
            set.add(nums[j]);
        }
        
        for(int j=0; j<=nums.length; j++)
        {
            if( !set.contains(j))
            {
                return j;
            }
        }
        
        return nums.length;
    }
}
