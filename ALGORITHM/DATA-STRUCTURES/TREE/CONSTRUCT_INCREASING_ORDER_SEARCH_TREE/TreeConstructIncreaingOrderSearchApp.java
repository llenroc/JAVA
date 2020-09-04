import java.util.LinkedList;
import java.util.Queue;

/*
2020-Sep-03. Oleksii Saiun.
LeetCode_#897. Construct Increasing Order Search Tree
https://leetcode.com/problems/increasing-order-search-tree/

   input:
	       5
	      / \
	     3    6
	    / \    \
	   2   4    8
	  /        / \ 
	 1        7   9
	 
	 output:
	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	          \
	           6
	            \
	             7
	              \
	               8
	                \
	                 9  

*/


class Tree {
	Node node;
	private LinkedList<Node> list = new LinkedList<>();

	public Tree() {
	}

	public void BFS(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();
			tmpNode.displayValue();

			if (tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}
		}
		System.out.println();
	}

	public Node increasingBST(Node root) {
		if (root == null) {
			return null;
		}

		inOrder(root);
		return buildBinaryTree();
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root);
		inOrder(root.right);
	}

	private Node buildBinaryTree() {
		Node rootResult = new Node(list.removeFirst().getValue());
		Node rootTmp = rootResult;
		while (!list.isEmpty()) {
			rootTmp.right = new Node(list.removeFirst().getValue());
			//the trickiest part!!!
			rootTmp = rootTmp.right;
		}

		return rootResult;
	}

}

public class TreeConstructIncreaingOrderSearchApp {
	public static void main(String[] args) {
		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		root.left = node3;
		node3.left = node2;
		node3.right = node4;
		node2.left = node1;

		root.right = node6;
		node6.right = node8;
		node8.left = node7;
		node8.right = node9;

		Tree tree = new Tree();
		tree.BFS(root);
		Node out = tree.increasingBST(root);
		tree.BFS(out);


/*
   input:
	       5
	      / \
	     3    6
	    / \    \
	   2   4    8
	  /        / \ 
	 1        7   9
	 
	 output:
	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	          \
	           6
	            \
	             7
	              \
	               8
	                \
	                 9  
	                 
*/	                 
	}

}
