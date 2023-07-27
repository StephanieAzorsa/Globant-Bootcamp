package guide10_Collections.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleStream02 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hi", "world", "Stream", "Java");

        String concatenation = String.join(" + ", words);

        System.out.println(concatenation);

        //--------------------------------------------------------------------

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        String concatenation2 = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));

        System.out.println(concatenation2);
    }
}
