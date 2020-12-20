/*
2020-Dec-18. Oleksii Saiun.
LeetCode_#1054. Distant Barcodes
https://leetcode.com/problems/distant-barcodes/
*/

import java.util.Map.*;
class Solution {
    private HashMap<Integer, Integer> map  = new HashMap<>();
    private PriorityQueue<Integer> heap = new PriorityQueue<>(
                                   (o1,o2) -> map.get(o2) - map.get(o1)
                                                              );
    public int[] rearrangeBarcodes(int[] barcodes) {
        populateMap(barcodes);
        populateHeap();
        int[] out = new int[barcodes.length];
        int index=0;


        while(heap.size() >=2)
        {
            List<Integer> listOfHeaps = new ArrayList<>();
            for(int i =0; i <=1; i++)
            {
                int key = heap.poll();
                listOfHeaps.add(key);
                out[index++]=key;
                int freq = map.get(key)-1;
                map.put(key, freq);
            }
            
            for(int i=0; i<listOfHeaps.size();i++)
            {
                int key = listOfHeaps.get(i);
                int freq= map.get(key);
                if (freq>0)
                {
                    heap.offer(key);
                }   
            }

        }

        if(heap.size()==1)
        {
           out[index++]=heap.poll();

        }

        return out;
    }
    
    public void populateMap(int[] barcodes)
    {
        for(int j=0; j<barcodes.length; j++)
        {
            int key = barcodes[j];
            int freq = map.getOrDefault(key,0);
            map.put(key, freq+1);
        }
    }
    
    public void populateHeap()
    {
        for (Entry<Integer, Integer> j : map.entrySet())
        {
            heap.offer(j.getKey());
        }
    }
    
}
