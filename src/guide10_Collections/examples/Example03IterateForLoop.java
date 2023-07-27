package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Example03IterateForLoop {
    public static void main(String[] args) {
        //LISTS: ArrayList, LinkedList, Vector
        System.out.println("ArrayList");
        ArrayList<String> list = new ArrayList<>();
        list.add("Beth");
        list.add("Maria");
        list.add("Alan");
        for (String string : list)
            System.out.println(string);

        //MAPS: HashMap, LinkedHashMap, TreeMap
        System.out.println("\nHashMap");
        HashMap<Integer, String> students = new HashMap<>();
        students.put(123, "John");
        students.put(124, "Mary");
        students.put(125, "Peter");
        // loop through the two parts of the map
        // entry.getKey fetches the key and entry. getValue fetches the map values.
        for (Map.Entry<Integer, String> entry : students.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());

        // Without using the entrySet method
        // Show only the keys
        for (Integer dni : students.keySet())
            System.out.println("Document: " + dni);

        // Show only the values
        for (String value : students.values())
            System.out.println("Name: " + value);


        //SETS: HashSet, LinkedHashSet, TreeSet
        System.out.println("\nHashSet");
        HashSet<Integer> numbersSet = new HashSet<>();
        numbersSet.add(10);
        numbersSet.add(20);
        for (Integer number : numbersSet)
            System.out.println(number);

    }
}
