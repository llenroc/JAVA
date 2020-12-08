/*
2020-Dec-07. Oleksii Saiun.
LeetCode_#378. Kth Smallest Element in a Sorted Matrix
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

class Solution {
    private PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
    public int kthSmallest(int[][] matrix, int k) {
        
        for (int row=0;row<matrix.length;row++)
        {    
            {
                for(int col=0;col<matrix[row].length;col++)
                {
                            heap.offer(matrix[row][col]);
                            if(heap.size()>k)
                                {
                                    heap.poll();       
                                }
                    
                }
            }
        }
        return heap.peek();
    }
}
