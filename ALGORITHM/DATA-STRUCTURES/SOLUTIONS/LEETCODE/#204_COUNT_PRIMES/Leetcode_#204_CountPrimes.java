/*
2020-Aug-20. Oleksii Saiun.
LeetCode_#204.Count Primes
https://leetcode.com/problems/count-primes/

Idea is to use the method [Sieve of Eratosthenes]

 Prime number is a number which is divisible by only two numbers: 1 and itself.\
 Prime number list : 2,3,5,7,9,11
 
*/

class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean[] arr = populateArrayByTrue(n);
        
        for(int j=2; j<n;j++)
        {
            if (arr[j])
            {
                count=count+1;
            }
        }
        
        return count;
    }
    
    
    private boolean[] populateArrayByTrue(int sizeInput)
    {
    	boolean[] arr = populateArray(sizeInput);
    	
    	for (int j=2;j*j<sizeInput;j++)
    	{
    		for(int k=j*j; k<sizeInput;k++)
    		{
    			if (k % j == 0)
    			{
    				arr[k]=false; // false = not prime
    			}

    		}
    	}    
    	return arr;
    }
    
    private boolean[] populateArray(int size)
	{
		boolean[] arr = new boolean[size];
		for (int j=0; j< arr.length;j++)
		{
			arr[j] = true;
		}
		return arr;
	}
    
}
