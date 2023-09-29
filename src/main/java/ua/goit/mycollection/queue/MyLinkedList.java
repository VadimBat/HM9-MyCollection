package ua.goit.mycollection.queue;

import java.util.StringJoiner;

public class MyLinkedList<T> {
    private Node<T> head;

    public void add(T value){
        Node<T> node = new Node<>();
        node.setValue(value);
        if(head == null){
            head = node;
        } else {
            Node<T> last = head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(node);
        }
    }
    public T remove(int index){
        if (head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node<T> temporaryElement = head;
        Node<T> removeElement = head;
        for (int i = 0; i < index; i++) {
            removeElement = removeElement.getNext();
            if (removeElement == null){
                throw new IndexOutOfBoundsException("Incorrect index = " + index + ", size = " + size());
            }
        }
        for (int i = 0; i < index-1; i++) {
            temporaryElement = temporaryElement.getNext();
            if (temporaryElement == null){
                throw new IndexOutOfBoundsException("Incorrect index = " + index + ", size = " + size());
            }
        }
        temporaryElement.setNext(temporaryElement.getNext().getNext());
        return removeElement.getValue();
    }

    public void clear(){
        Node<T> last = head;
        while(last.getNext() != null){
            last = last.getNext();
        }
        last = head = null;
    }

    public int size(){
        if (head == null){
            return 0;
        }
        int count = 1;
        Node<T> last = head;
        while(last.getNext() != null){
            last = last.getNext();
            count++;
        }
        return count;
    }

    public T get(int index){
        if (head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();
            if (search == null){
                throw new IndexOutOfBoundsException("Incorrect index = " + index + ", size = " + size());
            }
        }
        return search.getValue();
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        Node<T> last = head;
        while(last != null){
            result.add(last.getValue().toString());
            last = last.getNext();
        }
        String res = "[" + result.toString() + "]";
        return res;
    }
}
