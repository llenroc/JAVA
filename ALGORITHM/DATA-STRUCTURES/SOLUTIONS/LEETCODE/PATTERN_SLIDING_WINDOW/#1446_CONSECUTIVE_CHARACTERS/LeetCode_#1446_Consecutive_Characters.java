/*
2020-Oct-30. Oleksii Saiun.
LeetCode_#1446. Consecutive Characters
https://leetcode.com/problems/consecutive-characters/
*/   

class Solution {
    
    private Map<Character, Integer> hashmap = new HashMap<>();
    
    public int maxPower(String s) {
        int startWindow=0;
        int endWindow=0;
        int maxlengthOfSubString = Integer.MIN_VALUE;
        
        for(endWindow=0; endWindow<s.length(); endWindow++)
        {
            char charRight=s.charAt(endWindow);
            int freqOfcharRight=hashmap.getOrDefault(charRight,0);
            hashmap.put(charRight, freqOfcharRight+1);

            while(hashmap.size()>1)
            {
              System.out.println("startWindow:"+startWindow+"; endWindow:"+endWindow+"; hashmap.size:"+hashmap.size());
              char charLeft=s.charAt(startWindow);  
              int freqOfLeftChar = hashmap.getOrDefault(charLeft,0);
              hashmap.put(charLeft, freqOfLeftChar-1);
              freqOfLeftChar = hashmap.getOrDefault(charLeft,0);
                //if a frequency of left charcter is 0 then remove it from a hashtable
             if (freqOfLeftChar==0)
             {
                hashmap.remove(charLeft);
             }       
             startWindow++;
            }
            
            // there is only one row in a hashmap now after cycle "while" above
            int currentlengthOfSubString = freqOfcharRight=hashmap.getOrDefault(charRight,0);
            maxlengthOfSubString = Math.max(currentlengthOfSubString,maxlengthOfSubString);
        }
        
        
        return maxlengthOfSubString;
    }
    
    
}
