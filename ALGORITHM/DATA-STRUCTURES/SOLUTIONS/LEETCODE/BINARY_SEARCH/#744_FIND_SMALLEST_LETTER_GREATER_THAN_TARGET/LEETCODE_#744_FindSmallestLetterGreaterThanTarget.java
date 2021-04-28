/*
2021-Apr-26. Oleksii Saiun.
744. Find Smallest Letter Greater Than Target
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
*/


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int codeOfTargetElem = Integer.valueOf(target);
        int codeOfFirstElem = Integer.valueOf(letters[0]);
        int codeOfLastElem = Integer.valueOf(letters[letters.length-1]);
        int startIndex=0;
        int endIndex=letters.length-1;
        
        if(codeOfTargetElem>=codeOfLastElem)
        {
            return (char) codeOfFirstElem;
        }
        
        while( startIndex<=endIndex)
        {
            int mediumIndex=(startIndex+endIndex)/2;
            int codeOfCurrentElem = Integer.valueOf(letters[mediumIndex]);

            if( codeOfTargetElem>codeOfCurrentElem )
            {
                startIndex=mediumIndex+1;
            }
            else if ( codeOfTargetElem<codeOfCurrentElem )
            {
                endIndex=mediumIndex-1;
            }
            else
            {/* if codeOfTargetElem==codeOfCurrentElem then we move forward, because we want to out first not equal value
            letters = ["c", "f", "f", "f", "s"]
            target = "f"
            
            out: "s"
            
            */
                startIndex=mediumIndex+1;
            }
        }
        
        char outElem = (char) letters[startIndex];
        return outElem;
    }
}
