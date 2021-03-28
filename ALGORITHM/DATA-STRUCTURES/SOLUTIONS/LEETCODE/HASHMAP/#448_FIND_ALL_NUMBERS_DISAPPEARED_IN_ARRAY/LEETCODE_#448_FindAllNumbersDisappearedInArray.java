/*
2021-Mar-27. Oleksii Saiun.
LeetCode_#448. Find All Numbers Disappeared in an Array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
*/


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> outMissedNumbers = new ArrayList<>();
        int lenOfArr = nums.length;
        
        for(int j=0; j<lenOfArr; j++)
        {
            set.add(nums[j]);
        }
        
        for(int j=1; j<=lenOfArr; j++)
        {
            if (!set.contains(j))
            {
                outMissedNumbers.add(j);
            }
        }
        


        return outMissedNumbers;
    }
}
