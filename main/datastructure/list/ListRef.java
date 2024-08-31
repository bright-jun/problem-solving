package datastructure.list;

import java.util.LinkedList;

public class ListRef {

    public static void doSomething(LinkedList<?> ll) {
        ll.add(0, null);
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        doSomething(ll);
        return;
    }
}
