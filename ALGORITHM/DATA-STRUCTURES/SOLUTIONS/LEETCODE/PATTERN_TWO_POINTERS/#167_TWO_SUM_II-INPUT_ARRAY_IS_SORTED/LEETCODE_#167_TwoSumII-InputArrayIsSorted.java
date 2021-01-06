/*
2021-Jan-06. Oleksii Saiun.
LeetCode_#167. Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum/

Time complexity: O(n)
Space complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer=0;
        int rightPointer=numbers.length-1;
        int sum;
        
        while(leftPointer<rightPointer)
        {
           sum = numbers[leftPointer] + numbers[rightPointer];
           if (sum==target)
           {
               return new int[]{leftPointer+1,rightPointer+1};
           }
            else if (sum<target)
            {
               sum=sum-numbers[leftPointer];
               leftPointer++;
               sum=sum+numbers[leftPointer];
            }
            else
            {
               sum=sum-numbers[rightPointer];
               rightPointer--;
               sum=sum+numbers[rightPointer];                
            }
        }
        
        return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
    }
}
