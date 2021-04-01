/*
2021-Apr-01. Oleksii Saiun.
LeetCode_#1539. Kth Missing Positive Number
https://leetcode.com/problems/kth-missing-positive-number/

*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b)-> b-a );
        int counter=1;
        int index=0;

        while(maxHeap.size()<k)
        {
            if( index<arr.length && counter<arr[index] )
            {
                maxHeap.add(counter);
                counter=counter+1;
            }
            else if( index<arr.length && counter==arr[index] )
            {
                index=index+1;
                counter=counter+1; 
            }
            else if( index>=arr.length)
            {
                maxHeap.add(counter);
                counter=counter+1;  
            }
        }

        return maxHeap.peek();
    }
}
