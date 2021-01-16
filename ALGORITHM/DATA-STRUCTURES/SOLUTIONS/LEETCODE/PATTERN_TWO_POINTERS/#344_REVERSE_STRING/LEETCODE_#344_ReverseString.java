/*
2021-Jan-16. Oleksii Saiun.
LeetCode_#344. Reverse String
https://leetcode.com/problems/reverse-string/
*/

class Solution {
    public void reverseString(char[] s) {
        int leftPointer=0;
        int rightPointer=s.length-1;
        
        while(leftPointer<rightPointer)
        {
            char tmp=s[leftPointer];
            s[leftPointer]=s[rightPointer];
            s[rightPointer]=tmp;
            leftPointer++;
            rightPointer--;
        }
    }
}
