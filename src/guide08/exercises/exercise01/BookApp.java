package guide08.exercises.exercise01;

import guide08.exercises.exercise01.entities.Book;
import guide08.exercises.exercise01.services.BookService;

public class BookApp {
    public static void main(String[] args) {
        BookService bs = new BookService();
        Book book = bs.createBook();
        bs.showBook(book);
//        System.out.println(book); //Uncomment this line to see the toString() method in action
    }
}
