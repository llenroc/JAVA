import java.util.Map.*;

/*
2020-Dec-05. Oleksii Saiun.
LeetCode_#451. Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/
*/

class Solution {
    private HashMap<Character, Integer> map = new HashMap<>();
    private PriorityQueue<Character> heap = new PriorityQueue<>(
    (o1,o2) -> map.get(o2) - map.get(o1)
    );
    
    public String frequencySort(String s) {
        populateMap(s);
        StringBuilder outStr = new StringBuilder();
        
        for (Entry<Character, Integer> j : map.entrySet())
        {
            heap.offer(j.getKey());
        }
        
        while(!heap.isEmpty())
        {
            Character key = heap.poll();
            int freq = map.get(key);
            while(freq-->0)
            {
              outStr.append(key);                
            }
        }
        return String.valueOf(outStr);
    }
    
    public void populateMap(String s)
    {
        for(int j=0; j<s.length();j++)
        {
            Character key = s.charAt(j);
            int freq = map.getOrDefault(key,0);
            map.put(key, freq+1);
        }
    }
}
