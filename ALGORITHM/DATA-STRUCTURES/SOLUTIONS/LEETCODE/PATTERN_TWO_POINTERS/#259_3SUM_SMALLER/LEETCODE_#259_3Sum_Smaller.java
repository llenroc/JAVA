/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#259. 3Sum Smaller
https://leetcode.com/problems/3sum/

*/


class Solution {
    private int counter=0;
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
      
        int indexOfX=0;        
        while(nums.length - indexOfX >=3 )
        {            
            twoSum(nums, nums[indexOfX],indexOfX,target);   
            indexOfX++;
        }
        return counter;
    }

    public void twoSum(int[] nums, int x, int indexOfX, int target)
    {
       int leftPointer=indexOfX+1;
       int rightPointer=nums.length-1;
        
       while(leftPointer<rightPointer)
       {
           int y = nums[leftPointer];
           int z = nums[rightPointer];

           int curr3Sum=x+y+z;
       
           if( x + y + z >= target)
           {
               rightPointer--;               
           }
           else
           {
               /*
               It's pretty easy to understand since we are sorting the array,
               now anything between left and right, if it satisfies the condition, will also satisfy the                condition of sum smaller than target. Since we are interested to find all the possible                    combinations, so each number between the two limit will make different combinations with                  the fixed element. 
*/
               counter=counter+(rightPointer-leftPointer);

               leftPointer++;
           }

       }
    }
  
}
