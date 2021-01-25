/*
2021-Jan-25. Oleksii Saiun.
LeetCode_884. Uncommon Words from Two Sentences
https://leetcode.com/problems/uncommon-words-from-two-sentences/
*/

import java.util.Map.*;

class Solution {
    private HashMap<String, Integer> map = new HashMap<>();
    
    public String[] uncommonFromSentences(String A, String B) {
        populateMap(A,B);
        List<String> outList= new ArrayList<>();

        for(Entry<String, Integer> j : map.entrySet())
        {
            String key = j.getKey();
            int freq = j.getValue();
            
            if(freq==1)
            {
              outList.add(key);
            }
        }
        
        String[] out = new String[outList.size()];
        int index=0;
        
        for(String j : outList)
        {
          out[index++] = j;
        }
        
        return out;
    }
    
    private void populateMap(String A, String B)
    {
        String[] strA = A.split("\\W+");
        String[] strB = B.split("\\W+");
        for(int j=0; j<strA.length; j++)
        {
            String key = strA[j];
            int currFreq = map.getOrDefault(key,0);
            map.put(key,currFreq+1);
        }

        for(int j=0; j<strB.length; j++)
        {
            String key = strB[j];
            int currFreq = map.getOrDefault(key,0);
            map.put(key,currFreq+1);
        }        
    }
}
