package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Example10 {
    public static void main(String[] args) {
        System.out.println(fillList());
        System.out.println(fillHashSet());
        System.out.println(fillMap());

    }

    private static ArrayList<Integer> fillList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        return numbers;
    }

    private static HashSet<String> fillHashSet() {
        HashSet<String> words = new HashSet<>();
        words.add("Hi!");
        words.add("Hello!");
        words.add("Bye!");
        return words;
    }

    private static HashMap<Integer, String> fillMap() {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Student 1");
        students.put(2, "Student 2");
        students.put(3, "Student 3");
        return students;
    }
}
