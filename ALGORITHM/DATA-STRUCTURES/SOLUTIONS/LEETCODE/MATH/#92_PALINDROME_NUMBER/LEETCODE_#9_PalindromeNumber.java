/*
2021-Feb-22. Oleksii Saiun.
LeetCode_#9. Palindrome Number
https://leetcode.com/problems/palindrome-number/
*/


class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        } else if (x>=0 && x<=9)
        {
            return true;
        }
        
        Integer reverseX=0;
        int step=0;
        int tempX=x;
        
        while(tempX>0)
        {
            int digit=tempX%10;
            tempX=tempX/10;
            
            reverseX = reverseX*step+digit;
            step=10;
        }
            
        if( x-reverseX==0)
        {
            return true;
        }
        
        return false;
    }
}
