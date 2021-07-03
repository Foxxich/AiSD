interface TreeController {

    public void inorder();

    public void insert(String key);

    public void deleteKey(String key);

    Node search(String key);

    String findPreSuc(Node root, String key);

    String maxValueTree(Node node);

    String minValueTree(Node node);
}
