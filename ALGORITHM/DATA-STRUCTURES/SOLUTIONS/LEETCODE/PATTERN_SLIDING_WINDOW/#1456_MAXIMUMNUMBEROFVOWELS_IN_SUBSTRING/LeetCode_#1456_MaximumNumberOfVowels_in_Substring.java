/*
2020-Oct-30. Oleksii Saiun.
LeetCode_#1456. Maximum Number of Vowels in a Substring of Given Length
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
*/   

class Solution {
    public int maxVowels(String s, int k) {
        int startWindow = 0;
        int endWindow = 0;
        int currFreqOfVowels = 0;
        int maxNumberOfVowels=0;
        
        for(endWindow=0; endWindow<s.length(); endWindow++)
        {
            char rightSymbol =  s.charAt(endWindow);
            if(isVowel(rightSymbol))
            {
            currFreqOfVowels = currFreqOfVowels+1;
            }

            if( endWindow-startWindow+1 > k)
            {
                char leftSymbol =  s.charAt(startWindow++);
                if (isVowel(leftSymbol))
                {
                  currFreqOfVowels = currFreqOfVowels-1;
                }

            }
                        maxNumberOfVowels= Math.max(maxNumberOfVowels, currFreqOfVowels);
            
        }
        
        return maxNumberOfVowels;
    }
    
    private boolean isVowel(char symbol)
    {
         if(symbol=='a' || symbol=='e' ||  symbol=='i' ||  symbol=='o' ||  symbol=='u')
            {
            return true;
            }
        return false;
    }
}
