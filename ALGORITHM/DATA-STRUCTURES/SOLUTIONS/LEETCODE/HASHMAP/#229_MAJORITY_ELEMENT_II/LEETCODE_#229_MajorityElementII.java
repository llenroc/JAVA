import java.util.Map.*;

/*
2021-Jan-19. Oleksii Saiun.
LeetCode_229. Majority Element II
https://leetcode.com/problems/majority-element-ii/
*/

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public List<Integer> majorityElement(int[] nums) {
       populateMap(nums);    
       double flagOfFrequency =(double) nums.length/3;  
       List<Integer> outList = new ArrayList<>();
        
      for(Entry<Integer, Integer> j : map.entrySet())
      {
          if (j.getValue() > flagOfFrequency)
          {
              outList.add(j.getKey());
          }
      }
        return outList;
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
