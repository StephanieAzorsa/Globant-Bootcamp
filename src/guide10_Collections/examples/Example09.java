package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Example09 {
    public static void main(String[] args) {
        ArrayList<Integer> grade = new ArrayList<>();
        fillList(grade);
        System.out.println(grade);

        HashSet<String> words = new HashSet<>();
        fillHashSet(words);
        System.out.println(words);

        HashMap<Integer, String> students = new HashMap<>();
        fillMap(students);
        System.out.println(students);
    }

    public static void fillList(ArrayList<Integer> numbers) {
        numbers.add(10);
    }

    public static void fillHashSet(HashSet<String> numbers) {
        numbers.add("Hi!");
    }

    public static void fillMap(HashMap<Integer, String> students) {
        students.put(1, "Student 1");
    }

}
