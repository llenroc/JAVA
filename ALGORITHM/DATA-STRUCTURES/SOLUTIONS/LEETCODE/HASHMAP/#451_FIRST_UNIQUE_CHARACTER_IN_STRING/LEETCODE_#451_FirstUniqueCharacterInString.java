/*
2020-Dec-06. Oleksii Saiun.
LeetCode_#387. First Unique Character in a String
https://leetcode.com/problems/first-unique-character-in-a-string/
*/

import java.util.Map.*;

class Solution {
    HashMap<Character, Integer> map = new LinkedHashMap<>();
    public int firstUniqChar(String s) {
        populateMap(s);
      
        for(Entry<Character, Integer> j : map.entrySet())
        {
          if ( j.getValue()>=0 )
          {
              return j.getValue();
          }
        }
        //return -1 if anything >0 is found
        return -1;
    }
    
    private void populateMap(String s)
    {
        for(int index=0; index<s.length(); index++)
        {
            Character key = s.charAt(index);

            //if it does not exists we insert into map key and position in a string
            if( !map.containsKey(key) )
            {
                 map.put(key,index);
            }
            else // if exists put an artifical calue [1-] mark that it is already repeated
            {
                map.put(key,-1);
            }
            
        }
    }
    
    public void displayMap()
    {
        for(Entry<Character, Integer> j : map.entrySet())
        {
            Character key = j.getKey();
            int freq = j.getValue();
            System.out.println(key+"; "+freq);
        }
    }
}
