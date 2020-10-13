class Solution {
/*
2020-Oct-13. Oleksii Saiun.
LeetCode_#7. Reverse Integer
https://leetcode.com/problems/reverse-integer/
*/   
    public int reverse(int x) {
        return reverseValue(x);
    }
    
    
    private int reverseValue(int x) throws NumberFormatException{
        Integer out=0;
        StringBuilder reverseValue = new StringBuilder();
        
        try{
        int val= Math.abs(x);
        while(val!=0)
        {
            int digit = val%10;
            reverseValue.append(digit);
            val=val/10;
        } 
        
        if (x>0)
        {
            out=Integer.valueOf(String.valueOf(reverseValue));
        }
        else
        {
            out=(-1)*Integer.valueOf(String.valueOf(reverseValue));
        }
       }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return out;
    }
    
}
