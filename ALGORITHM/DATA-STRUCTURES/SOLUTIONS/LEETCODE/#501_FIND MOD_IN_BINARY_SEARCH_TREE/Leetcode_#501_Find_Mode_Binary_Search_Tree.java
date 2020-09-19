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
2020-Sep-18. Oleksii Saiun.
LeetCode_#501. Find Mode in Binary Search Tree
https://leetcode.com/problems/find-mode-in-binary-search-tree/

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
*/

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    Integer prevElement=null;
    int count=0;
    int maxElem=0;
    
    
    public int[] findMode(TreeNode root) {
        if (root==null )
        {
            int[] outEmpty = new int[0];
            return outEmpty;
        }
    	inOrder(root);    	
        return prepareOutArray();
    }
    
    public int[] prepareOutArray() {    	    	
        int[] out =new int[list.size()];
        for(int j=0;j<list.size();j++)
        {
        	out[j]=list.get(j);
        }
        return out;
    }
    
   
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);

		if (prevElement == null) {
			prevElement = root.val;
		}

		if (prevElement == root.val) {
			count = count + 1;

		} else {
			count = 1;
		}
		prevElement = root.val;

		if (count > maxElem) {

			maxElem = Math.max(count, maxElem);
            //IT IS MUST. SO, if there a new max we clean evrything and add a new value
			list.clear();
			list.add(root.val);
		}        
		else if (count == maxElem)
		{
            // if there are two the same max then it is ok. we want to see both in final output
			list.add(root.val);
		}
		inOrder(root.right);
	}
}
