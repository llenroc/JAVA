import java.util.LinkedList;
import java.util.Queue;


/*2020-Sep-21. Oleksii Saiun. 

 * */
class Tree {

    public Node prevNode = null; 
    public void flatten(Node root) {
       if (root == null) 
    	   {
    	   return;
    	   }
        Node savedRight = root.right;  // have to save right, since right is going to be changed.
         if (prevNode != null){
             prevNode.left = null;
             prevNode.right = root;
         }

        	 prevNode = root;

         flatten(root.left);
         flatten(savedRight);
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

}

public class TreeFlattenTreeToLinkedListApp {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		root.left=node2;
		root.right=node5;
		node2.left=node3;
		node2.right=node4;
		node5.right=node6;

		Tree tree = new Tree();

		tree.BFS(root);
		tree.flatten(root);
		tree.BFS(root);


/*
    1
   / \
  2   5
 / \   \
3   4   6   
*/
		
	}

}
