/*
2021-Jan-20. Oleksii Saiun.
LeetCode_350. Intersection of Two Arrays II
https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/

class Solution {
    private HashMap<Integer, Integer> map2 = new HashMap<>();
    
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> outList = new ArrayList<>();
        
        populateMap2(nums2);
        
        for(int j=0; j<nums1.length; j++)
        {
            int key=nums1[j];
            if ( map2.containsKey(key))
            {
                outList.add(key);
                int currFreq = map2.get(key);
                map2.put(key,currFreq-1);
                if(currFreq-1<=0)
                {
                    map2.remove(key);
                }
            }
        }
        
        int[] out = new int[outList.size()];
        for(int j=0; j<outList.size();j++ )
        {
            out[j]=outList.get(j);
        }
        
        return out;
    }
    
    private void populateMap2(int[] nums2)
    {
        for(int j=0; j<nums2.length; j++)
        {
           int key = nums2[j];
           int currFreq = map2.getOrDefault(key,0);
           map2.put(key, currFreq+1);
        }
    }
}
