import java.util.Map.*;

/*
2021-Jan-19. Oleksii Saiun.
LeetCode_169. Majority Element
https://leetcode.com/problems/majority-element/
*/

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public int majorityElement(int[] nums) {     
        double flagOfFrequency =(double) nums.length/2;
        populateMap(nums);
        
        for(Entry<Integer, Integer> j : map.entrySet())
        {
            if (j.getValue() > flagOfFrequency )
            {
                return j.getKey();
            }
        }
        
        return -1;
    }
    
    private void populateMap(int[] nums)
    {
        for(int j=0; j<nums.length; j++)
        {
            int key = nums[j];
            int currFreq = map.getOrDefault(key,0);
            map.put(key, currFreq+1);
        }
    }
}
