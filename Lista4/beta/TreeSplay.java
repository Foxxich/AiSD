public class TreeSplay extends Tree {

        /** Constructor **/
        public TreeSplay()
        {
            root = null;
        }

        /** Function to check if tree is empty **/
        public boolean isEmpty()
        {
            return root == null;
        }

        /** clear tree **/
        public void clear()
        {
            root = null;
            count = 0;
        }

        /** function to insert element */
        public void insert(String ele)
        {
            counterInsert++;
            Node z = root;
            Node p = null;
            while (z != null)
            {
                p = z;
                if (ele.compareTo(p.key) > 0)
                    z = z.right;
                else
                    z = z.left;
            }
            z = new Node("");
            z.key = ele;
            z.parent = p;
            if (p == null)
                root = z;
            else if (ele.compareTo(p.key) > 0)
                p.right = z;
            else
                p.left = z;
            Splay(z);
            count++;
        }

    @Override
    public void deleteKey(String key) {

    }

    /** rotate **/
        public void makeLeftChildParent(Node c, Node p)
        {
            if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
                throw new RuntimeException("WRONG");

            if (p.parent != null)
            {
                if (p == p.parent.left)
                    p.parent.left = c;
                else
                    p.parent.right = c;
            }
            if (c.right != null)
                c.right.parent = p;

            c.parent = p.parent;
            p.parent = c;
            p.left = c.right;
            c.right = p;
        }

        /** rotate **/
        public void makeRightChildParent(Node c, Node p)
        {
            if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
                throw new RuntimeException("WRONG");
            if (p.parent != null)
            {
                if (p == p.parent.left)
                    p.parent.left = c;
                else
                    p.parent.right = c;
            }
            if (c.left != null)
                c.left.parent = p;
            c.parent = p.parent;
            p.parent = c;
            p.right = c.left;
            c.left = p;
        }

        /** function splay **/
        private void Splay(Node x)
        {
            while (x.parent != null)
            {
                Node Parent = x.parent;
                Node GrandParent = Parent.parent;
                if (GrandParent == null)
                {
                    if (x == Parent.left)
                        makeLeftChildParent(x, Parent);
                    else
                        makeRightChildParent(x, Parent);
                }
                else
                {
                    if (x == Parent.left)
                    {
                        if (Parent == GrandParent.left)
                        {
                            makeLeftChildParent(Parent, GrandParent);
                            makeLeftChildParent(x, Parent);
                        }
                        else
                        {
                            makeLeftChildParent(x, x.parent);
                            makeRightChildParent(x, x.parent);
                        }
                    }
                    else
                    {
                        if (Parent == GrandParent.left)
                        {
                            makeRightChildParent(x, x.parent);
                            makeLeftChildParent(x, x.parent);
                        }
                        else
                        {
                            makeRightChildParent(Parent, GrandParent);
                            makeRightChildParent(x, Parent);
                        }
                    }
                }
            }
            root = x;
        }

        /** function to remove element **/
        public void remove(String ele)
        {
            Node node = findNode(ele);
            remove(node);
        }

        /** function to remove node **/
        private void remove(Node node)
        {
            if (node == null)
                return;

            Splay(node);
            if( (node.left != null) && (node.right !=null))
            {
                Node min = node.left;
                while(min.right!=null)
                    min = min.right;

                min.right = node.right;
                node.right.parent = min;
                node.left.parent = null;
                root = node.left;
            }
            else if (node.right != null)
            {
                node.right.parent = null;
                root = node.right;
            }
            else if( node.left !=null)
            {
                node.left.parent = null;
                root = node.left;
            }
            else
            {
                root = null;
            }
            node.parent = null;
            node.left = null;
            node.right = null;
            node = null;
            count--;
        }

        /** Functions to count number of nodes **/
        public int countNodes()
        {
            return count;
        }

        /** Functions to search for an element **/
        public Node search(String val)
        {
            return findNode(val);
        }

        private Node findNode(String ele)
        {
            Node PrevNode = null;
            Node z = root;
            comparesSearch++;
            while (z != null)
            {
                PrevNode = z;
                comparesSearch++;
                if (ele.compareTo(z.key) > 0)
                    z = z.right;
                else if (ele.compareTo(z.key) < 0)
                    z = z.left;
                else if(ele.equals(z.key)) {
                    Splay(z);
                    return z;
                }

            }
            if(PrevNode != null)
            {
                Splay(PrevNode);
                return null;
            }
            return null;
        }

        /** Function for inorder traversal **/
        public void inorder()
        {
            inorder(root);
        }
        private void inorder(Node r)
        {
            comparesSearch++;
            if (r != null)
            {
                inorder(r.left);
                System.out.print(r.key +" ");
                inorder(r.right);
            }
        }
}
