/*
2021-Jan-19. Oleksii Saiun.
LeetCode_136. Single Number
https://leetcode.com/problems/single-number/
*/


class Solution {
    private HashSet<Integer> set = new HashSet<>();
    public int singleNumber(int[] nums) {
        for(int j=0; j<nums.length; j++)
        {
            boolean flagOfInsert = set.add(nums[j]);
            if ( flagOfInsert==false )
            {
                set.remove(nums[j]);
            }
        }
        Iterator iter = set.iterator();
        int val = (Integer) iter.next();
        return val;
    }
}
