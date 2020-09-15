import java.util.LinkedList;
import java.util.Queue;



/*
2020-Sep-14. Oleksii Saiun.
LeetCode_#530. Minimum Absolute Difference in BST
https://leetcode.com/problems/minimum-absolute-difference-in-bst/

       27
         \
         34
          \
          58
          /
         50
        /
       44
       
out: min dist: [6=50-44]       
*/



class Tree {
	Node node;
	private LinkedList<Integer> list = new LinkedList<>();

	public Tree() {
	}

	public int minDiffInBST(Node root) {
		if (root == null) {
			return 0;
		}

		inOrder(root);
		
		int minDist = Integer.MAX_VALUE;
		for (int j = 0; j < list.size()-1; j++) {
			int currentMin = list.get(j+1) - list.get(j);
			minDist = Math.min(minDist, currentMin);
		}

		return minDist;
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root.getValue());
		inOrder(root.right);
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

public class TreeMinimumAbsoluteDistanceBSTApp {
	public static void main(String[] args) {
		Node root = new Node(27);
		Node node34 = new Node(34);
		Node node58 = new Node(58);
		Node node50 = new Node(50);
		Node node44 = new Node(44);
		root.right = node34;
		node34.right = node58;
		node58.left = node50;
		node50.left = node44;

		Tree tree = new Tree();
		tree.BFS(root);
		System.out.println(tree.minDiffInBST(root));

		/*
		 * 
       27
         \
         34
          \
          58
          /
         50
        /
       44
       
       in order
       27 34 44 50 58 
       
         * 
         * 
		 * 
		 * 
		 * */			
	
	}

}
