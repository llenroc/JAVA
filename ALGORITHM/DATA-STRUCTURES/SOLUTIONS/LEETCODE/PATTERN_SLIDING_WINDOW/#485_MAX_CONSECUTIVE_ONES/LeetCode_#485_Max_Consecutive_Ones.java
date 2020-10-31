/*
2020-Oct-30. Oleksii Saiun.
LeetCode_#485. Max Consecutive Ones
https://leetcode.com/problems/max-consecutive-ones/
*/   

class Solution {
    private Map<Integer, Integer> hashmap = new HashMap<>();
    public int findMaxConsecutiveOnes(int[] nums) {
        int startWindow=0;
        int endWindow=0;
        int maxlengthOfSubString = 0;
        int elementRight=0;
        
        for(endWindow=0; endWindow<nums.length; endWindow++)
        {
            
            elementRight=nums[endWindow];
            int freqOfelementRight=hashmap.getOrDefault(elementRight,0);
            hashmap.put(elementRight, freqOfelementRight+1);

            // if there is any [0] then we remove it in a loop
            while(hashmap.getOrDefault(0,0)!=0)
            {

              int elementLeft=nums[startWindow];  
              int freqOfLeftElement = hashmap.getOrDefault(elementLeft,0);
              hashmap.put(elementLeft, freqOfLeftElement-1);
              freqOfLeftElement = hashmap.getOrDefault(elementLeft,0);
                //if a frequency of left element is 0 then remove it from a hashtable
             if (freqOfLeftElement==0)
             {
                hashmap.remove(elementLeft);
             }       
             startWindow++;
            }

         // if right element is [1] then we make a cacl. We need this check if there are only [0] in an array -\\ then amount of [1] will be 0
         if (elementRight==1)
         {
            int currentlengthOfSubString = hashmap.getOrDefault(elementRight,0);
            maxlengthOfSubString = Math.max(currentlengthOfSubString,maxlengthOfSubString);

         }

        }


            return maxlengthOfSubString; 
        

    }
    
    
}
