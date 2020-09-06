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
2020-Sep-05. Oleksii Saiun.
LeetCode_#103. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

class Solution {
    private	List<List<Integer>> listLevel = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        initializeList(root);
        BFS(root);
        return listLevel;
    }
    
    private int heightTree(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int leftHeight = heightTree(root.left);
		int rightHeight = heightTree(root.right);
		
		if (leftHeight>rightHeight)
		{
			return leftHeight+1;
		}
		else
		{
			return rightHeight+1;
		}
	}
	
	private void initializeList(TreeNode root)
	{
		int height = heightTree(root);		
		for (int j=0; j<height;j++ )
		{
		 listLevel.add(j, new LinkedList<>());		 
		}
	}
	
	private void insertIntoList( int index, int value)
	{		
		if(index%2==0)
        {
            List<Integer> currentList = listLevel.get(index);
			((LinkedList<Integer>) currentList).addLast(value);
        }
        else 
        {
            List<Integer> currentList = listLevel.get(index);
			((LinkedList<Integer>) currentList).addFirst(value);
        }
	
	}
	
	private void BFS(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		
		int height=0;
		TreeNode dummyNode = new TreeNode(Integer.MIN_VALUE);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(dummyNode);
		
		while(!queue.isEmpty())
		{
			TreeNode tmpNode = queue.poll();
		    
			//section to identify new level
			if(tmpNode.val == dummyNode.val)
			{
				height=height+1;
				
				if(!queue.isEmpty())
				{
					queue.offer(dummyNode);
				}
			} else
			{
				insertIntoList(height, tmpNode.val);				
			}
			
			
			if(tmpNode.left!=null)
			{
				queue.offer(tmpNode.left);
			}
			
			if(tmpNode.right!=null)
			{
				queue.offer(tmpNode.right);
			}
		}
	}
    
}