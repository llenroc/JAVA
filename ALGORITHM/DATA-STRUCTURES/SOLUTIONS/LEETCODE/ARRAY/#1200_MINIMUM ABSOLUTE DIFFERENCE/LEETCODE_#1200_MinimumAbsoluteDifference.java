/*
2020-Dec-25. Oleksii Saiun.
LeetCode_#1200. Minimum Absolute Difference
https://leetcode.com/problems/minimum-absolute-difference/submissions/
*/


class Solution {
    private PriorityQueue<Integer> heap = new PriorityQueue<>(
                                          (o1,o2) -> o1-o2
    );
    
    private PriorityQueue<List<Integer>> heapResult = new PriorityQueue<>(
                          (o1,o2) -> 
                           Math.abs(o1.get(0)-o1.get(1)) - Math.abs(o2.get(0)-o2.get(1))
    );
    
    Comparator<List<Integer>> sortByTwoFields = new Comparator<>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {

				return o1.get(0) - o2.get(0);
			}
		};
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        populateHeap(arr);
        int counter=0;
        List<List<Integer>> outOfAllPairs = new ArrayList<>();
        
        int lastDiff = Integer.MIN_VALUE;
        while(heap.size()>=2)
        {
            int firstValue = heap.poll();
            int secondValue = heap.peek();
            List<Integer> pair = new ArrayList<>();
            pair.add(firstValue);
            pair.add(secondValue);
            heapResult.offer(pair);
        }
        
        int prevDiff=Integer.MIN_VALUE;
        while(heapResult.size()>0)
        {
            List<Integer> currPair = heapResult.poll();
            int newDiff=Math.abs(currPair.get(0)-currPair.get(1));
            
            if(prevDiff!=Integer.MIN_VALUE && prevDiff!=newDiff)
            {
                Collections.sort(outOfAllPairs, sortByTwoFields);
                return outOfAllPairs;
            }
            else
            {
                outOfAllPairs.add(currPair);
                prevDiff=newDiff;
            }

        }
		Collections.sort(outOfAllPairs, sortByTwoFields);
        return outOfAllPairs;
    }
    
    public void populateHeap(int[] arr)
    {
        for(int j=0; j<arr.length; j++)
        {
            heap.offer(arr[j]);
        }
    }
}
