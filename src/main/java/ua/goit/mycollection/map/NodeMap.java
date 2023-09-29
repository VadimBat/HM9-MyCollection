package ua.goit.mycollection.map;

public class NodeMap<K,V> {
    private K key;
    private V value;
    private NodeMap<K,V> next;

    public NodeMap(K key, V value, NodeMap<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(NodeMap<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public NodeMap<K, V> getNext() {
        return next;
    }
}
