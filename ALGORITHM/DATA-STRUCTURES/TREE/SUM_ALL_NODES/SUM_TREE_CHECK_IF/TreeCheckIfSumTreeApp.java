import java.util.LinkedList;
import java.util.Queue;

/* 2020-Aug-05. Oleksii Saiun. Check if given binary tree is sum tree
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
   An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * 
 *          26
          /   \
         10    3 
       /    \    \
      4     6     3 
     * 
     * 
     * output: true
 * */
class Tree
{
	Node root;
	public Tree(Node root)
	{
		this.root=root;	
	}
	
	public int sum(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int leftSum=sum(root.left);
		int rightSum=sum(root.right);
		
		return (root.getValue()+leftSum+rightSum);
	}
	
	public boolean checkIfSumTree(Node root)
	{
		if(root==null)
		{
			return false;
		}
		
		int leftSum=sum(root.left);
		int rightSum=sum(root.right);
		
		int sumAll=leftSum+rightSum;
	return (root.getValue() == sum(root)-root.getValue());

		
	}
 	public void BFS(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node tmp = queue.poll();
			tmp.displayValue();
			if(tmp.left!=null)
			{
				queue.offer(tmp.left);
			}
			
			if(tmp.right!=null)
			{
				queue.offer(tmp.right);
			}
		}
		System.out.println();
	}
}
public class TreeCheckIfSumTreeApp {
	public static void main(String[] args) {
    Node root = new Node(26);
    Node node10 = new Node(10);
    Node node3A = new Node(3);
    Node node3B = new Node(3);
    Node node4 = new Node(4);

    Node node6 = new Node(6);
    

    root.left=node10;
    node10.left=node4;
    node10.right=node6;

      
    root.right=node3A;
    node3A.right=node3B;
    
    /*
            26
          /   \
         10    3 
       /    \    \
      4     6     3 
     * 
     * 
     * output: true
     * 
     * 
     * 
     * */
    
    Tree tree = new Tree(root);
    tree.BFS(root);

    System.out.print(tree.checkIfSumTree(root));
	}

}
