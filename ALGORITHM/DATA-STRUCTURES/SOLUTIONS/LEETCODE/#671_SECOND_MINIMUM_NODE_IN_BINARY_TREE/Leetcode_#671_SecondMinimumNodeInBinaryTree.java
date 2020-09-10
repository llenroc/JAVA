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
2020-Sep-09. Oleksii Saiun.
LeetCode_#671. Second Minimum Node In a Binary Tree
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
*/

class Solution {
    private TreeSet<Integer> mySet = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        inOrder(root);
        Integer outValue=-1;
        
        if(mySet.size()==0 || mySet.size()==0)
        {
            return outValue;
        }
        int index=0;
        for(Integer j : mySet)
        {
            if(index==1)
            {
               outValue = j;
               break;
            }
            index=index+1;
        }
        
        return outValue;
    }
    
    private void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        inOrder(root.left);
        mySet.add(root.val);
        inOrder(root.right);
    }
}
