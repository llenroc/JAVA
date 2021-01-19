/*
2021-Jan-19. Oleksii Saiun.
LeetCode_137. Single Number II
https://leetcode.com/problems/single-number-ii/
*/
import java.util.Map.*;
class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (o1,o2) -> map.get(o1) -  map.get(o2)
    );
    
    public int singleNumber(int[] nums) {
        populateHashMap(nums);
        
        for(Entry<Integer, Integer>  j : map.entrySet())
        {
            if( j.getValue() == 1)
            {
                return j.getKey();
            }
        }
        
        return -1;
    }
    
    private void populateHashMap(int[] nums)
    {
        for(int j=0; j<nums.length; j++)
        {
            int key = nums[j];
            int currFreq = map.getOrDefault(key, 0);
            map.put(key, currFreq+1);
        }
    }
}
