package tree.binarytree.diameter2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Diameter of binary tree
 * it can be two vaiants
 * 1) the longest path go through a root node = then left height + right height
 * 2) the longest path go through not through a root node 
 * For example,
 *  *           9 
 *      10     11
 *   8     16     1
 * 7          17   
 *               19
 *                  2
 *                  
 *                  
 * */
class Tree
{
	Node node;
	
	public Tree(Node node)
	{
		this.node=node;
	}
	
	public int calcHeight(Node root)
	{
		if (root == null)
		{
			return 0;
		}
		
		int leftHeight = calcHeight(root.left);
		int rightHeight = calcHeight(root.right);
		
		if(leftHeight>rightHeight)
		{
			return leftHeight +1;
		}
		else
		{
			return rightHeight +1;
		}
		
	}
	
	public int calcDiagonal(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int leftHeight=calcHeight(root.left);
		int rightHeight=calcHeight(root.right);
		
		int leftDiagonal=calcDiagonal(root.left);
		int rightDiagonal=calcDiagonal(root.right);
		
		return Math.max(leftHeight+rightHeight+1, Math.max(leftDiagonal,rightDiagonal));
	}
	public void BFS(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
		
			Node tmp = queue.poll();
		    tmp.displayValue();
		    
			if(tmp.left!=null)
			{
				queue.offer(tmp.left);
			}

			if(tmp.right!=null)
			{
				queue.offer(tmp.right);
			}
			
		}
       System.out.println();
	}

}
class TreeDiameterApp 
{   
    public static void main(String args[]) 
    { 
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node7 = new Node(7);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		root.left = node10;
		node10.left = node8;
		node8.left = node7;
		
		node10.right = node16;
		node16.right=node17;
		node17.right=node19;
		node19.right=node2;

		root.right = node11;
		node11.right = node1;
    	Tree tree = new Tree(root); 
    	tree.BFS(root);
/*
 *           9 
 *      10     11
 *   8     16     1
 * 7          17   
 *               19
 *                  2
 * 
 * 
 * */
   	System.out.println("The height is : "+tree.calcHeight(root));
        System.out.println("The diameter of given binary tree is : "                      + tree.calcDiagonal(root)); 
    } 
} 

