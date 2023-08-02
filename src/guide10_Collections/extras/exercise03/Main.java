package guide10_Collections.extras.exercise03;

import guide10_Collections.extras.exercise03.services.BookService;


public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        bookService.createBook();
        bookService.createBook();
        bookService.createBook();
        System.out.println(bookService.getBooks());

        System.out.println("\nBorrowing book...");
        bookService.borrowedBook("test", "test 1");
        System.out.println(bookService.getBooks());

        System.out.println("\nReturning book...");
        bookService.returnedBook("test", "test 1");
        System.out.println(bookService.getBooks());

    }
}
