/*
2020-Dec-11. Oleksii Saiun.
LeetCode_#896. Monotonic Array
https://leetcode.com/problems/monotonic-array/

(!) one of the most popular Facebook's interview questions
*/


class Solution {
    public boolean isMonotonic(int[] A) {
        boolean flagIncreas=true;
        boolean flagDecreas=true;

        for(int j=1; j<A.length; j++)
        {

            if(A[j-1] < A[j])
            {
               flagIncreas = false;
            }
            else if (A[j-1] > A[j])
            {
                flagDecreas = false;
            }
            
            if( A[j-1] != A[j] && flagIncreas==flagDecreas)
            {
              return false ;
            }    
        }        
        return true;        
    }
}
