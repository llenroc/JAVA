/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#15. 3Sum
https://leetcode.com/problems/3sum/
Approach 2 - two pointers
*/


class Solution {

    private Set<List<Integer>> setOfThreeSumList = new HashSet<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outThreeSumList = new ArrayList<>();        
        Arrays.sort(nums);
        displayArray(nums);

        Integer indexOfX=0;        
        Integer leftPointer;
        Integer rightPointer=nums.length-1;
        int index=0;
        
        while(nums.length - indexOfX >=3 )
        {            
            leftPointer=indexOfX+1;
//             System.out.println("index:"+index);
            findTwoSum(nums, nums[indexOfX++],leftPointer,rightPointer);   
            index++;
        }
        
        for(List<Integer> j : setOfThreeSumList)
        {
          outThreeSumList.add(j);
        }
        return outThreeSumList;
    }
    
    public void findTwoSum(int[] nums, int x, int leftPointer, int rightPointer)
    {
        while(leftPointer<rightPointer)
        {
            int twoSum = nums[leftPointer] + nums[rightPointer];
            
 //                   System.out.println("leftPointer:"+leftPointer+"; rightPointer:"+rightPointer+"; x:"+x+"; twoSum:"+twoSum+"; flag: "+(x+twoSum==0));  
            
            if (x+twoSum==0)
            {
                // find x+y+z==0;
                List<Integer> threeSum = new ArrayList<>();
                threeSum.add(x);
                threeSum.add(nums[leftPointer]);
                threeSum.add(nums[rightPointer]);
                
                setOfThreeSumList.add(threeSum);
             //   return;
            }
            if(twoSum>(-1)*x)
            {
               rightPointer--;
            }
            else // (twoSum<x)
            {
                leftPointer++;
            }
            

        }
    }
    public void displayArray(int[] nums)
    {
        for(int j : nums)
        {
           System.out.print(j+" ");
        }
        System.out.println();        
    }
}
