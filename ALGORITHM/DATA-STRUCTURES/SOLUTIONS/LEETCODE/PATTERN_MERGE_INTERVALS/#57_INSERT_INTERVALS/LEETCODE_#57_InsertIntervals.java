/*
2021-Mar-24. Oleksii Saiun.
LeetCode_#57. Insert Interval
https://leetcode.com/problems/insert-interval/

Pattern Merge Intervals
*/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0)
        {
            return  new int[][]{newInterval};
        }
        
        List<int[]> mergedIntervalList = new ArrayList<>();
        int index=0;
        
        //--0.-----------
        if(newInterval[0] < intervals[index][0])
        {
           int newIntervStart = newInterval[0];
           int newIntervEnd = newInterval[1];              
           int currIntervStart = intervals[index][0];
           int currIntervEnd =intervals[index][1];            
           if(currIntervStart<=newIntervEnd)
           {
             int startOfMerged = Math.min(newIntervStart,currIntervStart);
             int endOfMerged = Math.max(newIntervEnd,currIntervEnd);  
             int[] mergedInterval = new  int[]{startOfMerged,endOfMerged};
        
               mergedIntervalList.add(mergedInterval);               
   
               index++; 
           }
            else
            {
               mergedIntervalList.add(newInterval);                  
            }
        }
        else{
        //--1.----. Looping while we can't find a proper place     
        while( index<intervals.length && newInterval[0] >= intervals[index][0])
        {
          mergedIntervalList.add(intervals[index]);
          index++;  
        }

        //--2.----. Merge of a new interval
           int lastIndex=index-1;
           int newIntervStart = newInterval[0];
           int newIntervEnd = newInterval[1];
           int prevIntervStart = intervals[lastIndex][0];
           int prevIntervEnd = intervals[lastIndex][1];
          
            //if there is an overlap then merge
           if( newIntervStart<=prevIntervEnd)
           {
                
             int startOfMerged = Math.min(newIntervStart,prevIntervStart);
             int endOfMerged = Math.max(newIntervEnd,prevIntervEnd);  
             int[] mergedInterval = new  int[]{startOfMerged,endOfMerged};
        
             mergedIntervalList.remove(lastIndex);
             mergedIntervalList.add(mergedInterval);
           }
            else
            {
             mergedIntervalList.add(newInterval);       
                
            }

            
        }
        
        //--3.----. Processing for the remaining part
          int[] prevInterv = mergedIntervalList.get(mergedIntervalList.size()-1);
          while(index<intervals.length)
                {
                  int[] currInter = intervals[index];
                  int prevIntervStart = prevInterv[0];
                  int prevIntervEnd = prevInterv[1];              
                  int currIntervStart = intervals[index][0];
                  int currIntervEnd =intervals[index][1];
              if(currIntervStart<=prevIntervEnd)
              {
               int startOfMerged = Math.min(currIntervStart,prevIntervStart);
               int endOfMerged = Math.max(currIntervEnd,prevIntervEnd);                 
               int[] mergedInterval = new  int[]{startOfMerged,endOfMerged};
               mergedIntervalList.remove(mergedIntervalList.size()-1);
               mergedIntervalList.add(mergedInterval);                  
              }
              else
              {
                mergedIntervalList.add(new int[]{currIntervStart,currIntervEnd});   
              }
              
              index++;
                }
         int[][] outMatrix = convertListToMatrix(mergedIntervalList);
        return outMatrix;
    }
    
    public int[][] convertListToMatrix(List<int[]> list)
    {
       int[][] outMatrix = new int[list.size()][2];
        for(int j=0; j<list.size(); j++)
        {
            int val0 = list.get(j)[0];
            int val1 = list.get(j)[1];
            outMatrix[j][0]=val0;
            outMatrix[j][1]=val1;
        }
        return outMatrix;
    }
    public void displayListOfIntervals(List<int[]> list)
    {
        for(int j=0; j<list.size(); j++)
        {
            System.out.println(list.get(j)[0] +" "+list.get(j)[1]);
        }
    }
}
