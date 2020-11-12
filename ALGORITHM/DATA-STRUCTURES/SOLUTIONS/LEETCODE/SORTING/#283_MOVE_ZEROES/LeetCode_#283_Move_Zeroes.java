/*
2020-Nov-12. Oleksii Saiun.
LeetCode_#283. Move Zeroes
https://leetcode.com/problems/sort-an-array/
*/

class Solution {
	public void moveZeroes(int[] arr) {
		int len = arr.length;
		int index = 0;
		// move all not null elements to the left
		// we also keep a track for two pointers. The second pointer - is a pointer for not 0 values
		// when we moved all not 0 numbers to the left we fill out the rest of array by 0
		for (int k = 0; k < len; k++) {			
			if(arr[k]!=0)
			{
    			arr[index++]=arr[k];
			}				
		}		
        
        //fiil out by 0 the rest of position for not 0 elements
		for(int i=index;i<len;i++)
		{
			arr[i]=0;
		}		
	}
}
