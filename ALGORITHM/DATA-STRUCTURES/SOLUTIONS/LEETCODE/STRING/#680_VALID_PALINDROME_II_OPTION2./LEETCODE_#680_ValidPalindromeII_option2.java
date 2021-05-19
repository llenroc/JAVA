/*
2021-May-18. Oleksii Saiun.
LeetCode_#680. Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii/

Option2. remove element "on a left side" and check if it is a plindrome or 
         remove element "on a right side" and check if it is a plindrome 
*/

class Solution {
    public boolean validPalindrome(String s) {
        int startPoint=0;
        int endPoint=s.length()-1;
        
        while( startPoint<=s.length()-1 && endPoint>=0 )
        {       
            if( s.charAt(startPoint)!=s.charAt(endPoint) )
            {
/*
   if there is a mismatch. Now the question is what what to skip - "to the left" or "to the right"
   For example, 
   "abbxa" - we should skip [x] and move from the right to make sure it's a palindrome
    "axbba" - we should skip [x] and move from the left to make sure it's a palindrome
   That's why I remove element "on a left side" and check if it is a plindrome or not
   remove element "on a right side" and check if it is a plindrome 
*/
                
                StringBuilder strBld_ExcludeLeftPointerElement = new StringBuilder(s);
                String strWithoutLeft = String.valueOf(strBld_ExcludeLeftPointerElement.deleteCharAt(startPoint));
                int endPointLeft=strWithoutLeft.length()-1;
                
                StringBuilder strBld_ExcludeRightPointerElement = new StringBuilder(s);
                String strWithoutRight = String.valueOf(strBld_ExcludeRightPointerElement.deleteCharAt(endPoint));
                int endPointRight=strWithoutRight.length()-1;

                return isPalindrome(strWithoutLeft,0,endPointLeft)||
                       isPalindrome(strWithoutRight,0,endPointRight);
            }
            startPoint++;
            endPoint--;
        }        
        return true;
    }
    
    
    private boolean isPalindrome(String s, int startPoint, int endPoint)
    {
        while( startPoint<=s.length()-1 && endPoint>=0 )
        {            
            if( s.charAt(startPoint)!=s.charAt(endPoint) )
            {
                return false;
            }
            startPoint++;
            endPoint--;
        }        
        return true;
    }
}
