package guide10_Collections.examples;

import guide10_Collections.examples.entidades.Book;
import guide10_Collections.examples.entidades.Dog;
import guide10_Collections.examples.entidades.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Example07UsingObjects {
    public static void main(String[] args) {
        System.out.println("Lists");
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Java", "Author 1", 2020);
        Book book2 = new Book("Python", "Author 2", 2023);
        books.add(book1);
        books.add(book2);
        System.out.println("List of books: " + books);

        System.out.println("--------------------------------------------------");
        System.out.println("Sets");
        HashSet<Dog> dogs = new HashSet<>();
        Dog dog1 = new Dog("Dog 1", 1);
        Dog dog2 = new Dog("Dog 2", 2);
        dogs.add(dog1);
        dogs.add(dog2);
        System.out.println("Set of dogs: " + dogs);

        System.out.println("--------------------------------------------------");
        System.out.println("Maps");
        HashMap<Integer, Student> students = new HashMap<>();
        int unique = 12345678;
        Student student1 = new Student("Student 1", "Lastname 1", 20, 12345678);
        students.put(unique, student1);
        System.out.println("Map of students: " + students);
    }
}
