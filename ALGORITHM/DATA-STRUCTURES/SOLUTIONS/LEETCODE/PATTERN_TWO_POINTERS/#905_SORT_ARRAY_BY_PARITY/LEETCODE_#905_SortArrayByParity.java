/*
2021-Jan-12. Oleksii Saiun.
LeetCode_#905. Sort Array By Parity
https://leetcode.com/problems/sort-array-by-parity/
*/


class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] out = new int[A.length];
        
        int leftPoiner=0;
        int rightPoiner=A.length-1;
        
        for(int j=0; j<A.length; j++)
         {
            if(A[j]%2==0)
            {
                out[leftPoiner]=A[j];
                leftPoiner++;
            }
            else
            {
               out[rightPoiner]=A[j];   
                rightPoiner--;
            }
         }
        
        return out;
    }
}
