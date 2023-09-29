package ua.goit.mycollection.queue;

import java.util.StringJoiner;

public class MyQueue<T> {
    private static final int COLLECTION_SIZE = 8;
    private Object[] data;
    private int size;

    public MyQueue(){
        data = new Object[COLLECTION_SIZE];
    }
    public void add(T value){
        resize();
        if (value == null){
            throw new NullPointerException("Incorrect values, value = " + value + ", size = " + size);
        }
        data[size] = value;
        size++;
    }

    private void resize() {
        if (size == data.length){
            System.out.println("Resize happened, index: " + size + ", data.length: " + data.length);
            int newSize = data.length*2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
        }
    }
    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
    public int size(){
        return size;
    }

    public T peek(){
        return (T) data[0];
    }

    public T poll(){
        Object toRemove = data[0];
        System.arraycopy(data,1,data,0,data.length-1);
        size--;
        return (T) toRemove;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]" ;
    }
}
