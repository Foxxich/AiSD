import java.util.Stack;

public class BinarySearchTree extends Tree{

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    @Override
    public void insert(String key)
    {
        counterInsert++;
        increaseCounter();
        long startTime = System.nanoTime();
        Node newNode = new Node(key);
        root = insertNode(root,newNode);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        insertTime += timeElapsed;
    }

    public Node insertNode(Node root, Node node) {
        if (root == null)
            return node;
        Node curr = root;
        comparesInsert++;
        while (true) {
            if (node.key.compareTo(curr.key) < 0) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = node;
                    break;
                }
            } else if (node.key.compareTo(curr.key) > 0) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = node;
                    break;
                }
            } else {
                curr.key = node.key;
                break;
            }
        }
        return root;
    }

    // This method mainly calls InorderRec()
    @Override
    public void inorder()
    {
        counterInorder++;
        long startTime = System.nanoTime();
        inorderPrint();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        inorderTime += timeElapsed;
    }

    void inorderPrint()
    {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        while (curr != null || s.size() > 0)
        {
            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.key + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
    // This method mainly calls deleteRec()
    @Override
    public void deleteKey(String key) {
        counterDelete++;
        decreaseCounter();
        long startTime = System.nanoTime();
        root = deleteRec(root, key);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        deleteTime += timeElapsed;
    }

    /* A recursive function to
      delete an existing key in BST
     */
    Node deleteRec(Node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return null;

        /* Otherwise, recur down the tree */
        comparesDelete+=2;
        if (key.compareTo(root.key) < 0) {
            comparesDelete--;
            root.left = deleteRec(root.left, key);
        }
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    String minValue(Node root)
    {
        String minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
