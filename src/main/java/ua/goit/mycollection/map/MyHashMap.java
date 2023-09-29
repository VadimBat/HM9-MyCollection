package ua.goit.mycollection.map;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyHashMap<K,V> {
    private NodeMap<K,V>[] data;
    private static final int COLLECTION_SIZE = 8;
    private int size;
    private int capacity;
    private int hashIndex;

    public MyHashMap() {
        data = new NodeMap[COLLECTION_SIZE];
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        data = new NodeMap[capacity];
    }

    public void put(K key, V value){
        hashIndex = hash(key);
        NodeMap<K,V> newNode = new NodeMap<>(key,value,null);
        if (hashIndex < 0 || hashIndex > COLLECTION_SIZE){
            throw new IndexOutOfBoundsException("Out of bucket");
        }
        NodeMap<K,V> node = data[hashIndex];
        while(node != null){
            if (node.getKey().equals(key)){
                node.setValue(value);
                break;
            }
            node = node.getNext();
        }
        newNode.setNext(data[hashIndex]);
        data[hashIndex] = newNode;
        size++;
    }

    public void remove(K key){
        hashIndex = hash(key);
        if (hashIndex < 0 || hashIndex > COLLECTION_SIZE){
            throw new IndexOutOfBoundsException("Out of bucket");
        }
        NodeMap<K,V> previous = null;
        NodeMap<K,V> last = data[hashIndex];
        while(last != null){
            if (last.getKey().equals(key)){
                if (previous == null){
                    last = last.getNext();
                    data[hashIndex] = last;
                } else {
                    previous.setNext(last.getNext());
                }
                size--;
                return;
            }
            previous = last;
            last = last.getNext();
        }
    }

    public V get(K key){
        V value = null;
        hashIndex = hash(key);
        if (hashIndex < 0 || hashIndex > COLLECTION_SIZE){
            throw new IndexOutOfBoundsException("Out of bucket");
        }
        NodeMap<K,V> last = data[hashIndex];
        while(last != null){
            if (last.getKey().equals(key)){
                value = last.getValue();
                break;
            }
            last = last.getNext();
        }
        return value;
    }

    public void clear(){
        Arrays.fill(data,null);
        size = 0;
    }

    public int size(){
        return size;
    }

    private int hash(K key) {
        if (key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % COLLECTION_SIZE);
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("");
        for (int i = 0; i < COLLECTION_SIZE; i++) {
                NodeMap<K, V> node = data[i];
                while (node != null) {
                    result.add("{" + node.getKey() + " = " + node.getValue() + "}" + " ");
                    node = node.getNext();
                }
        }
        return result.toString();
    }
}
