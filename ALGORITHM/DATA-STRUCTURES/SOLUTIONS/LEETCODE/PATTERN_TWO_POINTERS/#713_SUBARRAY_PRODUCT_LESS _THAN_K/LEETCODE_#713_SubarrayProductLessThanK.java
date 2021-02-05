class Solution {
    public int subarraySum(int[] nums, int k) {
        int startWindow=0;
        int endWindow=0;
        int currSum=0;
        int counter=0;
        
        
        for(endWindow=0; endWindow<nums.length; endWindow++)
        {
            int tmpSum=nums[endWindow];
            currSum=currSum+tmpSum;
            System.out.println("currSum:"+currSum+"; k:"+k+"; tmpSum:"+tmpSum);

            while(currSum>k &&startWindow<=endWindow)
            {
              currSum = currSum - nums[startWindow++];
            }
            if(currSum==k)
            {
        
               counter++;                
            }
        }
        
        return counter;
    }
}
