/*
2021-Apr-28. Oleksii Saiun.
1010. Pairs of Songs With Total Durations Divisible by 60
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

Modulo formula:
        (x+y)%60=0 <=> ((x%60) + (y%60))%60 = 0 <=> 
        2 cases:
        
        x%60=0 and y%60=0
        or 
        (x%60) + (y%60)=60 <=>  (x%60) = 60 - (y%60)
        
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter=0;
        for(int j=0; j<time.length; j++)
        {
            int valModule=time[j]%60;
            int z = 60 - valModule;

            if(valModule==0)
            {   int freq=map.getOrDefault(0,0);
                counter = counter+freq ;
            }
            else if (map.containsKey(z))
            {
                int freq=map.getOrDefault(z,0);
                counter = counter+freq ;                
            }
            
            map.put(valModule,map.getOrDefault(valModule,0)+1);
        }
        
        return counter;
    }
    
    
}
