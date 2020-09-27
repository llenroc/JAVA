/*
2020-Sep-27. Oleksii Saiun.
LeetCode_#96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/
*/

class Solution {
    public int numTrees(int n) {
        int[] arr = buildCatalan(n);
        return arr[n];
    }
    
    public int[] buildCatalan(int n)
    {
        if (n==0)
        {
            return new int[1];
        }
        else
        {
            int[] arr = new int[n+1];
            arr[0]=1;
            for(int k=1;k<=n;k++)
            {
                int sum=0;
                for(int j=0; j<=k-1; j++)
                {
                    sum = sum + arr[j]*arr[k-j-1];
                }
                
                arr[k]=sum;
            }
            return arr;
        }
    }
}
