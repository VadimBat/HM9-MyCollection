package ua.goit.mycollection;

import ua.goit.mycollection.list.MyArrayList;
import ua.goit.mycollection.list.MyStack;
import ua.goit.mycollection.map.MyHashMap;
import ua.goit.mycollection.queue.MyLinkedList;
import ua.goit.mycollection.queue.MyQueue;

public class MyCollectionTest {
    public static void main(String[] args) {

        //MyArrayList test
        System.out.println("\nMyArrayList test\n");

        MyArrayList<String> list = new MyArrayList<>();
        list.add("Ukraine");
        list.add("France");
        list.add("Korea");
        list.add("Italy");
        list.add("Mexico");
        System.out.println("list = " + list);
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("list.size() = " + list.size());
        System.out.println("list.remove(3) = " + list.remove(3));
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size() + "\n");

        //MyLinkedList test
        System.out.println("MyLinkedList test\n");

        MyLinkedList<String> list1 = new MyLinkedList<>();
        System.out.println("list.size() = " + list.size());
        list1.add("Canada");
        list1.add("China");
        list1.add("Pakistan");
        System.out.println("list1 = " + list1);
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.get(2) = " + list1.get(2));
        System.out.println("list1.remove(1) = " + list1.remove(1));
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.get(0) = " + list1.get(0));
        list1.clear();
        System.out.println("list1 = " + list1);
        System.out.println("list.size() = " + list.size() + "\n");

        // MyQueue test
        System.out.println("MyQueue test\n");

        MyQueue<String> ls = new MyQueue<>();
        ls.add("USA");
        ls.add("Germany");
        ls.add("Romania");
        System.out.println("ls = " + ls);
        System.out.println("ls.poll() = " + ls.poll());
        System.out.println("ls.size() = " + ls.size());
        System.out.println("ls = " + ls);
        System.out.println("ls.size() = " + ls.size());
        System.out.println("ls.peek() = " + ls.peek());
        ls.clear();
        System.out.println("ls = " + ls);
        System.out.println("ls.size() = " + ls.size() + "\n");

        // MyStack test
        System.out.println("MyStack test\n");

        MyStack<String> stack = new MyStack<>();
        stack.push("London");
        stack.push("Kiev");
        stack.push("Venice");
        stack.push("Odessa");
        System.out.println("stack = " + stack);
        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.remove(2) = " + stack.remove(2));
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
        System.out.println("stack.size() = " + stack.size());
        stack.clear();
        System.out.println("stack = " + stack);
        System.out.println("stack.size() = " + stack.size() + "\n");

        // MyHashMap test
        System.out.println("MyHashMap test\n");

        MyHashMap<String, String> map = new MyHashMap<>();
        map.put(null, null);
        map.put("Korea", "Seoul");
        map.put("France","Paris");
        map.put("Russia", null);
        map.put("Finland", "Helsinki");
        map.put("Japan","Tokio");
        System.out.println("map = " + map);
        System.out.println("map.size() = " + map.size());
        System.out.println("map.get(\"Korea\") = " + map.get("Korea"));
        map.remove("Russia");
        System.out.println("map = " + map);
        System.out.println("map.size() = " + map.size());
        map.clear();
        System.out.println("map = " + map);
        System.out.println("map.size() = " + map.size());

    }

}
