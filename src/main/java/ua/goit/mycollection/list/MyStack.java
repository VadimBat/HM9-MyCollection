package ua.goit.mycollection.list;

import java.util.StringJoiner;

public class MyStack<T> {
    private static final int COLLECTION_SIZE = 8;
    private Object[] data;
    private int size;

    public MyStack(){
        data = new Object[COLLECTION_SIZE];
    }

    public void push(T value){
        resize();
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

    public T remove(int index){
        if(index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("Incorrect index: index = " + index + ", size = " + size);
        }
        Object element = data[index];
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        size--;
        return (T) element;
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
        return (T) data[size-1];
    }

    public T pop(){
        T toRemove = (T) data[size-1];
        Object[] newData = new Object[data.length-1];
        System.arraycopy(data,0, newData,0, data.length-1);
        data = newData;
        size--;
        return toRemove;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }
}
