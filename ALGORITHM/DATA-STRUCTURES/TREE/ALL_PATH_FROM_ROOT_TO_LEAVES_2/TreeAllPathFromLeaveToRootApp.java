import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-17. Oleksii Saiun. Find All path from root leave nodes
 * 
 * The second approach. It's more efficient compared to the approach:
 * https://github.com/oleksiisaiun/JAVA/tree/master/ALGORITHM/DATA-STRUCTURES/TREE/ALL_PATH_FROM_ROOT_TO_LEAVES_1
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

        Queue<Node> queue = new LinkedList<>();
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

    LinkedList<Node> path = new LinkedList<>();
    
    public void printPath(LinkedList<Node> path)
    {
    	for(Node n : path)
    	{
    		n.displayValue();
    	}
    	System.out.println();
    }
    
    public void printAllPath(Node root)
    {
    	if (root==null)
    	{
    		return;
    	}
    	
    	path.add(root);
    	
    	if(root.left==null&&root.right==null)
    	{
    		printPath(path);
    		return;
    	}  	
    
    	printAllPath(root.left);
    	printAllPath(root.right);
    	path.removeLast();
    	return;
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
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node16 = new Node(16);
        Node node17 = new Node(17);

        root.left = node3;
        root.right = node10;
        node3.left = node2;
        node10.left = node8;
        node10.right = node16;
        node2.left = node1;
        node2.right=node6;
        node6.right=node4;
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
         *    1   6       17   0
         *          4
         */
    }

