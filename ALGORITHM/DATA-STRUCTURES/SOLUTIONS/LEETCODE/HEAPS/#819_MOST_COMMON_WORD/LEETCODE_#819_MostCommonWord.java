/*
2021-Jan-26. Oleksii Saiun.
LeetCode_819. Most Common Word
https://leetcode.com/problems/most-common-word/submissions/
*/

import java.util.Map.*;
class Solution {
    private HashSet<String> setBanned = new HashSet<>();
    private HashMap<String, Integer> mapDictionary = new HashMap<>();
    private PriorityQueue<String> maxHeap = new PriorityQueue<String>(
           (o1,o2)  -> mapDictionary.get(o2) - mapDictionary.get(o1)
    );
    public String mostCommonWord(String paragraph, String[] banned) {
        populateSetOfBannedWords(banned);
        populatemMapOfDictionary(paragraph);
        //displayMap();
        
        for(Entry<String, Integer> j : mapDictionary.entrySet())
        {
            maxHeap.add(j.getKey());
        }
        return maxHeap.peek();
    }
    
    private void populateSetOfBannedWords(String[] banned)
    {       
        for(int j=0; j<banned.length; j++)
        {
          setBanned.add(banned[j]);
        }
    }
    
    private void populatemMapOfDictionary(String paragraph)
    {
        String[] str = paragraph.split("\\W+");        
        for(int j=0; j<str.length; j++)
        {
            String key = str[j].toLowerCase();
            int currFreq=mapDictionary.getOrDefault(key,0);
            if (!setBanned.contains(key))
            {
                mapDictionary.put(key,currFreq+1);
            }
            
        }
    }
    
     private void displayMap()
    {
        for(Entry<String, Integer> j : mapDictionary.entrySet())
        {
            System.out.println(j.getKey()+"; "+j.getValue());
        }
    }
    
}
