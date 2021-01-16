/*
2021-Jan-16. Oleksii Saiun.
LeetCode_1119. Remove Vowels from a String
https://leetcode.com/problems/remove-vowels-from-a-string/
*/

class Solution {
    public String removeVowels(String s) {
        StringBuilder out = new StringBuilder();
        for(int j=0;j<s.length();j++)
        {
            if(!isVowel(s.charAt(j)))
            {
                out.append(s.charAt(j));
            }
        }
        
        return String.valueOf(out);
    }
    
    private boolean isVowel(char ch)
    {
        return                    
                     ch=='a'
                  || ch=='e'
                  || ch=='i'
                  || ch=='o'
                  || ch=='u'
            ;                         
    }
}
