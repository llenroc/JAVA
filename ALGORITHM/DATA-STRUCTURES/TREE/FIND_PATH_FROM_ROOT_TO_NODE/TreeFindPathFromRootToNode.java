import java.util.ArrayDeque;
import java.util.LinkedList;

import java.util.Queue;


/*2020-Oct-13. Oleksii Saiun. Find path from root to node
	
	         5
	        / \
	       3   6
	      / \   \
	     2   4   7
	    /         \
	   1           8
	   
	   
	   Path[1,5] = [1, 2, 3, 5, 6, 7, 8];
	   Path[4,5] = [3, 5, 6, 7];
*/	   

class Tree {

	public boolean findPath(Node root, int key)
	{
		if(root==null)
		{

			return false;
		}

		
		if(root.getValue()==key)
		{
			root.displayValue();
			return true;
		}
		
		if(findPath(root.left,key))
		{
			root.displayValue();
			return true;
		}

		if(findPath(root.right,key))
		{
			root.displayValue();
			return true;
		}


		return false;
	}
	

	public void BFS(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node tmpNode = queue.poll();
			tmpNode.displayValue();
			
			if(tmpNode.left!=null)
			{
				queue.offer(tmpNode.left);
			}
			
			if(tmpNode.right!=null)
			{
				queue.offer(tmpNode.right);
			}
		}
		System.out.println();
	}
}

public class TreeFindPathFromRootToNode {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		root.left=node3;
		node3.left=node2;
		node3.right=node4;
		node2.left=node1;
		
		root.right=node6;
		node6.right=node7;
		node7.right=node8;

		Tree tree = new Tree();
		tree.BFS(root);

		tree.findPath(root, 4);
		

/*
		
        5
       / \
      3   6
     / \   \
    2   4   7
   /         \
  1           8
  
  
  Path[root,1] = [1 2 3 5];
  Path[root,4] = [4 3 5 ];
*/	     
	}
}



