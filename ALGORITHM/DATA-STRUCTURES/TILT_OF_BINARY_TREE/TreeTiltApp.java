import java.util.LinkedList;
import java.util.Queue;



/*
2020-Sep-15. Oleksii Saiun.
Given a binary tree, return the tilt of the whole tree.
https://leetcode.com/problems/binary-tree-tilt/

The tilt of a tree node is defined as the absolute difference between the 
sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1  
*/



class Tree {
	Node node;
	private LinkedList<Integer> list = new LinkedList<>();

	public Tree() {
	}
    int totalOfTilts=0;
    public int findTilt(Node root) {
        postOrder(root);
        return totalOfTilts;
    }
    
    
    public int postOrder(Node root)
    {
        if (root==null)
        {
            return 0;
        }
        
        int sumOfleftSide=postOrder(root.left);
        int sumOfrightSide=postOrder(root.right);
        
        int tilt=0;
        if (root.left!=null && root.right!=null)
        {
            tilt=Math.abs(sumOfleftSide - sumOfrightSide);
        }
         else if (root.left!=null && root.right==null)
         {
             tilt=Math.abs(sumOfleftSide);
         }
        else if (root.left==null && root.right!=null)
         {
             tilt=Math.abs(sumOfrightSide);
         }

        totalOfTilts = totalOfTilts + tilt;
        int sumOfNodes=root.getValue() + sumOfleftSide + sumOfrightSide;
        System.out.println("sumOfNodes:"+sumOfNodes+"; totalOfTilts:"+totalOfTilts);
        list.add(totalOfTilts);
        return sumOfNodes;
        
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

public class TreeTiltApp {
	public static void main(String[] args) {
		Node root = new Node(-8);
		Node node0 = new Node(0);
		Node node3 = new Node(3);
		Node node8_neg = new Node(-8);
		Node node8 = new Node(8);
		Node node1_neg = new Node(-1);
		root.left=node3;
		root.right = node0;
		node3.left = node8_neg;
		node8_neg.right=node1_neg;
		node1_neg.right=node8;
		


		Tree tree = new Tree();
		tree.BFS(root);
		System.out.println("tilt: "+tree.findTilt(root));
		

		/*
		 * 
       -8
      /  \
     3    0
    /
  -8
    \
    -1
      \
       8

   
sumOfNodes:7; totalOfTilts:8   
sumOfNodes:8; totalOfTilts:0


		 * */			
	
	}

}
