/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#16. 3Sum Closest
https://leetcode.com/problems/3sum-closest/
*/

class Solution {
    private int[] closestValue=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};    
    //[minDist, sum of 3 Sum]
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
      
        int indexOfX=0;        
        while(nums.length - indexOfX >=3 )
        {            
            twoSum(nums, nums[indexOfX],indexOfX,target);   
            indexOfX++;
        }
        return closestValue[1];
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
           int currentDistance=Math.abs(target-curr3Sum);
           if(currentDistance<closestValue[0])
           {
               closestValue[0]=currentDistance;
               closestValue[1]=curr3Sum;
           }
 //          System.out.println("x:"+x+"; y:"+y+"; z:"+z+"; curr3Sum:"+curr3Sum+"; currentDistance:"+currentDistance+";closestValue:"+closestValue);             
           if( x + y + z >= target)
           {
               rightPointer--;               
           }
           else
           {
               leftPointer++;
           }

       }
    }
}
