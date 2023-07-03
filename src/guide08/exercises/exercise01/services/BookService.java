package guide08.exercises.exercise01.services;

import guide08.exercises.exercise01.entities.Book;

import java.util.Scanner;

public class BookService {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Book createBook() {
        Book book = new Book();

        System.out.println("ENTER THE BOOK INFORMATION:");
        System.out.print("Enter the ISBN of the book: ");
        book.setIsbn(scanner.next());
        System.out.print("Enter the title of the book: ");
        book.setTitle(scanner.next());
        System.out.print("Enter the author of the book: ");
        book.setAuthor(scanner.next());
        System.out.print("Enter the number of pages of the book: ");
        book.setNumberOfPages(scanner.nextInt());

        return book;
    }

    public void showBook(Book book) {
        System.out.println("\nBOOK INFORMATION:");
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Number of pages: " + book.getNumberOfPages());
    }

}
