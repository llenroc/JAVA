/*
2021-Mar-23. Oleksii Saiun.
LeetCode_#253. Meeting Rooms II
https://leetcode.com/problems/meeting-rooms-ii/

Pattern Merge Intervals
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
       Arrays.sort(intervals, (a,b)-> a[0]-b[0]); 
       /*It is the trickies part we sort heap by [end time]*/
       PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                                                          (a,b)-> a[1]-b[1]
                                                         );

    minHeap.offer(intervals[0]);
        
    for(int j=1; j<intervals.length; j++)
    {
       int[] prevInterval=minHeap.peek();
       int[] currInterval = intervals[j];
        
       int prevStart=prevInterval[0];
       int prevEnd=prevInterval[1];
       int currStart=currInterval[0];
       int currEnd=currInterval[1];
        
   //     System.out.println("prevStart:"+prevStart+"; prevEnd:"+prevEnd+"; currStart:"+currStart+"; currEnd:"+currEnd);   
        
        //if meetings overlap we add it to a heap and heap size is being increasing. It means we will ned more room
       if( currStart < prevEnd)
       {
          minHeap.offer(currInterval);
       }
        else
        {
        //if meetings does not overlap we can reuse the same room, So, we remove it froma heap and insert a new
            minHeap.poll();
            minHeap.offer(currInterval);
        }
     
    }
        int sizeOfHeap = minHeap.size();
       
  //      displayHeap(minHeap);
        
    return sizeOfHeap;
    }
    
    public void displayHeap(PriorityQueue<int[]> minHeap)
    {
        while(!minHeap.isEmpty())
        {
            int[] tmp = minHeap.poll();
            System.out.println(tmp[0]+" "+tmp[1]);
        }
    }

}
