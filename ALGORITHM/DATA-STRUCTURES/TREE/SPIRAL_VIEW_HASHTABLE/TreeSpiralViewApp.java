import java.util.LinkedList;
import java.util.Queue;

/*2020-Jul-22. Oleksii Saiun.
 * Spiral view - it is order level search, but orders displays visa verse
 * This approach is based on HashTable
 * 
 * BSF
 * 1
 * 2 3
 * 4 5 6
 * 
 * Spiral view
 * 1
 * 2 3
 * 6 5 4
 * 
 * */
class Tree {
	Node root;
	HashTable hash = new HashTable(10);

	public Tree(Node root) {
		this.root = root;
	}

	public void calcSpiralView(Node root) {
		int height = 0;
		Node dummyNode = new Node(-1);
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList();
		queue.offer(root);
		queue.offer(dummyNode);

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			if (tmp.getValue() != dummyNode.getValue()) {
				hash.insert(height, tmp);
			}
			if (tmp.getValue() == dummyNode.getValue()) {
				height = height + 1;
				if (!queue.isEmpty()) {
					queue.offer(dummyNode);
				}
			}
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}

			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
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

public class TreeSpiralViewApp {
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

		tree.calcSpiralView(root);
		tree.hash.displaySpiralAll();

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
