/*
2020-Dec-07. Oleksii Saiun.
LeetCode_#373. Find K Pairs with Smallest Sums
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

class Solution {
    private PriorityQueue<List<Integer>> heap = new PriorityQueue<>(
                                        (list1,list2) -> (list2.get(0)+list2.get(1)) - (list1.get(0)+list1.get(1))
    );
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> listOutPairs = new ArrayList<>();
        for(int index1=0;index1<nums1.length;index1++)
        {
            for(int index2=0;index2<nums2.length;index2++)
            {
                List<Integer> list = new ArrayList<>();

                list.add(nums1[index1]);
                list.add(nums2[index2]);
                heap.offer(list);
                
                if(heap.size()>k)
                {
                  heap.poll();
                }
            }

        }
        
        //prepare output
        while(!heap.isEmpty())
        {
            listOutPairs.add(heap.poll());
        }
       return listOutPairs; 
    }
}
