/*
2021-Feb-27. Oleksii Saiun.
LeetCode_#238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/submissions/

Example,
input = [5,1,2,3,4]
out = [24,120,60,40,30]
Solution:
1) we create two additional arrays
arrMultipliesFromLeft will have all multiplies from the left except [i] position
arrMultipliesFromRight  will have all multiplies from the right except [i] position

3) mutliply all elements for each [i] position

arrMultipliesFromLeft = [1,5,5,10,30]
arrMultipliesFromRight = [24,24,12,4,1]
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] arrMultipliesFromLeft = new int[nums.length];
        int[] arrMultipliesFromRight = new int[nums.length];
        int[] out = new int[nums.length];
        
        arrMultipliesFromLeft[0]=1;
        arrMultipliesFromRight[nums.length-1]=1;
        
        for(int j=1; j<nums.length; j++)
        {
            int leftMultip=nums[j-1]*arrMultipliesFromLeft[j-1];
            arrMultipliesFromLeft[j]=leftMultip;
        }
        

        for(int j=nums.length-2; j>=0; j--)
        {
            int rightMultip=nums[j+1]*arrMultipliesFromRight[j+1];
            arrMultipliesFromRight[j]=rightMultip;
        }        
        
        for(int j=0; j<nums.length; j++)
        {
            out[j] = arrMultipliesFromLeft[j] * arrMultipliesFromRight[j];
        }
    //    displayArray(arrMultipliesFromLeft);
  //      displayArray(arrMultipliesFromRight);
//        displayArray(out);
        return out;
    }
    
    private void displayArray(int[] arr)
    {
        for(int j=0; j<arr.length; j++)
        {
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
