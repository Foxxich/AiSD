public class SplayTree extends Tree{

        SplayTree(){
            root = null;
            left = null;
            right = null;
        }

        public void put(String key) {
            // splay key to root
            if (root == null) {
                root = new Node(key);
                return;
            }

            root = splay(root, key);

            int cmp = key.compareTo(root.key);

            // Insert new node at root
            Node n = new Node(key);
            comparesInsert++;
            if (cmp < 0) {
                n.left = root.left;
                n.right = root;
                root.left = null;
            }

            // Insert new node at root
            else {
                n.right = root.right;
                n.left = root;
                root.right = null;
            }
            root = n;

        }

        public Node remove(String key) {
            if (root == null) return null; // empty tree
            Node temp;
            root = splay(root, key);

            comparesDelete++;
            if(!key.equals(root.key)){
                return root;
            }

            if(root.left == null) {
                temp = root;
                root = root.right;
            } else {
                temp = root;
                root = splay(root.left,key);
                root.right = temp.right;
            }
            return root;

            // else: it wasn't in the tree to remove
        }

        private Node splay(Node h, String key) {
            if (h == null) return null;

            int cmp1 = key.compareTo(h.key);

            if (cmp1 < 0) {
                // key not in tree, so we're done
                if (h.left == null) {
                    return h;
                }
                int cmp2 = key.compareTo(h.left.key);
                if (cmp2 < 0) {
                    h.left.left = splay(h.left.left, key);
                    h = rotateRight(h);
                }
                else if (cmp2 > 0) {
                    h.left.right = splay(h.left.right, key);
                    if (h.left.right != null)
                        h.left = rotateLeft(h.left);
                }

                if (h.left == null) return h;
                else                return rotateRight(h);
            }

            else if (cmp1 > 0) {
                // key not in tree, so we're done
                if (h.right == null) {
                    return h;
                }

                int cmp2 = key.compareTo(h.right.key);
                if (cmp2 < 0) {
                    h.right.left  = splay(h.right.left, key);
                    if (h.right.left != null)
                        h.right = rotateRight(h.right);
                }
                else if (cmp2 > 0) {
                    h.right.right = splay(h.right.right, key);
                    h = rotateLeft(h);
                }

                if (h.right == null) return h;
                else                 return rotateLeft(h);
            }

            else return h;
        }

        // height of tree (1-node tree has height 0)
        public int height() { return height(root); }
        private int height(Node x) {
            if (x == null) return -1;
            return 1 + Math.max(height(x.left), height(x.right));
        }


        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            else return 1 + size(x.left) + size(x.right);
        }

        // right rotate
        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            return x;
        }

        // left rotate
        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            return x;
        }

    @Override
    public void inorder()
    {
        counterInorder++;
        long startTime = System.nanoTime();
        inorderRec(root);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        inorderTime += timeElapsed;
    }

    @Override
    public void insert(String key) {
        long startTime = System.nanoTime();
        counterInsert++;
        increaseCounter();
        put(key);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        insertTime += timeElapsed;
    }

    @Override
    public void deleteKey(String key) {
        counterDelete++;
        decreaseCounter();
        long startTime = System.nanoTime();
        remove(key);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        deleteTime += timeElapsed;
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    }
