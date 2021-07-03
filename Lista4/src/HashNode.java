public class HashNode<K, V> {
    K key;
    V value;

    public HashNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        if(value != null)
            return "\nKey: " + key.toString() + "\n" + "Value: " +value.toString() + "\n";
        else
            return "\nKey: " + key.toString() + "\n";
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}