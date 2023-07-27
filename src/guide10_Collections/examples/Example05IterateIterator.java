package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Example05IterateIterator {
    public static void main(String[] args) {

        System.out.println("Lists");
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.add("Java");
        words.add("Collections");

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
           if (iterator.next().equals("Java"))
               iterator.remove();
        }
        System.out.println(words);

        words.removeIf(s -> s.equals("Java"));
        System.out.println(words);

        System.out.println("--------------------------------------------------");
        System.out.println("Sets");
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.removeIf(integer -> integer == 10);
        System.out.println(numbers);

        Iterator<Integer> iterator2 = numbers.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next() == 10)
                iterator2.remove();
        }
        System.out.println(numbers);


    }
}
