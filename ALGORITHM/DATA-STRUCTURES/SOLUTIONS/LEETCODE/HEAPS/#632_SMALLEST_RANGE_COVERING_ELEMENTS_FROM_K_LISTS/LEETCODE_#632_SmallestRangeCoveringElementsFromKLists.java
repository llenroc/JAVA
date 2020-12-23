/*
2020-Dec-22. Oleksii Saiun.
LeetCode_#632. Smallest Range Covering Elements from K Lists
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
*/


class Node
{
    int value;
    int rowIndex;
    int columnIndex;
    
    public Node(int value, int rowIndex, int columnIndex)
    {
        this.value=value;
        this.rowIndex=rowIndex;
        this.columnIndex=columnIndex;
    }
    
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> heap = new PriorityQueue<>(
                          (o1,o2) -> o1.value - o2.value
        );

        int sizeOfLists = nums.size();
        int maxValue = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        HashMap<Integer, Integer[]> outHashOfRange = new HashMap<>();
        
        // 1. populate first elements (in [0] position)) among all lists
        for(int j=0; j<sizeOfLists; j++)
        {
            int rowIndex = j;
            int columnIndex = 0;
            int value = nums.get(j).get(columnIndex);
            Node newNode = new Node(value, rowIndex, columnIndex);
            heap.offer(newNode);
        // 2. we keep a track of each maxValue to calc distance
            maxValue = Math.max(maxValue,value);
        }
        
        //3. while [heap.size() == sizeOfLists] is true we loops
        // It means if we reach the end of one of the list that heap size will be less than sizeOfLists
        while( heap.size() == sizeOfLists) 
        {
            Node currNode = heap.poll();
            int currValue = currNode.value;
            int currColumnIndex = currNode.columnIndex;
            int currRowIndex = currNode.rowIndex;
            
            int currRange = maxValue - currValue;
            minRange=Math.min(minRange, currRange);
            
            // it is a technical implementation to out result in a way int[]
            if(!outHashOfRange.containsKey(minRange))
            {
                   outHashOfRange.put(minRange, new Integer[]{currValue, maxValue});         
            }

            int newColumnIndex = currColumnIndex+1;
            //if we can move forward tpward a list than we add a bew values to a heap
            if(newColumnIndex<nums.get(currRowIndex).size())
            {
                int newRowIndex = currRowIndex;
                int newValue = nums.get(newRowIndex).get(newColumnIndex);
                Node newNode = new Node(newValue,newRowIndex,newColumnIndex);
                heap.offer(newNode);
                maxValue = Math.max(maxValue,newValue);
            }
        }
        
        Integer[] out = outHashOfRange.get(minRange);
        return new int[]{out[0], out[1]};
    }
}
