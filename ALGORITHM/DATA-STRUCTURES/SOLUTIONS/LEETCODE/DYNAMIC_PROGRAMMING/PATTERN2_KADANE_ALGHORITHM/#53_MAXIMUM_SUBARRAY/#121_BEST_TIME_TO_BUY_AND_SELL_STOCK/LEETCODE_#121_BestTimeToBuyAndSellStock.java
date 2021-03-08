/*
2021-Mar-08. Oleksii Saiun.
LeetCode_#121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
*/


class Solution {
    public int maxProfit(int[] prices) {
       Integer profit=0;
       int buyValue=prices[0];
       int maxProfit=0;
       for(int j=1; j<prices.length; j++)
       {
           int sellValue=prices[j];
           int currentDifference=buyValue-sellValue;          
           if(currentDifference>0)
           {
              buyValue = prices[j];
           }
           else
           {
               maxProfit=Math.max(maxProfit,Math.abs(currentDifference));              
           }
       }
        
       return maxProfit;
    }
}
