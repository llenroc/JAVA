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
LeetCode_#653. Two Sum IV - Input is a BST
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
*/

class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int key) {
        if (root==null)
        {
            return false;
        }  
        
        inOrder(root);
        boolean status = false;
        
        for( int j=0; j<list.size(); j++ )
        {
            
            for(int k=j+1; k<list.size(); k++)
            {
               if ( key==list.get(j)+list.get(k) )
               {
                   status = true;
                   break;
               }
            }
        }
        return status;
    }
    
    private void inOrder(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
