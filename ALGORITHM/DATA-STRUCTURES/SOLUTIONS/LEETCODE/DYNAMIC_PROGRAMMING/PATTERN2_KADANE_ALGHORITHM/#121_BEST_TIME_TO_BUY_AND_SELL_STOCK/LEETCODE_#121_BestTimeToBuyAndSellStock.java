/*
2021-Mar-08. Oleksii Saiun.
LeetCode_#121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int currProfit=0;
        int sellStockValue=0;
        int buyStockValue=prices[0];
            
            for(int j=1; j<prices.length; j++)
            {
                sellStockValue=prices[j];
                currProfit=sellStockValue-buyStockValue;
                if(currProfit<0)
                {
                    buyStockValue=prices[j];
                }
                
                maxProfit=Math.max(maxProfit,currProfit);
            }
            
            
            return maxProfit;
    }
}
