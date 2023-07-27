package guide10_Collections.examples;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tree {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        TreeMap<Integer, String> students = new TreeMap<>();

        int document;
        String name;
        String answer;

        do {
            System.out.println("Enter the student's document");
            document = leer.nextInt();

            System.out.println("Enter the student's name");
            name = leer.next();

            students.put(document, name);

            System.out.println("Do you want to enter another student?");
            answer = leer.next();

        } while (answer.equalsIgnoreCase("Yes"));

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Document = " + entry.getKey() + ", Name = " + entry.getValue());
        }

//        for (Integer dni : students.keySet()) {
//            System.out.println("Document = " + dni);
//        }
//
//        for (String names : students.values()) {
//            System.out.println("Name: " + names);
//        }

        students.replace(document, "Martin", "Lucas");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Document = " + entry.getKey() + ", Name = " + entry.getValue());
        }

    }

}