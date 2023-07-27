package guide10_Collections.examples;

import java.util.HashMap;
import java.util.HashSet;

public class Example02AddPut {
    public static void main(String[] args) {
        System.out.println("HashSet does not have index");
        System.out.println("---------------------------------");

        HashSet<Integer> numbersB = new HashSet<>();
        int num = 50;
        numbersB.add(num);
        System.out.println("add(50): " + numbersB);
        numbersB.remove(num);
        System.out.println("remove(50): " + numbersB);

        HashMap<Integer, String> students = new HashMap<>();
        students.put(123, "John");
        students.put(124, "Mary");
        students.put(125, "Peter");
        System.out.println("\nput(123, \"John\"), put(124, \"Mary\"), put(125, \"Peter\"): " + students);
        students.remove(123); //Delete by key
        System.out.println("remove(123): " + students);

        students.clear();
        System.out.println("\nclear(): " + students);
    }
}
