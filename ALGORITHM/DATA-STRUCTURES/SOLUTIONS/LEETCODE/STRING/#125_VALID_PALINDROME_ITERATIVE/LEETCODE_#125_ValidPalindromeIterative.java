/*
2021-Feb-23. Oleksii Saiun.
LeetCode_#125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
*/


class Solution {
    public boolean isPalindrome(String s) {
        
        String str = cleanString(s);
        int leftPointer=0;
        int rightPointer=str.length()-1;
        
        while(leftPointer<=str.length()-1 && rightPointer>=0)
        {

            if(str.charAt(leftPointer)!=str.charAt(rightPointer))
            {
                return false;
            }
            leftPointer++;
            rightPointer--;
            
        }
        return true;
    }
        
    private String cleanString(String s)
    {
        StringBuilder out = new StringBuilder();
        for(int j=0; j<s.length(); j++)
        {
            Character ch = s.charAt(j);
            if(Character.isLetterOrDigit(ch))
            {
                out.append(Character.toLowerCase(ch));
            }
        }
        return String.valueOf(out);
    }
}
