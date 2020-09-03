import java.util.LinkedList;
import java.util.Queue;

/*
2020-Sep-03. Oleksii Saiun.
LeetCode_#700. Search in a Binary Search Tree
https://leetcode.com/problems/search-in-a-binary-search-tree/

input: key=2
		        4
		       / \
		      2   7
		     / \
		    1   3
		    
output:
		      2   
		     / \
		    1   3	
            
*/

class Tree {
	Node node;
	private Node rootOut;

	public void BSF(Node root) {
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

	public Node searchBST(Node root, int val) {
		inOrder(root, val);
		return rootOut;
	}

	public void inOrder(Node root, int key) {
		if (root == null) {
			return;
		}

		inOrder(root.left, key);
		inOrder(root.right, key);

		if (root.getValue() == key) {
			rootOut = root;
		}
	}

}

public class TreeSearchInBinaryTreeApp {

	public static void main(String[] args) {
		Node root = new Node(4);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node7 = new Node(7);

		root.left = node2;
		root.right = node7;
		node2.left = node1;
		node2.right = node3;
		Tree tree = new Tree();
		tree.BSF(root);

		tree.BSF(tree.searchBST(root, 2));

/*
input: key=2
		        4
		       / \
		      2   7
		     / \
		    1   3
		    
output:
		      2   
		     / \
		    1   3		    
		    
*/
	}
}
