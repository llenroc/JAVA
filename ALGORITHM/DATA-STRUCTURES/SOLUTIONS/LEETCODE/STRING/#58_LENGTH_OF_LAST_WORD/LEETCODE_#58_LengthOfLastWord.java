/*
2021-Jan-25. Oleksii Saiun.
LeetCode_58. Length of Last Word
https://leetcode.com/problems/length-of-last-word/
*/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split("\\W+");

        if (str.length==0)
        {
            return 0;
        }
        else
        {
            int len=str.length;
            return str[len-1].length();
        }
    }
}
