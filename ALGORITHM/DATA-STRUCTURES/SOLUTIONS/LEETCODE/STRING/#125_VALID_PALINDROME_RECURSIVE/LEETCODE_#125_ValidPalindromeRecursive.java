/*
2021-May-18. Oleksii Saiun.
LeetCode_#125. Valid Palindrome Recursive
https://leetcode.com/problems/valid-palindrome/
*/


class Solution {
    public boolean isPalindrome(String s) {
        
        String str = cleanString(s);
        int leftPointer=0;
        int rightPointer=str.length()-1;

        return isPalindrome(str,leftPointer,rightPointer);
    }
    
    private boolean isPalindrome(String str,int leftPointer,int rightPointer) {
        /*
          why it is true here? because if out of boundaries it means we did not meet a case [str.charAt(leftPointer) !=str.charAt(rightPointer]
          it means we cab return true, because a string is really palindrome
        */
        if(leftPointer > str.length()-1 || rightPointer<0)
           {
             return true;
           }
        
        if(str.charAt(leftPointer) !=str.charAt(rightPointer)) 
           {
             return false;
            }
        
        return  isPalindrome(str,leftPointer+1,rightPointer-1);
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
