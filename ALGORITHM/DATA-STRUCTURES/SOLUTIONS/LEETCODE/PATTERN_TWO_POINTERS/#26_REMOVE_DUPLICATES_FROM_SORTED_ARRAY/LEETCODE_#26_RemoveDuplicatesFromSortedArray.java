/*
2021-Jan-06. Oleksii Saiun.
LeetCode_#1. Two Sum
https://leetcode.com/problems/two-sum/

Time complexity: O(n)
Space complexity: O(n)
*/


class Solution {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        for(int j=0; j<nums.length; j++)
        {
            int currKey = nums[j];
            int searchKey = target - currKey;
            if (map.containsKey(searchKey))
            {
                int searchVal=map.get(searchKey);
                return new int[]{j,searchVal};
            }
            else
            {
                map.put(currKey,j);
            }
        }
        return null;
    }
    
/*    public void populateMap(int[] nums)
    {
        for(int j=0; j<nums.length; j++)
        {
            int key = nums[j];
            int freq = map.getOrDefault(key,0)+1;
            map.put(key, freq);
        }
    }*/
}
