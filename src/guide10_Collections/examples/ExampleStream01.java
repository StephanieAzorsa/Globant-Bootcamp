package guide10_Collections.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExampleStream01 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        System.out.println("Numbers: " + numbers);

        List<Integer> evenNumber = numbers.stream()
                .filter(ExampleStream01::evenNumbers)
                .toList();

        System.out.println("Even numbers: " + evenNumber);

        List<Integer> numbersMultipliedByTwo = numbers.stream()
                .map(n -> n * 2)
                .toList();

        System.out.println("Numbers multiplied by two: " + numbersMultipliedByTwo);


        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Max: " + max);

        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
        System.out.println("Min: " + min);


//        Optional<Integer> suma = numbers.stream().reduce((a, b) -> a + b);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        System.out.println("Sum: " + sum.get());

        boolean someNumberBiggerThan5 = numbers.stream().anyMatch(n -> n > 5);
        System.out.println("Some number bigger than 5: " + someNumberBiggerThan5);

        long quantityOfEvenNumbers = numbers.stream().filter(ExampleStream01::evenNumbers).count();
        System.out.println("Quantity of even numbers: " + quantityOfEvenNumbers);

        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        System.out.println("Sorted numbers: " + sortedNumbers);

        List<Integer> sortedNumbersDesc = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted numbers desc: " + sortedNumbersDesc);

        int sumSquaresEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("Sum of the squares of the even numbers " + sumSquaresEvenNumbers);
    }

    private static boolean evenNumbers(Integer n) {
        return n % 2 == 0;
    }
}
