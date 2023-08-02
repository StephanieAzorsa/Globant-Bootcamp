package guide10_Collections.extras.exercise03.services;

import guide10_Collections.extras.exercise03.entities.Book;

import java.util.HashSet;
import java.util.Scanner;

public class BookService {
    private final Scanner scanner;
    private final HashSet<Book> books;

    public BookService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.books = new HashSet<>();
    }

    public void createBook() {
        Book book = new Book();
        System.out.print("Enter the title of the book: ");
        book.setTitle(scanner.next().toLowerCase().trim());
        System.out.print("Enter the author of the book: ");
        book.setAuthor(scanner.next().toLowerCase().trim());
        System.out.print("Enter the number of copies of the book: ");
        book.setNumberOfCopies(scanner.nextInt());
        book.setNumberOfCopiesAvailable(book.getNumberOfCopies());
        book.setNumberOfCopiesBorrowed(0);

        if (books.contains(book))
            System.out.println("Book already exists.");

        books.add(book);
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void borrowedBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                if (book.getNumberOfCopiesAvailable() > 0) {
                    book.setNumberOfCopiesAvailable(book.getNumberOfCopiesAvailable() - 1);
                    book.setNumberOfCopiesBorrowed(book.getNumberOfCopiesBorrowed() + 1);
                    book.setIsAvailable(false);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("There are no copies available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnedBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                if (book.getNumberOfCopiesBorrowed() > 0) {
                    book.setNumberOfCopiesAvailable(book.getNumberOfCopiesAvailable() + 1);
                    book.setNumberOfCopiesBorrowed(book.getNumberOfCopiesBorrowed() - 1);
                    book.setIsAvailable(true);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("There are no copies borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
