/*
2021-Jan-16. Oleksii Saiun.
LeetCode_#345. Reverse Vowels of a String
https://leetcode.com/problems/reverse-vowels-of-a-string/
*/

class Solution {
    public String reverseVowels(String s) {        
        int leftPointer=0;
        int rightPointer = s.length()-1;
        
        char[] str = s.toCharArray();

        while(leftPointer<rightPointer)
        {            
            while( leftPointer<rightPointer && !isVowel(str[leftPointer]) )
            {
                leftPointer++;
            }
            
            while( leftPointer<rightPointer && !isVowel(str[rightPointer]) )
            {   
                rightPointer--;                
            }            

            char tmp = str[leftPointer];
            str[leftPointer] = str[rightPointer];
            str[rightPointer] = tmp;       
            
            leftPointer++;
            rightPointer--; 
        }
        
        return String.valueOf(str);
    }
    
    private boolean isVowel(char ch)
    {
        return                    
                     ch=='a' || ch=='A'
                  || ch=='e' || ch=='E' 
                  || ch=='i' || ch=='I'
                  || ch=='o' || ch=='O'
                  || ch=='u' || ch=='U'
            ;                         
    }
}
