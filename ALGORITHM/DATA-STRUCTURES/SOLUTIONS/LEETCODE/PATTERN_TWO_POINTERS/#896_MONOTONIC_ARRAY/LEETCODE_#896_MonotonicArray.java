/*
2021-Jan-24. Oleksii Saiun.
LeetCode_896. Monotonic Array
https://leetcode.com/problems/monotonic-array/
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        int leftPointer=0;
        int rightPointer=A.length-1;
        
        boolean statusInitial;
        
        if( A[leftPointer]<=A[rightPointer] )
        {
            statusInitial = true;
        }
        else
        {
            statusInitial = false;            
        }
        
        for(int j=1; j<A.length; j++)
        {
          boolean statusCurrent;
        
          if( A[j-1]<=A[j] )
          {
             statusCurrent = true;
          }
          else
          {
             statusCurrent = false;            
          }
            
            if( A[j-1]!=A[j] && statusCurrent!=statusInitial )
            {
                return false;
            }
        }
        
        return true;
    }
}
