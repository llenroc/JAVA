/*
2021-Jan-20. Oleksii Saiun.
LeetCode_349. Intersection of Two Arrays
https://leetcode.com/problems/intersection-of-two-arrays/
*/

class Solution {
    private HashSet<Integer> set2 = new HashSet<>();
    
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> outList = new ArrayList<>();
        
        populateSecondHashSet(nums2);
        
        for(int j=0; j<nums1.length; j++)
        {
            if (set2.contains(nums1[j]))
            {
                outList.add(nums1[j]);
                set2.remove(nums1[j]);
            }
        }
        
        int[] out = new int[outList.size()];
        for(int j=0; j<outList.size();j++ )
        {
            out[j]=outList.get(j);
        }
        
        return out;
    }
    
    private void populateSecondHashSet(int[] nums2)
    {
        for(int j=0; j<nums2.length; j++)
        {
           set2.add(nums2[j]); 
        }
    }
}
