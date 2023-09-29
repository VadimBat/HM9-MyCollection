package ua.goit.mycollection.list;

import java.util.StringJoiner;

public class MyArrayList <T> {
    private static final int COLLECTION_SIZE = 8;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[COLLECTION_SIZE];
    }

    public void add(T value){
        resize();
        data[size] = value;
        size++;
    }

    private void resize() {
        if(size == data.length){
            System.out.println("Resize happened, index: " + size + ", data.length: " + data.length);
            int newSize = data.length*2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data,0,newData,0, data.length);
            data = newData;
        }
    }

    public T remove(int index){
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

    public T get(int index){
        return (T) data[index];
    }


    @Override
    public String toString() {
        StringJoiner resultData = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            resultData.add(data[i].toString());
        }
        return "[" + resultData + "]";
    }
}
