import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 2020-Aug-01. Oleksii Saiun. Sum of all nodes
 * 
 * Node are cousins if
 * 1) they have different parents
 * 2) parents are on the same level
 * 
/*
        1
     /     \
    2       3
   /       / \
  4       6   7
    \
     5   
     
   (4,6) = true;
   (2,3) = false;
   (6,7) = false;        
*/

class Tree {
	Node node;
	public Tree(Node node) {
		this.node = node;
	}	
	
	public int sum(Node root)
	{
		if (root==null)
		{
			return 0;
		}
		
		int leftSum=sum(root.left);
		int rightSum=sum(root.right);
		
		
		return leftSum+rightSum+root.getValue();
	}
    public void BFS(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {

			Node tmp = queue.poll();
			tmp.displayValue();

			if ( tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}

		}
		System.out.println();
	}



}

public class TreeSumAllNodesApp {
	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		root.left=node2;
		root.right=node3;
		node2.left=node4;
		node2.right=node8;

		
		root.right=node3;
		node3.left=node6;
		node3.right=node7;
		node4.right=node5; 
		
		Tree tree  = new Tree(root);

		tree.BFS(root);

		System.out.print(tree.sum(root));
/*
 * 
 *       1
     /     \
    2        3
  /   \     /   \
  4     8   6   7
 / 
 5
       
*/
	}
}
