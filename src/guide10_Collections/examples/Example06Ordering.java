package guide10_Collections.examples;

import java.util.*;

public class Example06Ordering {
    public static void main(String[] args) {
        System.out.println("Lists");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(30);
        numbers.add(15);
        System.out.println("Unordered list: " + numbers);

        Collections.sort(numbers);
        System.out.println("Ordered list: " + numbers);

        System.out.println("--------------------------------------------------");
        System.out.println("Sets");
        HashSet<Integer> numbersSet = new HashSet<>();
        numbersSet.add(10);
        numbersSet.add(2);
        numbersSet.add(30);
        numbersSet.add(15);
        System.out.println("Unordered set: " + numbersSet);
        ArrayList<Integer> numbersList = new ArrayList<>(numbersSet);
        Collections.sort(numbersList);
        System.out.println("Ordered set: " + numbersList);

        System.out.println("--------------------------------------------------");
        System.out.println("Maps");
        HashMap<Integer, String> students = new HashMap<>();
        students.put(2, "John");
        students.put(3, "Beth");
        students.put(1, "Maria");
        System.out.println("Unordered map: " + students);
        TreeMap<Integer, String> studentsTree = new TreeMap<>(students);
        System.out.println("Ordered map: " + studentsTree);
    }
}
