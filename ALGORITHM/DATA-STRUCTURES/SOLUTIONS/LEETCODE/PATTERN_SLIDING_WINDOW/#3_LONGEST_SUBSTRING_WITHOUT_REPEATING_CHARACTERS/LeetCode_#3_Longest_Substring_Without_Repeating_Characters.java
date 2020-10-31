/*
2020-Oct-30. Oleksii Saiun.
LeetCode_#3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/   

class Solution {
    private Map<Character, Integer> hashmap = new HashMap<>();
    
    public int lengthOfLongestSubstring(String s) {
      if (s.length()==0)
      {
          return 0;
      }
      int startWindow=0;
      int endWindow=0;
      int maxLengthOfSubString=Integer.MIN_VALUE;
      for(endWindow=0; endWindow<s.length(); endWindow++)
        {
            char rightSymbol=s.charAt(endWindow);
            int freqOfRightSymbol = hashmap.getOrDefault(rightSymbol,0);
            hashmap.put(rightSymbol, freqOfRightSymbol+1);
            
            
            while(hashmap.getOrDefault(rightSymbol,0)>1)
            {
                char leftSymbol=s.charAt(startWindow);
                int freqOfLeftSymbol = hashmap.getOrDefault(leftSymbol,0);
                hashmap.put(leftSymbol, freqOfLeftSymbol-1);
                
                freqOfLeftSymbol = hashmap.getOrDefault(leftSymbol,0);
                //if a freq of left element is 0 then remove it from a hash table
                if (freqOfLeftSymbol==0)
                {
                    hashmap.remove(leftSymbol);
                }
                startWindow++;
            }
          
          int currentLengthOfSubString=hashmap.size();
          maxLengthOfSubString=Math.max(maxLengthOfSubString,currentLengthOfSubString);
        }
    return maxLengthOfSubString;
    }
    
}
