package guide10_Collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class List {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        ArrayList<String> list = new ArrayList<>(); // Create a list of Strings

        String word;
        String answer;

        do {
            System.out.println("Enter a word: ");
            word = leer.next();

            list.add(word);

            System.out.println("Do you want to enter another word?");
            answer = leer.next();

        } while (answer.equalsIgnoreCase("Yes"));

        System.out.println("===================================");
        System.out.println("for-each");

        for (String array : list) {
            System.out.println(array);
        }

        System.out.println("===================================");
        System.out.println("iterator");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("===================================");
        System.out.println("We use the iterator to remove an element, because the for-each fails");

        Iterator<String> it2 = list.iterator();

        while (it2.hasNext()) {
            if (it2.next().equals("Hi")) { // Delete the element "Hi"
                it2.remove();
            }
        }

        System.out.println("===================================");
        System.out.println("We print the list without the element Hi");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("===================================");
        System.out.println("Size of the list: " + list.size());

        System.out.println("===================================");
        System.out.println("We delete the element thought the index");

        list.remove(1);

        System.out.println("===================================");
        System.out.println("We print the list without the element in index 1");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("===================================");
        System.out.println("We sort the list");

        Collections.sort(list);

        System.out.println("===================================");
        System.out.println("We print the list sorted");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("===================================");
        System.out.println("We sort the list in reverse order");

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("===================================");
        System.out.println("We print the list sorted in reverse order");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("===================================");
        System.out.println("It shows us in which index the word hello is found.");

        System.out.println(list.indexOf("Hi"));

        System.out.println("===================================");
        System.out.println("We find out if the list contains x element");

        if (list.contains("Hi")) {
            System.out.println("It has the word Hi");

        } else {
            System.out.println("It doesn't have it");
        }

        System.out.println("===================================");
        System.out.println("We check if the list has elements");

        if (list.isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.println("The list has elements");
        }

        System.out.println("===================================");
        System.out.println("We delete all the elements of the list");
        list.clear();

    }

}