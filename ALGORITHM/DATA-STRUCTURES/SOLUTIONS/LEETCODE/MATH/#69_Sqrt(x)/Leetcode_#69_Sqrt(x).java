/*
2020-Oct-10. Oleksii Saiun.
LeetCode_69. Sqrt(x)
https://leetcode.com/problems/sqrtx/
*/


class Solution {
    public int mySqrt(int x) {
    return (int) sqrtOfLong(x);
	}           
    
        public long sqrtOfLong(int x) {
		long index=1;
		
		while( index*index < x)
		{			
			index++;
		}
		
		if (index*index==x)
		{
			return index;
		}
		else
		{
			return index-1;
		}
	}   
}
