import java.util.LinkedList;
import java.util.Queue;

/*Oleksii Saiun. 2020-Aug-27. [FIND ALL NODES AT GIVEN DISTANCE FROM LEAF NODES]
    /*             15
     *           /     \
     *         10       20
     *        /  \     /   \
     *       8    12  16   25
     *                /
     *              18
     * 
     *  distance 1:
     *  out: 10 10 16 20 
     *  
     *  distance 2:
     *  out: 15 15 20 15 
     *  
     *  distance 3:
     *  out: 15
     * 
     * 

      * */

class Tree {
    
	private LinkedList<Integer> path = new LinkedList<>();
	
	public void printPath(LinkedList<Integer> path, int distance)
	{
		if (distance<=path.size())
		{
			int index=0;
			for(int j=path.size()-1;j>=0;j--)
			{
			   if (index==distance)
			   {
					System.out.print(path.get(j)+" ");
			   }
			   index=index+1;
			}

		}

	}
	
	public void printPathAll(LinkedList<Integer> path)
	{
     for(int index=path.size()-1;index>=0;index--)
			{
					System.out.print(path.get(index)+" ");

			}
			System.out.println();
		

	}
	
	public boolean findLeaf(Node root, int distance)
	{
		if(root==null)
		{
			return false;
		}
		
		path.add(root.getValue());
		
		if (root.left==null && root.right==null)
		{
			printPath(path,distance);
		//	printPathAll(path);
	//		return true;
		}
		
		if(findLeaf(root.left,distance) || findLeaf(root.right,distance))
		{

			return true;
		}
		path.removeLast();
		return false;
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
}

public class TreefindAllNodesAtGivenDistanceFromLeaf_App {
	public static void main(String[] args) {
    Node root = new Node(15);
    Node node8 = new Node(8);
    Node node10 = new Node(10);
    Node node12 = new Node(12);
    Node node16 = new Node(16);
    Node node18 = new Node(18);
    Node node20 = new Node(20);
    Node node25 = new Node(25);
		
    root.left=node10;
    node10.left=node8;
    node10.right=node12;
    
    root.right = node20;
    node20.left=node16;
    node20.right=node25;
    node16.left=node18;
    
    Tree tree = new Tree();
    tree.BSF(root);
    tree.findLeaf(root,3);
    
    
    
    
    /*             15
     *           /     \
     *         10       20
     *        /  \     /   \
     *       8    12  16   25
     *                /
     *              18
     * 
     *  distance 1:
     *  out: 10 10 16 20 
     *  
     *  distance 2:
     *  out: 15 15 20 15 
     *  
     *  distance 3:
     *  out: 15
     * 
     * 
     * */
    
    
    
		
	}

}
