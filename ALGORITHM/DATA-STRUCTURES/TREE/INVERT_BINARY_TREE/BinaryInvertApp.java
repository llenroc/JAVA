import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-19. Oleksii Saiun. Invert Binary Tree
 * 
 * 
         * before:
         *           9 
         *        3       10 
         *      2   11    8   16
         *    1   0
         *  
         * after: 
         *           9 
         *        10      3 
         *      16   8    11  2
         *                  0   1
         *                  
 * */


class Tree {
    private Node node;

    public Tree(Node node) {
        this.node = node;
    }

    public void invertBinaryTree(Node root)
    {
        if (root == null) {
            return;
        }
              
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        
        //swap
        Node tmp = root.left;
        root.left=root.right;
        root.right=tmp;
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

}

public class BinaryInvertApp {

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node3 = new Node(3);
        Node node10 = new Node(10);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node11 = new Node(11);
        Node node16 = new Node(16);

        root.left = node3;
        root.right = node10;
        node3.left = node2;
        node3.right = node11;
        node10.left = node8;
        node10.right = node16;
        node2.left = node1;
        node2.right=node0;
        Tree tree = new Tree(root);

        tree.BFS(root);
        System.out.println();
        tree.invertBinaryTree(root);
        tree.BFS(root);


        /*
         * before:
         *           9 
         *        3       10 
         *      2   11    8   16
         *    1   0
         *  
         * after: 
         *           9 
         *        10      3 
         *      16   8    11  2
         *                  0   1
         *  
         *  
         */
    }

}
