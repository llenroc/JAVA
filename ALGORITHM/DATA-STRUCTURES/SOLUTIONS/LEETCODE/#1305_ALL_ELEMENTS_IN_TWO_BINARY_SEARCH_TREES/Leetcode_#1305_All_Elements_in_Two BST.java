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
2020-Sep-19. Oleksii Saiun.
LeetCode_#1305. All Elements in Two Binary Search Trees
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
*/

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        postOrder(root1);
        postOrder(root2);
        Collections.sort(list);
        return list;
    }
    
    public void postOrder(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
        list.add(root.val);
        postOrder(root.left);
        postOrder(root.right);        
    }
}
