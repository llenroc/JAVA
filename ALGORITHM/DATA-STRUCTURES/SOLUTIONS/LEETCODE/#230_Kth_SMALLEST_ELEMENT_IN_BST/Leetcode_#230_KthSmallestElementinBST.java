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
2020-Sep-02. Oleksii Saiun.
LeetCode_#230. Kth Smallest Element in a BST

https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

class Solution {
    private Queue<TreeNode> queue = new LinkedList<>();
    
    public int kthSmallest(TreeNode root, int k) {    
    inOrder(root);
    return getKthNode(k);
    }
    
    private void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
       inOrder(root.left) ;
    
       queue.add(root);
       inOrder(root.right) ;      
    }
    
    private int getKthNode(int k)
    {
        int index=1;
        int out=0;
        while(!queue.isEmpty())
        {
            int tmpValue = queue.poll().val;

            if(index==k)
            {
                out=tmpValue;
            }
            index=index+1;
        }
        return out;
    }
}
