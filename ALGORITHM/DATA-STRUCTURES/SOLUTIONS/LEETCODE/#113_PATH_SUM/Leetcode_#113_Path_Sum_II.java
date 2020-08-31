import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*2020-Aug-31. Oleksii Saiun. [Path Sum2]
LeetCode_#113.
  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
   https://leetcode.com/problems/path-sum-ii/submissions/
                   5
                  / \
                 4   8
                /   / \
               11  13  4
              /  \   /  \
            7     2  5   1
             
             input = [22]
             output: two ways
                     [5->4->11->2]=22
                     [5->8->4->5]=22
 * 
 * */
class Tree {
	Node node;
    private LinkedList<Integer> path = new LinkedList<Integer>();
    private List<List<Integer>> listAllPath = new LinkedList<>();
    
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


    public List<List<Integer>> pathSum(Node root, int sum) {
        findPath(root, sum);
        return listAllPath;
    }
    
    private int sumElementsOfPAth(List<Integer> path)
    {
        int sumOut=0;
        
        for (int j=0; j<path.size(); j++)
        {
            sumOut = sumOut + path.get(j);
        }
        return sumOut;
    }
    
    public void findPath(Node root, int sumInput)
    {
        if (root==null)
        {
            return;
        }
        
        path.addLast(root.getValue());
        
        if(root.left==null && root.right==null )
        {
            if(sumInput == sumElementsOfPAth(path))
            {
            	LinkedList<Integer> newList = new LinkedList<Integer>();
            	newList.addAll(path);            	
                listAllPath.add(newList);
            }
        }
        
        findPath(root.left, sumInput);
        findPath(root.right, sumInput);
        path.removeLast();
        
        return;
    }
}

public class TreePathSum1App {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4_A = new Node(4);
		Node node4_B = new Node(4);
		Node node5_A = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node13 = new Node(13);

		Tree tree = new Tree(root);
		root.left = node4_A;
		root.right = node8;
		node4_A.left = node11;
		node11.left = node7;
		node11.right = node2;

		node8.left = node13;
		node8.right = node4_B;
		node4_B.left= node5_A;
		node4_B.right = node1;

		tree.BSF(root);
		
		System.out.println(tree.pathSum(root, 22));

/*

                5
               / \
              4   8
             /   / \
            11  13  4
           /  \    / \
          7    2  5   1
             
             input = [22]
             output: true [5->4->11->2]=22

 */

	}
}
