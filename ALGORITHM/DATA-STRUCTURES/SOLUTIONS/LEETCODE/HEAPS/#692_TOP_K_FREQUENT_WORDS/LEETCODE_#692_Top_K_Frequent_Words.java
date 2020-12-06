import java.util.Map.*;

/*
2020-Dec-05. Oleksii Saiun.
LeetCode_#692. Top K Frequent Words
https://leetcode.com/problems/top-k-frequent-words/

Task:
Given a non-empty list of words, return the k most frequent elements.
(!)If two words have the same frequency, then the word with the lower alphabetical order comes first.
*/

class Solution {
    private HashMap<String, Integer> map = new HashMap<>();
    
    /*(!) Super trick in comparator:
    based on a task we handle two cases
    if values are the same we return 
    */
    private PriorityQueue<Entry<String, Integer>> heap = new PriorityQueue<>(
        (o1,o2) -> o1.getValue() == o2.getValue() 
                                 ? o2.getKey().compareTo(o1.getKey())
                                 : o1.getValue() - o2.getValue()
    );
    
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> list = new ArrayList<>();
        int indexOfList=k-1;
        populateMap(words);
        
        for(Entry<String, Integer> ent : map.entrySet())
        {
            heap.offer(ent);
            while(heap.size()>k)
            {
              heap.poll();                
            }
        }
            while(heap.size()>0)
            {
              Entry<String, Integer> entr = heap.poll();
              list.add(entr.getKey());
            }
        Collections.reverse(list);
        return list;
    }
    
    private void populateMap(String[] words)
    {
      for (String w : words)
      {
          String key = w;
          int freqOfWord = map.getOrDefault(key,0);
          map.put(key,freqOfWord+1);
      }
    }
    
    
}
