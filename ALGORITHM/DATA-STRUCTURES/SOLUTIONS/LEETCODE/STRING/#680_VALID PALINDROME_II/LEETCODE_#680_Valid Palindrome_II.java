/*
2021-Feb-24. Oleksii Saiun.
LeetCode_#680. Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii/
*/

class Solution {
    public boolean validPalindrome(String s) {
        int attempt=0;
        int leftPointer=0;
        int rightPointer=s.length()-1;

         while( leftPointer<= rightPointer )
        {
            if( s.charAt(leftPointer) != s.charAt(rightPointer) )
            {
/* it's an interesting case when there is a mismatch. According to the task we can skip ignore one symbol
   if there is a mismatch. Now the question is what what to skip - "to the left" or "to the right"
   For example, 
   "abbxa" - we should skip [x] and move from the right to make sure it's a palindrome
    "axbba" - we should skip [x] and move from the left to make sure it's a palindrome

That's why we will move from the left and from the right to hope it will return the true
*/
                return isPalindromeSubString(s, leftPointer+1,rightPointer) || 
                       isPalindromeSubString(s, leftPointer,rightPointer-1);
            }
            leftPointer++;
            rightPointer--;
         }
        return true;
    }
    
    private boolean isPalindromeSubString(String s, int leftPointer, int rightPointer)
    {
        while( leftPointer<= rightPointer )
        {
            if( s.charAt(leftPointer) != s.charAt(rightPointer) )
            {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}

