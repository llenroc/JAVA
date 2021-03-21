/*
2021-Mar-21. Oleksii Saiun.
LeetCode_#1143. Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/

LCS pattern. Formula
if 
  x(i)!=y(i) => max( dp[x(i-1)][y(i)], dp[x(i][y(i-1)])
else
             => 1 + dp[x(i-1)][y(i-1)]
  
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int lenOfText1 = text1.length();
        int lenOfText2 = text2.length();
        int[][] dp = new int[lenOfText1+1][lenOfText2+1];
        
        // col => text1
        // row => text2
        
        for( int col=1; col<=lenOfText1; col++)
        {
            for ( int row=1; row<=lenOfText2; row++)
            {
               /*text1.charAt(col-1)=text2.charAt(row-1) <=> dp[col,row]
                 when we navigate  to dp[col,row] it means text1.charAt(col-1)=text2.charAt(row-1).
                 beacuse indexint for string starts from 0
               */
                if ( text1.charAt(col-1) != text2.charAt(row-1) )
                {
                    dp[col][row] = Math.max(dp[col][row-1],dp[col-1][row]);
                }
                else
                {
                    dp[col][row] = 1 + dp[col-1][row-1];
                }
            }            
        }
 //       displayMatrix(dp);        
        return dp[lenOfText1][lenOfText2];
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
