/*
2021-Mar-21. Oleksii Saiun.
LeetCode_#718. Maximum Length of Repeated Subarray
https://leetcode.com/problems/maximum-length-of-repeated-subarray/


Formula
if 
  x(i)!=y(i) => max( dp[x(i-1)][y(i)], dp[x(i][y(i-1)])
else
             => 0
             
This task is a partial case of the problem "Longest Common Subsequence"
https://github.com/oleksiisaiun/JAVA/tree/master/ALGORITHM/DATA-STRUCTURES/SOLUTIONS/LEETCODE/DYNAMIC_PROGRAMMING/PATTERN3_LOWEST_COMMON_SUBSEQUENCE/%231143_LONGEST_COMMON_SUBSEQUENCE
*/

class Solution {
    public int findLength(int[] A, int[] B) {
        int lenOfA = A.length;
        int lenOfB = A.length;
        int[][] dp = new int[lenOfA+1][lenOfB+1];
        int lcs=Integer.MIN_VALUE;
        
        //A => row
        //B => column
        
        for ( int row=1; row <= lenOfA; row++ )
        {
           for ( int col=1; col <= lenOfB; col++ )
             {
                if ( A[row-1] == B[col-1])
                {
                    dp[row][col] = 1 + dp[row-1][col-1];
                }
           /*    else
               {
                   dp[row][col]=0;
               }
            */   
               lcs=Math.max(lcs,dp[row][col]);
             }            
        }
  //      displayMatrix(dp);
        return lcs;
    }
    
    public void displayMatrix(int[][] mt) {
		for (int col = 0; col < mt.length; col++) {
			for (int row = 0; row < mt[col].length; row++) {
				System.out.print(mt[col][row] + " ");
			}
			System.out.println();
		}
	}    
}
