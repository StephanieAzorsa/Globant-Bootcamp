package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.Iterator;

public class Example04IterateIterator {
    public static void main(String[] args) {
        // Iterator is an interface that allows us to traverse a collection
        // It has three methods:
        // hasNext() - returns true if there is another element in the collection
        // next() - returns the next element in the collection
        // remove() - removes the last element returned by the iterator

        // We can use the iterator to traverse a collection
        // We can use the iterator to remove elements from a collection
        // We can use the iterator to replace elements in a collection
        System.out.println("Iterator");
        ArrayList<String> list = new ArrayList<>();
        list.add("Beth");
        list.add("Maria");

        //Create an iterator to traverse the list
        Iterator<String> iterator = list.iterator(); //returns an iterator object
        System.out.println("Elements in the list:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

    }
}
