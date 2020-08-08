import java.util.LinkedList;
import java.util.Queue;

import tree.binarytree.traversal.vertical.HashTreeMap;

/*Oleksii Saiun. 2020-Aug-08. Check if a tree is balanced
 * 
 * Tree is balanced if an absolute difference between right and left subtree of each node is not more than 1. 
   Approach - calculate 
 * */
class Tree {
	Node root;
	HashTreeMap hash = new HashTreeMap();

	public Tree(Node root) {
		this.root = root;
	}

	public boolean isBalanced(Node root) {
		if (root == null) {
			return false;
		}

		isBalanced(root.left);
		int leftHeifht = calcHeight(root.left);

		isBalanced(root.right);

		int rightHeifht = calcHeight(root.right);
		if (Math.abs(leftHeifht - rightHeifht) <= 1) {
			return true;
		} else {
			return false;
		}
	}

	public int calcHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = calcHeight(root.left);
		int rightHeight = calcHeight(root.left);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}

	}

	public void BSF(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			tmp.displayValue();
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}

			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
		}
	}
}

public class TreeCheckIfbalancedApp {

	public static void main(String[] args) {
		Node rootA = new Node(3);
		Node nodeA_9 = new Node(9);
		Node nodeA_20 = new Node(20);
		Node nodeA_15 = new Node(15);
		Node nodeA_7 = new Node(7);

		rootA.left = nodeA_9;
		rootA.right = nodeA_20;
		nodeA_20.left = nodeA_15;
		nodeA_20.right = nodeA_7;

		Node rootB = new Node(1);
		Node nodeB_2 = new Node(2);
		Node nodeB_3 = new Node(3);
		Node nodeB_4 = new Node(4);
		Node nodeB_5 = new Node(5);
		Node nodeB_6 = new Node(6);
		Node nodeB_7 = new Node(7);

		rootB.left = nodeB_2;
		rootB.right = nodeB_3;
		nodeB_2.left = nodeB_4;
		nodeB_2.right = nodeB_5;
		nodeB_4.left = nodeB_6;
		nodeB_4.right = nodeB_7;

		Tree tree = new Tree(rootA);
		tree.BSF(rootA);

		System.out.println(tree.isBalanced(rootA));

		/*
		 * 
		 * is balanced? - true
		    3
		   / \
		  9  20
		    /  \
		   15   7
   
            is balanced? - false
		       1
		      / \
		     2   3
		    / \
		   4   5
		  / \
		 6   7
		           
		 *
		 *
		 **/
	}

}
