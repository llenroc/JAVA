import java.util.LinkedList;
import java.util.Queue;

/*2020-Jul-03. Oleksii Saiun
 * Find a height of binary tree
 * It's implemented by 2 ways: recursive and iterative    
 
 2020-Aug-15. Oleksii Saiun
 add Unit tests
 * 
 * */

class Node {
    private int value;
    Node left;
    Node right;

    public Node(int value) {
        super();
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

class Tree {
    private Node node;

    public Tree(Node node) {
        this.node = node;
    }

//------------------------------
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

    public int calcHeightOfTreeIterative(Node root) {
        int height = 0;

        if (root == null) {
            height = 0;
        }

        Queue<Node> queue = new LinkedList();
        Node dummyNode = new Node(Integer.MIN_VALUE);
        queue.offer(node);
        queue.offer(dummyNode);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.getValue() == Integer.MIN_VALUE) {
                height++;
                if (!queue.isEmpty()) {
                    queue.offer(dummyNode);
                }
            }

            if (tmp.left != null) {
                queue.offer(tmp.left);
            }

            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }

        return height;
    }

    // -----------------------------------------

    public int calcHeightOfTreeRecurs(Node root)

    {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = calcHeightOfTreeRecurs(root.left);
            int rightDepth = calcHeightOfTreeRecurs(root.right);

            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else

                return (rightDepth + 1);
        }

    }
    // -----------------------------------------

}

public class BinaryTree_Height {

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node3 = new Node(3);
        Node node10 = new Node(10);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node16 = new Node(16);

        root.left = node3;
        root.right = node10;
        node3.left = node2;
        node10.left = node8;
        node10.right = node16;
        node2.left = node1;
        Tree tree = new Tree(root);

        tree.BFS(root);
        System.out.println();
        System.out.println("Height Recursive:" + tree.calcHeightOfTreeRecurs(root));
        System.out.println("Height Iterative:" + tree.calcHeightOfTreeIterative(root));

        /*
         *           9 
         *        3     10 
         *      2     8   16
         *    1   
         *  
         */
    }

}
