/*
2020-Nov-02. Oleksii Saiun.
LeetCode_#159. Longest Substring with At Most Two Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/submissions/
*/   

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> hashmap = new HashMap<>();
        int startWindow = 0;
        int endWindow = 0;
        int maxLengthOfSubstring=0;
        
        for(endWindow=0; endWindow<s.length(); endWindow++)
        {
            char rightSymbol=s.charAt(endWindow);
            int freqOfRightSymbol = hashmap.getOrDefault(rightSymbol,0);
            hashmap.put(rightSymbol,freqOfRightSymbol+1);
            
            while(hashmap.size()>2)
            {
              char leftSymbol=s.charAt(startWindow++);
              int freqOfLeftSymbol = hashmap.getOrDefault(leftSymbol,0);
              hashmap.put(leftSymbol,freqOfLeftSymbol-1);   
              
              int currFreqOfLeftSymbol = hashmap.get(leftSymbol);  
              if(currFreqOfLeftSymbol==0)
              {
                 hashmap.remove(leftSymbol); 
              }
 
            }
            

            maxLengthOfSubstring=Math.max(maxLengthOfSubstring,endWindow-startWindow+1);
//              System.out.println(hashmap+"; maxLengthOfSubstring:"+maxLengthOfSubstring+"; startWindow:"+startWindow+"; endWindow:"+endWindow);          
        }
        
        return maxLengthOfSubstring;
    }
}
