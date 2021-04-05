/*
2021-Apr-05. Oleksii Saiun.
LeetCode_#20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/submissions/
*/

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for( int j=0; j<s.length(); j++)
        {
            char currElem = s.charAt(j);
            
            if( currElem=='(' || currElem=='{' || currElem=='[')
            {
                stack.push(currElem);
            }
            else if ( !stack.isEmpty() &&  currElem==')' && stack.peek()=='(' )
            {
                stack.pop();
            }
            else if ( !stack.isEmpty() &&  currElem=='}' && stack.peek()=='{' )
            {
                stack.pop();
            }
            else if ( !stack.isEmpty() &&  currElem==']' & stack.peek()=='[' )
            {
                stack.pop();
            }    
            else
            {
                return false;
            }
        }
        
       if (stack.isEmpty())
       {
           return true;
       }
        else
        {
            return false;
        }
    }
}
