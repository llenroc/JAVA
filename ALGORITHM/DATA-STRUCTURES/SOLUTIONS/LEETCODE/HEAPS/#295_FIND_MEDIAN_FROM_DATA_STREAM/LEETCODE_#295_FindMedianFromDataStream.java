/*
2021-Jan-02. Oleksii Saiun.
LeetCode_#295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/
*/


class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>
    (
      (o1,o2) -> o1-o2
    );
    
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>
    (
      (o1,o2) -> o2-o1
    );
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) { 
        /*
        * [maxHeap.isEmpty()] condition meeans we insert first there when it's empty. For example, when both heaps are empty
        */
        if (maxHeap.isEmpty() || num<maxHeap.peek())
        {
            maxHeap.offer(num);
        }
        else
        {
            minHeap.offer(num);
        }
        
        int sizeOfMaxHeap = maxHeap.size();
        int sizeOfMinHeap = minHeap.size();
        /*
        * 2. when size of one of heaps is higher than other more than 1 we rebalanace - poll element from bigger heap and insert inth smaller
        */        
        if( sizeOfMaxHeap - sizeOfMinHeap >1)
        {
            int tmpVal = maxHeap.poll();
            minHeap.offer(tmpVal);
        }
        else if( sizeOfMinHeap- sizeOfMaxHeap >1 )
        {
            int tmpVal = minHeap.poll();
            maxHeap.offer(tmpVal);            
        }
    }
    
    public double findMedian() {
        double out;
        int sizeOfMaxHeap = maxHeap.size();
        int sizeOfMinHeap = minHeap.size();
        
        /*
        *  A logic of calculation median:
        *  1) when a size of array is even than medium is ([top from maxHeap] - [top from minHeap])/2
        *  2) when a size of array is odd than medium is a top element from heap pf higher size
        */       
        
        if (sizeOfMaxHeap==sizeOfMinHeap)
        {
            out = (double) (maxHeap.peek() + minHeap.peek())/2;
        }
        else if(sizeOfMaxHeap>sizeOfMinHeap)
        {
            out = maxHeap.peek();
        }
        else
        {
            out = minHeap.peek();            
        }
        return out;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
