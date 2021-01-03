/*
2021-Jan-03. Oleksii Saiun.
LeetCode_#480. Sliding Window Median
https://leetcode.com/problems/sliding-window-median/
*/

class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(
    );
    
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        Collections.reverseOrder()
    );
        
    public double[] medianSlidingWindow(int[] nums, int k) {
        int startWindow=0;
        int endWindow=0;
        int index=0;
        double[] outOfMediansArr = new double[nums.length-k+1];
        for(endWindow=0; endWindow<nums.length; endWindow++)
        {
            addToTwoHeaps(nums[endWindow]);
            if(endWindow-startWindow>k-1)
            {
              int elemToRemove = nums[startWindow];
                
                if(maxHeap.contains(elemToRemove))
                {
                    maxHeap.remove(elemToRemove);
                }
                else
                {
                    minHeap.remove(elemToRemove);                    
                }
                rebalanceTwoHeaps();
              startWindow++;
            }
            
            if(endWindow-startWindow==k-1)
            {  
                double valMed = calcMedian();
                outOfMediansArr[index++] = valMed;
//                System.out.println("maxHeap:"+maxHeap+"; minHeap:"+minHeap+"; median:"+valMed+"; startWindow:"+startWindow+"; endWindow:"+endWindow);
            }
        }

        return outOfMediansArr;
    }
    
    private void addToTwoHeaps(int value)
    {
        if (maxHeap.size()==0 || value<=maxHeap.peek())
        {
            maxHeap.offer(value);
        }
        else
        {
            minHeap.offer(value);
        }        

        rebalanceTwoHeaps();
    }
    
    private void rebalanceTwoHeaps()
    {
        int sizeOfMaxHeap = maxHeap.size();
        int sizeOfMinHeap = minHeap.size();
        
        if( sizeOfMaxHeap - sizeOfMinHeap >1 )
        {
            Integer tmpVal = maxHeap.poll();
            minHeap.offer(tmpVal);
        }
        else if (sizeOfMinHeap - sizeOfMaxHeap >1)
        {
            Integer tmpVal = minHeap.poll();
            maxHeap.offer(tmpVal);            
        }        
    }
            
    private double calcMedian()
    {
        double outMedian;
        int sizeOfMaxHeap = maxHeap.size();
        int sizeOfMinHeap = minHeap.size();
        
        
        if (sizeOfMaxHeap==sizeOfMinHeap)
        {
            outMedian = (double) (maxHeap.peek()/2.0 + minHeap.peek()/2.0); 
        }
        else if (sizeOfMaxHeap>sizeOfMinHeap)
        {
            outMedian = (double) maxHeap.peek();
        }
        else
        {
            outMedian = (double) minHeap.peek();            
        }
        
        return outMedian;
    }
}
