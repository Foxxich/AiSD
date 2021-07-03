abstract class Tree implements TreeController {

    Node root;
    Node left, right;
    static Node pre;
    static Node suc;
    int counterInsert = 0;
    int counterDelete = 0;
    int counterInorder = 0;
    int maxNumberOfElements = 0;
    int currentNumberOfElements = 0;
    long insertTime = 0L;
    long inorderTime = 0L;
    long deleteTime = 0L;
    int comparesInsert = 0;
    int comparesDelete = 0;
    int comparesSearch = 0;
    int comparesMax = 0;
    int comparesMin = 0;
    int comparesSuc = 0;
    int count = 0;
    int lastNumberOfCompares = 0;

    @Override
    public Node search(String key) {
        lastNumberOfCompares = -comparesSearch;
        // Base Cases: root is null or key is present at root
        if(iterativeSearch(root,key)){
            lastNumberOfCompares += comparesSearch;
            return root;
        } else {
            lastNumberOfCompares += comparesSearch;
            return null;
        }
    }

    // Function to check the given key exist or not
    boolean iterativeSearch(Node root, String key)
    {
        // Traverse until root reaches to dead end
        comparesSearch++;
        while (root != null) {
            // pass right subtree as new tree
            comparesSearch++;
            if (key.compareTo(root.key) > 0) {
                root = root.right;
            }
            else {
                comparesSearch++;
                if (key.compareTo(root.key) < 0) {
                    root = root.left;
                }
                else {
                    return true; // if the key is found return 1
                }
            }
        }
        return false;
    }

    @Override
    public String findPreSuc(Node root, String key) {
        comparesSuc++;
        // Base case
        if (root == null)
            return suc.key;

        // If key is present at root
        if (root.key.equals(key))
        {

            // The maximum value in left
            // subtree is predecessor
            if (root.left != null)
            {
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            // The minimum value in
            // right subtree is successor
            if (root.right != null)
            {
                Node tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return suc.key;
        }

        // If key is smaller than
        // root's key, go to left subtree
        if (root.key.compareTo(key) > 0)
        {
            suc = root;
            findPreSuc(root.left, key);
        }

        // Go to right subtree
        else
        {
            pre = root;
            findPreSuc(root.right, key);
        }

        return suc.key;
    }

    @Override
    public String maxValueTree(Node node) {
        comparesMax++;
        /* loop down to find the rightmost leaf */
        while (node.right != null) {
            node = node.right;
        }
        return (node.key);
    }

    @Override
    public String minValueTree(Node node) {
        comparesMin++;
        /* loop down to find the leftmost leaf */
        while (node.left != null) {
            node = node.left;
        }
        return (node.key);
    }

    protected void increaseCounter(){
        currentNumberOfElements++;
        if(currentNumberOfElements > maxNumberOfElements) {
            maxNumberOfElements = currentNumberOfElements;
        }
    }

    protected void decreaseCounter(){
        currentNumberOfElements--;
    }

    public int getLastOperationCompares() {
        return lastNumberOfCompares;
    };
}
