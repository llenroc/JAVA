/*
2020-Dec-03. Oleksii Saiun.
LeetCode_#1046. Last Stone Weight
https://leetcode.com/problems/last-stone-weight/

*/

class Solution {
    //max heap
    private PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2-o1);
    public int lastStoneWeight(int[] stones) {
        populateHeap(stones);
        
        while(heap.size()>=2)
        {
            System.out.println(heap);
            int val1 = heap.poll();
            int val2 = heap.poll();
            
            if(val1!=val2)
            {
                heap.offer(val1-val2);
            }
        }
        
        if(!heap.isEmpty())
        {
            return heap.poll();
        }
        else
        {
            return 0;
        }
    }
    
    private void populateHeap(int[] stones)
    {
        for(int j=0; j<stones.length; j++)
        {
            heap.offer(stones[j]);
        }
    }
}
