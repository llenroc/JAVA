/*
2021-Jan-26. Oleksii Saiun.
LeetCode_151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/
*/


class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\W+");
        StringBuilder strReverse = new StringBuilder();
        for(int j=str.length-1; j>=0; j--)
        {
            strReverse.append(str[j]+" ");
        }
        
        return String.valueOf(strReverse).trim();
    }
}
