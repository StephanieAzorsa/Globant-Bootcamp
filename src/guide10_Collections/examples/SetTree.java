package guide10_Collections.examples;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SetTree {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        TreeSet<Integer> treeIntegers = new TreeSet<>();

        int num;
        String answer;

        do {
            System.out.print("Enter a number: ");
            num = leer.nextInt();

            treeIntegers.add(num);

            System.out.print("Do you want to enter another number?  ");
            answer = leer.next();

        } while (answer.equalsIgnoreCase("y"));

        System.out.println("===================================");
        System.out.println("Show the TreeSet with a for each");

        for (Integer number : treeIntegers) {
            System.out.println(number);
        }

        System.out.println("===================================");
        System.out.println("Looping the TreeSet with an iterator");

        Iterator<Integer> it = treeIntegers.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("===================================");
        System.out.println("We use the iterator to remove an element because with the for each it fails");

        Iterator<Integer> it2 = treeIntegers.iterator();

        while (it2.hasNext()) {
            if (it2.next().equals(3)) {
                it2.remove();
            }
        }

        System.out.println("===================================");
        System.out.println("We show the treeSet without the deleted element");

        for (Integer number : treeIntegers) {
            System.out.println(number);
        }

        System.out.println("===================================");
        System.out.println("The TreeSet size: " + treeIntegers.size());

        System.out.println("===================================");
        System.out.println("We find out if the TreeSet contains x element");

        if (treeIntegers.contains(3)) {
            System.out.println("It has number 3");
        } else {
            System.out.println("It doesn't have number 3");
        }

        System.out.println("===================================");
        System.out.println("We find out if the TreeSet is empty");

        if (treeIntegers.isEmpty()) {
            System.out.println("The TreeSet is empty");
        } else {
            System.out.println("The TreeSet is not empty");
        }

        System.out.println("===================================");
        System.out.println("Delete all elements of the TreeSet");
        treeIntegers.clear();
    }

}