/*
2021-Jan-31. Oleksii Saiun.
LeetCode_#15. 3Sum
https://leetcode.com/problems/3sum/

Option1
Solving using haspmap approach
*/

import java.util.Map.*;

class Solution {
    private Set<List<Integer>> setOfthreeSum = new HashSet<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> outListOfthreeSum = new ArrayList<>();
       for(int j=0; j<nums.length; j++)
        {
          int x = nums[j];
          findTwoSum(nums,x,j);
        }
        
        for(List<Integer> j : setOfthreeSum )
        {
           outListOfthreeSum.add(j);
        }
        return outListOfthreeSum;
    }
    
/*
Example,
        x==-1
        x+y+z==0
        y = -x-z <=> y = 1-z
*/
    public void findTwoSum(int[] nums, int x, int indexofX)
    {  //use individual hashmap for each iteration
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int j=0; j<nums.length; j++)
       {
           // we skip that index where we already chose [x]. We need to find individual [y] and [z]
           if (j!=indexofX)
        {//start
           int z = nums[j];
           int y = (-1)*x + (-1)*z;
           if (map.containsKey(y) )
           {
               List<Integer> out3Sum = new ArrayList<>();
               out3Sum.add(x);
               out3Sum.add(y);
               out3Sum.add(z);
               //sort collections in order to put it into Set and avoid duplicates
               Collections.sort(out3Sum);
               setOfthreeSum.add(out3Sum);
           }
           
           if ( ! (map.containsKey(z)) )
           {
               map.put(z,j);
           }               
       }//end
    }
    }
    
}
