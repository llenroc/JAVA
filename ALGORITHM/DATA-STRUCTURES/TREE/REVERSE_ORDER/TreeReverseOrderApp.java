
import java.util.LinkedList;
import java.util.Queue;

/*2020-Jul-22. Oleksii Saiun. Reverse order
 * */
class Node {
	private int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void displayValue() {
		System.out.print(value + " ");
	}
}
class Tree {
	Node root;

	public Tree(Node root) {
		this.root = root;
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
	
	public void BSFreverse(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			tmp.displayValue();
			
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}

			if (tmp.left != null) {
				queue.offer(tmp.left);
			}
		}
	}
}

public class TreeReverseOrderApp {
	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		root.left = node3;
		node3.left = node2;
		node2.left = node1;
		node2.right = node11;

		root.right = node10;
		node10.left = node8;
		node10.right = node16;
		node16.right = node17;
		node17.right = node19;
		Tree tree = new Tree(root);
		tree.BSF(root);
		System.out.println();
		tree.BSFreverse(root);


	       /*
      *          9 
      *       3      10  
      *    2       8  16
      *  1  11           17
      *                    19
      *        
      *  Output:
      *  [0] 9 
         [1] 10 3 
         [2] 16 8 2 
         [3] 17 11 1 
         [4] 19       
      *        
      *        
      * */
	}
}
