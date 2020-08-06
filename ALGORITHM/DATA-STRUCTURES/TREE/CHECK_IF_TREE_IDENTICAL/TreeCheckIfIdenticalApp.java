import java.util.LinkedList;
import java.util.Queue;

/* 2020-Aug-05. Oleksii Saiun. Check if two trees are identical

 *          26
          /   \
         10    3 
       /    \    \
      4     6     3 
     * 
     * 
     * output: true
 * */
class Tree {
	Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public boolean isSame(Node root1, Node root2) {
		// null == null  = > true
		if (root1 == null && root2 == null) {
			return true;
		} 
		
		if (root1 == null || root2 == null) {
			return false;
		} 

		if (root1.getValue() == root2.getValue()) {
			return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
		} else {
			return false;
		}
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
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}

			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
		}
		System.out.println();
	}
}

public class TreeCheckIfIdenticalApp {
	public static void main(String[] args) {
		Node root = new Node(26);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		Node node6 = new Node(6);

		root.left = node10;
		node10.left = node4;
		node10.right = node6;

		root.right = node1;
		node1.right = node3;
		node3.left = node7;
		node3.right = node9;

		Tree tree = new Tree(root);
		tree.BFS(root);
		tree.BFS(node10);
		System.out.println(tree.isSame(node10, node10));

	    /*
        26
      /   \
     10    1 
   /    \    \
  4     6     3 
             7  9
 * 
 * 
 * output: true
 * 
 * 
 * 
 * */
	}

}
