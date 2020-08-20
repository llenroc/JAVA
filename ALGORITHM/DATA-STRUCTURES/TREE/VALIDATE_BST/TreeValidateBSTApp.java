import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-20. Oleksii Saiun. Validate BST
 * */
class Tree {
	Node node;
	private LinkedList<Node> listPath = new LinkedList();

	public Tree(Node node) {
		this.node = node;
	}

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

	public boolean isValidBST(Node root) {

		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

    /* PAY ATTENTION ABOUT NOT EXPRESSION
     * 
     * IS CORRECT:
     * ( !(A>0) || !(B>0))
     * 
     * IS NOT CORRECT:
     * ( !((A>0) || (B>0)))         
     * 
     * */	
	private boolean isValidBST(Node root, long min, long max) {
		if (root == null) {
			return true;
		}
	
		if (!(root.getValue() < max) || !(root.getValue() > min)) {
			return false;
		}
		
		return isValidBST(root.left, min, root.getValue()) && isValidBST(root.right, root.getValue(), max);
	}

}

public class TreeValidateBSTApp {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);

		//tree1
		root.left = node3;
		node3.left = node2;
		node3.right = node4;
		root.right = node8;
		node8.left = node6;
		node8.right = node10;

		//tree2
		/*
		root.left=node1; 
		root.right=node4; 
		node4.left=node3; 
		node4.right=node6;
		 */
		Tree tree = new Tree(root);

		tree.BSF(root);
		System.out.println(tree.isValidBST(root));
        /*
         *           5 
         *         /   \   
         *        3     8
         *      /  \   /  \
         *     2    4  6   10
         *     
         * output: BST is true
         *                  
         */
		
        /*
         *           5 
         *         /   \   
         *        1     4
         *             /  \
         *             3   6
         *             
         * output: BST is false            
         *                  
         */

	}
}
