import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-24. Oleksii Saiun. Construct Binary Search Tree from a sorted array

•	Root is a middle element of sorted array
•	We need to use middle element, otherwise, BST will be not balanced

 * */
class Tree {
	Node node;

	public Tree() {
	}

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

	public Node createBSTfromArray(int[] arr) {

		return createBSTfromArray(arr, 0, arr.length-1);
	}

	public Node createBSTfromArray(int[] arr, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		int mid = (startIndex + endIndex) / 2;
        Node node = new Node(arr[mid]);
	
        node.left = createBSTfromArray(arr, startIndex, mid-1);
        node.right = createBSTfromArray(arr, mid+1, endIndex);
		return node;
	}
}

public class TreeConstructBSTfromArrayApp {

	public static void main(String[] args) {

		Tree tree = new Tree();
		int arr [] = {1,2,3,4,5,6,7,8,9};
		Node root=tree.createBSTfromArray(arr);
		tree.BSF(root);
/*		
		int [] = {1,2,3,4,5,6,7,8,9}

          5
		/   \  
	   2     7
      / \   /  \
     1   3  6 	8
          \      \	 
	       4 	  9
*/		   
	}

}
