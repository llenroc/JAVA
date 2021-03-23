/*
2021-Mar-22. Oleksii Saiun.
LeetCode_#56. Merge Intervals
https://leetcode.com/problems/merge-intervals/

Pattern Merge Intervals
*/


class Solution {
    public int[][] merge(int[][] intervals) { 
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);      
        List<int[]> outMergedInterv =  new ArrayList<>();
        
        int[] prevInterv = intervals[0];
        for(int col=1; col<intervals.length; col++)
        {
            int[] currInterv = intervals[col];
            int prevStart = prevInterv[0];
            int prevEnd = prevInterv[1];
            int currStart = currInterv[0];
            int currEnd = currInterv[1];        
            /*
             * if intervals overlap we merge them and accumulate, 
             *(!) but we don's add to the output, becasue it might be overlapped
             *for a next new interval, 
             *
             */
            if(currStart<=prevEnd)
            {
                
               prevInterv[1]=Math.max(prevEnd,currEnd);            
            }
            else
            {//if does not overlap. We are done with [prevInterval] and insert it to output
                outMergedInterv.add(prevInterv);
                prevInterv=currInterv;
            }
        }// insert the latest one in output
            outMergedInterv.add(prevInterv);  
        
            int[][] outMatrix = convertListToMatrix(outMergedInterv);
        return outMatrix;
    }
    
    private void displayIntervals(int[][] mt)
    {
        for( int col=0; col<mt.length; col++)
        {
            System.out.println(mt[col][0]+" "+mt[col][1]);
        }
    }
    
    private void displayList(List<int[]> list)
    {
        for( int j=0; j<list.size(); j++)
        {
            System.out.println(list.get(j)[0]+" "+list.get(j)[1]);
        }
    }
    
    private void displaInterv(int[] arr)
    {
            System.out.println(arr[0]+" "+arr[1]);
    }
    
    private int[][] convertListToMatrix(List<int[]> list)
    {
        int[][] out = new int[list.size()][2];
        for( int col=0; col<list.size(); col++)
        {
           out[col][0]=list.get(col)[0];
           out[col][1]=list.get(col)[1];
        }
        return out;
    }
    
}
