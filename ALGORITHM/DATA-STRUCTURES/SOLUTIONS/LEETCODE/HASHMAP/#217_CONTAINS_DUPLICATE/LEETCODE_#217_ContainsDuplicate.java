/*
2021-Mar-27. Oleksii Saiun.
LeetCode_#217. Contains Duplicate
https://leetcode.com/problems/contains-duplicate/

*/


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int j=0; j<nums.length; j++)
        {
            boolean flag = set.add(nums[j]);
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }
}
