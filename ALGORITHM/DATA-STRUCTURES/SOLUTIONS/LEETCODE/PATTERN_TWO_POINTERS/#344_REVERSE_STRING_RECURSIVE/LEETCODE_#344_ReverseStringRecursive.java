/*
2021-May-18. Oleksii Saiun.
LeetCode_#344. Reverse String. Recursive
https://leetcode.com/problems/reverse-string/
*/

class Solution {
    char[] str;
    public void reverseString(char[] s) {
        int lenOfArr=s.length;
        int leftPointer=0;
        int rightPointer=s.length-1;
        str=s;
        reverseString(leftPointer,rightPointer);
    }
    
    private void reverseString(int leftPointer, int rightPointer) {
       if(leftPointer>rightPointer)
       {
           return;
       }

            char tmp=str[leftPointer];
            str[leftPointer]=str[rightPointer];
            str[rightPointer]=tmp;
            reverseString(leftPointer+1,rightPointer-1);
    }    
}
