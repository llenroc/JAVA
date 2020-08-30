
import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-29. Oleksii Saiun. Count unival subtree

[Unival tree]=[Univalued tree] is a tree where each node have the same values
Example
1)
 5
 result: true
 
2)
     5
    /  \
   5    5
 result: true 
 
3)
     5
       \
        5
 result: true  
4)
     5
   /   \
  2     5
 result: false   
 (!) Simple, but tricky implementation
  The solution is based on visa verse(!):
------
          if (root==null)
        {
            return true;
        }
------        

*/
class Tree {
	Node node;

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

	public boolean isUnival(Node root, int key) {
		if (root == null) {
			return true;
		}

		boolean univalLeft = isUnival(root.left, key);
		boolean univalRight = isUnival(root.right, key);

		if (root.getValue() != key) {
			return false;
		}

		return univalLeft && univalRight;

	}
	
	public boolean isUnival(Node root) {
		if (root == null) {
			return true;
		}
		return isUnival(root,root.getValue());
	}
	
}

public class TreeCheckIfUnivalTreeApp {

	public static void main(String[] args) {
		Node root = new Node(0);
		Node node0_A = new Node(0);
		Node node0_B = new Node(0);

		root.left = node0_A;
		root.right=node0_B;
		
		Tree tree = new Tree(root);
		tree.BSF(root);

		System.out.println(tree.isUnival(root));

/**
 *      0
 *    /  \ 
 *   0    0 
 *  output: true
 * 
 */

	}

}
