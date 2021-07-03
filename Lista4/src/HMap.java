import java.util.ArrayList;
import java.util.List;

public class HMap {
    public static final double LOAD_FACTOR = 0.7;
    private List<HashNode<Integer,RedBlackTree>> map;
    public int comparesSearch = 0;
    public int comparesInsert = 0;
    public int comparesDelete = 0;
    public long insertTime = 0L;
    public long searchTime = 0L;
    public long deleteTime = 0L;
    private int bucketNumber = 100;
    private int actualSize = 0;
    public int counterInsert = 0;
    public int counterDelete = 0;
    public int counterSearch = 0;
    public int maxNumberOfElements = 0;
    public int currentNumberOfElements = 0;

    public HMap() {
        map = new ArrayList<>(bucketNumber);
    }

    private int hashCode(String value) {
        return value.hashCode() % bucketNumber;
    }

    public boolean search(String value) {
        counterSearch++;
        long startTime = System.nanoTime();
        RedBlackTree tree = getTreeByValue(value);
        if(tree != null) {
            if(tree.search(value) != null) {
                comparesSearch += tree.getLastOperationCompares();
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                searchTime += timeElapsed;
                return true;
            } else {
                comparesSearch += tree.getLastOperationCompares();
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                searchTime += timeElapsed;
            }
        }
        return false;
    }

    public void insert(String value) {
        counterInsert++;
        increaseCounter();
        long startTime = System.nanoTime();
        actualSize++;
        RedBlackTree treeByHashCode = getTreeByValue(value);
        if(treeByHashCode != null) {
            treeByHashCode.insert(value);
            comparesInsert += treeByHashCode.getLastOperationCompares();
        } else {
            int newHashCode = hashCode(value);
            RedBlackTree tree = new RedBlackTree();
            tree.insert(value);
            insertNewTree(newHashCode,tree);
            comparesInsert += tree.getLastOperationCompares();
        }
        checkLoadFactor();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        insertTime += timeElapsed;
    }

    private void checkLoadFactor() {
        if(actualSize/(double)bucketNumber > LOAD_FACTOR) {
            bucketNumber*=2;
            List<HashNode<Integer, RedBlackTree>> temporaryList = map;
            map = new ArrayList<>(bucketNumber);
            actualSize = 0;
            populateNewList(temporaryList);
        }
    }

    private void populateNewList(List<HashNode<Integer,RedBlackTree>> temporaryList) {
        for (HashNode<Integer, RedBlackTree> hashNode:
             temporaryList) {
            List<String> values = getValues(hashNode.value);
            for (String element:
                 values) {
                insert(element);
            }
        }
    }

    private List<String> getValues(RedBlackTree tree) {
        return tree.getAllValues();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (HashNode<Integer,RedBlackTree>node:
             map) {
            stringBuilder.append(node.toString());
        }
        stringBuilder.append("\nbucketNumber: ").append(bucketNumber);
        stringBuilder.append("\nactualSize: ").append(actualSize);
        return stringBuilder.toString();
    }

    private RedBlackTree getTreeByValue(String value) {
        int hashCode = hashCode(value);
        return getTreeByHashCode(hashCode);
    }

    public void delete(String value) {
        counterDelete++;
        decreaseCounter();
        long startTime = System.nanoTime();
        actualSize--;
        RedBlackTree treeByHashCode = getTreeByValue(value);
        if(treeByHashCode != null) {
            treeByHashCode.deleteKey(value);
            comparesDelete += treeByHashCode.getLastOperationCompares();
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        deleteTime += timeElapsed;
    }

    public RedBlackTree getTreeByHashCode(int hashCode) {
        HashNode<Integer, RedBlackTree> node = getNodeByHashCode(hashCode);
        if(node != null) {
            return node.getValue();
        }
        return null;
    }

    public HashNode<Integer, RedBlackTree> getNodeByHashCode(int hashCode) {
        for (HashNode<Integer,RedBlackTree> element:
             map) {
            if(element.getKey() == hashCode) {
                return element;
            }
        }
        return null;
    }

    public void insertNewTree(int hashCode, RedBlackTree tree) {
        HashNode<Integer,RedBlackTree> node = new HashNode<>(hashCode,tree);
        map.add(node);
    }

    public int getActualSize() {
        return actualSize;
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
}
