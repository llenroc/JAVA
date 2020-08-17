import java.util.LinkedList;
import java.util.Queue;

/*2020-Jul-03. Oleksii Saiun. Find All path from root leave nodes
 * 
 * */


class Tree {
    private Node node;

    public Tree(Node node) {
        this.node = node;
    }

    public void BFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.print(tmp.getValue() + " ");

            if (tmp.left != null) {
                queue.offer(tmp.left);
            }

            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }

    public void printAllPath(Node root)
    {
    	findLeaveNodes(root, root);
    }
    
    private void findLeaveNodes(Node root, Node nodeLeave)
    {
    	if(nodeLeave==null)
    	{
    		return;
    	}
    	
    	if(nodeLeave.left==null && nodeLeave.right==null)
    	{
    		findPath(root, nodeLeave);
    		System.out.println();
    	}
    	
    	findLeaveNodes(root, nodeLeave.left);
    	findLeaveNodes(root, nodeLeave.right);
    }
    private boolean findPath(Node root, Node keyNode)
    {
    	if(root==null)
    	{
    		return false;
    	}
    	
    	if(root.getValue()==keyNode.getValue())
    	{
    		root.displayValue();
    		return true;
    	}
    	
    	if (findPath(root.left,keyNode))
    	{
    		root.displayValue();
    		return true;
    	}
    	

    	if (findPath(root.right,keyNode))
    	{
    		root.displayValue();
    		return true;
    	}
    	
return false;
    }

}

public class TreeAllPathFromLeaveToRootApp {

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node3 = new Node(3);
        Node node10 = new Node(10);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node16 = new Node(16);
        Node node17 = new Node(17);

        root.left = node3;
        root.right = node10;
        node3.left = node2;
        node10.left = node8;
        node10.right = node16;
        node2.left = node1;
        node16.left=node17;
        node16.right=node0;
        Tree tree = new Tree(root);
        
        tree.BFS(root);
        System.out.println();
        tree.printAllPath(root);

        /*
         *           9 
         *        3     10 
         *      2     8     16
         *    1           17   0
         *  
         */
    }

}
