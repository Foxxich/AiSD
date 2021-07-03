public class Node {
    String key;
    Node left, right,parent;
    int color;

    public Node(String item)
    {
        key = item;
        left = right = null;
    }

    public Node(String item, int nodeColor)
    {
        this.key = item;
        this.color = nodeColor;
    }
}
