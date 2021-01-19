/*
2021-Jan-19. Oleksii Saiun.
LeetCode_260. Single Number III
https://leetcode.com/problems/single-number-iii/
*/

import java.util.Map.*;

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public int[] singleNumber(int[] nums) {
        populateMap(nums);
        
        int[] out = new int[2];
        int counter=0;
        for(Entry<Integer,Integer> j : map.entrySet())
        {
            if(j.getValue()==1 && counter==0)
            {
                out[0]=j.getKey();
                counter++;
            }
            else if (j.getValue()==1 && counter==1)
            {
                out[1]=j.getKey();
                return out;
            }
        }
        
        return new int[]{-1,-1};
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
