/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
2020-Sep-07. Oleksii Saiun.
LeetCode_#1022. Sum of Root To Leaf Binary Numbers
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

this task is based on conversion binary number to decimal
The formula is use:
fro example, input = [11101]
= 1*(2^4) + 1*(2^3) + 1*(2^2) + 1*(2^1) + 0*(2^0)


Binary number:is base-2 numeral system or binary numeral system. This system uses only two symbols: 
typically 1 (one) and 0 (zero).

Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. 
It is also called base-ten positional numeral system.

*/

/*  
 *          1
 *       /     \
 *      0       1 
 *    /   \    /  \
 *   0     1  0    1
 *    
sum converted from binary to decimal [4]: {100}
sum converted from binary to decimal [5]: {101}
sum converted from binary to decimal [6]: {110}
sum converted from binary to decimal [7]: 111
 *    
 *    		
 */

class Solution {
    LinkedList<Integer> listPath = new LinkedList<>();
    int sumOfAllPath=0;
    public int sumRootToLeaf(TreeNode root) {
        findPath(root);
        return sumOfAllPath;
    }
    
	
	private void findPath(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        listPath.addLast(root.val);
        
        if (root.left == null && root.right==null)
        {
        	sumOfAllPath = sumOfAllPath+convertListOfIntToDecimal(listPath);
        }
        
        findPath(root.left);
        findPath(root.right);
        
        listPath.removeLast();
 
    }
    
    private int  convertListOfIntToDecimal(LinkedList<Integer> listPath)
	{
		int n = listPath.size();
		int index=0;
		int sum=0;
		
		for(int j=n-1;j>=0;j--)
		{
			sum=sum+listPath.get(j)*calcPowerOfTwo(index);
			index=index+1;
		}
		return sum;
	}
	
    private int calcPowerOfTwo(int n) {
		if (n == 0) {
			return 1;
		}
		
		return 2*calcPowerOfTwo(n-1);
	}
    
}
