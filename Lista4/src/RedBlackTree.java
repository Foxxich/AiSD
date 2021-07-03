import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RedBlackTree extends Tree {
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node("");
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;

    }

    // Inorder
    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            try {
                FileWriter myWriter;
                myWriter = new FileWriter("inorder.txt", true);
                myWriter.write(node.key+"\n");
                myWriter.close();
            } catch (NullPointerException | IOException e) {
                System.err.println("Problems with tree");
            }
            inOrderHelper(node.right);
        }
    }

    // Balance the tree after deletion of a node
    private void fixDelete(Node x) {
        Node s;
        comparesDelete++;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void rbTransplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNodeHelper(Node node, String key) {
        Node z = TNULL;
        Node x, y;
        comparesDelete++;
        while (node != TNULL) {
            if (node.key.equals(key)) {
                z = node;
            }
            if (node.key.compareTo(key) <= 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }
        y = z;
        int yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    // Balance the node after insertion
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    @Override
    public void inorder() {
        counterInorder++;
        long startTime = System.nanoTime();
        inOrderHelper(this.root);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        inorderTime += timeElapsed;
    }

    public Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    public Node maximum(Node node) {
        while (node.right != TNULL) {
            node = node.right;
        }
        return node;
    }

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    @Override
    public void insert(String key) {
        lastNumberOfCompares = -comparesInsert;
        counterInsert++;
        increaseCounter();
        long startTime = System.nanoTime();
        Node node = new Node("");
        node.parent = null;
        node.key = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; //red

        Node y = null;
        Node x = this.root;
        comparesInsert++;
        while (x != TNULL) {
            y = x;
            comparesInsert++;
            if (node.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key.compareTo(y.key) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }
        if (node.parent == null) {
            node.color = 0; //black
        } else if(node.parent.parent != null) {
            fixInsert(node);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        insertTime += timeElapsed;
        lastNumberOfCompares += comparesInsert;
    }

    public Node getRoot() {
        return this.root;
    }

    @Override
    public void deleteKey(String key) {
        counterDelete++;
        decreaseCounter();
        lastNumberOfCompares = -comparesDelete;
        long startTime = System.nanoTime();
        deleteNode(key);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        lastNumberOfCompares += comparesDelete;
        deleteTime += timeElapsed;
    }

    public void deleteNode(String data) {
        lastNumberOfCompares = -comparesDelete;
        deleteNodeHelper(this.root, data);
        lastNumberOfCompares += comparesDelete;
    }

    @Override
    public String maxValueTree(Node node) {
        comparesMax++;
        /* loop down to find the rightmost leaf */
        while (node.right != TNULL) {
            node = node.right;
        }
        return (node.key);
    }

    @Override
    public String minValueTree(Node node) {
        comparesMin++;
        /* loop down to find the leftmost leaf */
        while (node.left != TNULL) {
            node = node.left;
        }
        return (node.key);
    }

    @Override
    public String toString() {
        return inorderString();
    }

    public String inorderString() {
        StringBuilder stringBuilder = new StringBuilder();
        return inorderString(root, stringBuilder).toString();
    }

    public StringBuilder inorderString(Node node, StringBuilder stringBuilder) {
        if (node != TNULL) {
            inorderString(node.left, stringBuilder);
            stringBuilder.append("\n").append(node.key);
            inorderString(node.right, stringBuilder);
        }
        return stringBuilder;
    }

    public List<String> getAllValues() {
        List<String> list = new LinkedList<>();
        return getAllValues(root, list);
    }

    private List<String> getAllValues(Node node, List<String> list) {
        if (node != TNULL) {
            getAllValues(node.left, list);
            list.add(node.key);
            getAllValues(node.right, list);
        }
        return list;
    }
}
