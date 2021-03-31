/*
2021-Mar-30. Oleksii Saiun.
LeetCode_#268. Missing Number. Approach2. Cyclic Sort
https://leetcode.com/problems/missing-number/

*/

class Solution {
    public int missingNumber(int[] nums) {
        int index=0;
        int lenOfArr = nums.length;
        
        while(index<lenOfArr)
        {
          int val=nums[index];
          if (index != val )
          {
              // checking if for a value existis index in array [3,0,1]. For [3] thre is no index in this array
              if ( val<lenOfArr )
              {
                  int index1 = index;
                  int index2 = val;
                  swap(nums, index1, index2);
              }
              else
              {
                index++;  
              }
          }
            else
            {
                index++;  
            }
        }
        
   //     displayArray(nums);
        for( int j=0; j<lenOfArr; j++)
        {
            if(j != nums[j])
            {
                return j;
            }
        }
      
        return lenOfArr;
    }
    
    private void swap(int[] arr, int index1, int index2)
    { 
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;               
    }
    
    private void displayArray(int[] arr)
    {
        for (int j=0; j<arr.length; j++)
        {
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
