/*
2021-Mar-22. Oleksii Saiun.
LeetCode_#252. Meeting Rooms
https://leetcode.com/problems/meeting-rooms/

*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0)
        {
            return true;
        }
        Arrays.sort(intervals, (i1,i2) -> (i1[0]-i2[0]));
                    
        int[] prevInterval=intervals[0];           
        for(int j=1; j<intervals.length; j++)
        {
          int[] currInterval=intervals[j];    
          int currStart=currInterval[0];
          int prevEnd=prevInterval[1];
            
           if(currStart<prevEnd)
           {
               return false;
           }
           prevInterval=currInterval;
        }
        return true;
    }
}
