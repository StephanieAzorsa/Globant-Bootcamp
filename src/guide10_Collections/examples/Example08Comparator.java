package guide10_Collections.examples;

import guide10_Collections.examples.entidades.Book;
import guide10_Collections.examples.entidades.Dog;
import guide10_Collections.examples.entidades.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Example08Comparator {
    public static void main(String[] args) {
        System.out.println("Lists");
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Java", "Author 1", 2020);
        books.add(book1);
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Lists");
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog("Dog 1", 11);
        Dog dog2 = new Dog("Dog 2", 9);
        dogs.add(dog1);
        dogs.add(dog2);
        System.out.println(dogs);
        dogs.sort(Dog.ageComparator);
        System.out.println(dogs);

        System.out.println("--------------------------------------------------");
        System.out.println("HashSet");
        HashSet<Dog> dogSet = new HashSet<>();
        dogSet.add(dog1);
        dogSet.add(dog2);
        System.out.println(dogSet);
        ArrayList<Dog> dogsList = new ArrayList<>(dogSet);
        dogsList.sort(Dog.ageComparator);
        System.out.println(dogsList);

        System.out.println("--------------------------------------------------");
        System.out.println("TreeSet");
        TreeSet<Dog> dogTreeSet = new TreeSet<>(Dog.ageComparator);
        Dog dog3 = new Dog("Dog 3", 10);
        dogs.add(dog3);
        dogTreeSet.addAll(dogs);
        System.out.println(dogTreeSet);

        System.out.println("--------------------------------------------------");
        System.out.println("Maps");
        HashMap<Integer, Student> map = new HashMap<>();
        Student student1 = new Student("Student 1", "Lastname 1", 20, 92345678);
        Student student2 = new Student("Student 2", "Lastname 2", 21, 87654321);
        map.put(student1.getDni(), student1);
        map.put(student2.getDni(), student2);

        ArrayList<Student> names = new ArrayList<>(map.values());
        names.sort(Student.dniComparator);
        System.out.println(names);
    }
}