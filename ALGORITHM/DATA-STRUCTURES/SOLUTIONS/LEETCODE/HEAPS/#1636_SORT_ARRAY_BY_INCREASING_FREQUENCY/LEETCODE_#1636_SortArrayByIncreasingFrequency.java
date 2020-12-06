import java.util.Map.*;

/*
2020-Dec-05. Oleksii Saiun.
LeetCode_#1636. Sort Array by Increasing Frequency
https://leetcode.com/problems/sort-array-by-increasing-frequency/
*/

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private PriorityQueue<Entry<Integer, Integer>> heap = new PriorityQueue<>(
             (o1,o2) -> o1.getValue() == o2.getValue() 
                                     ? o2.getKey() - o1.getKey() 
                                     : o1.getValue() - o2.getValue()                
    );

    public int[] frequencySort(int[] nums) {
      populateMap(nums);
      int index=0;
      int[] out = new int[nums.length];
      for (Entry<Integer, Integer> j : map.entrySet())
      {
          heap.offer(j);
      }

        while(!heap.isEmpty())
        {
           Entry<Integer, Integer> entry = heap.poll();
           int key = entry.getKey();
           int freq = entry.getValue();

           while(freq-- >0)
           {
            out[index++] = key;
           }
        }
        
        return out;
    }
    
    private void populateMap(int[] nums)
    {
        for(int j=0; j<nums.length; j++)
        {
            int key=nums[j];
            int freqOfKey=map.getOrDefault(key,0);
            map.put(key,freqOfKey+1);
        }
    }
    
}
