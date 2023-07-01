package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmService {
    private final Scanner scanner = new Scanner(System.in);
    private static final List<Film> films = new ArrayList<>();

    /**
     * Returns the list of films.
     * @return films
     */
    public static List<Film> getFilm() {
        return films;
    }

    /**
     * Creates a new film by taking input from the user.
     */
    public void createFilm() {
        System.out.println("\nDATA ENTRY");
        Film film = new Film();

        System.out.print("Enter title: ");
        film.setTitle(scanner.nextLine());
        System.out.print("Enter the genre: ");
        film.setGenre(scanner.nextLine());
        System.out.print("Enter the duration in minutes: ");
        film.setDuration(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the year: ");
        film.setYear(scanner.nextLine());

        // Add the film to the Film collection
        films.add(film);
    }

    /**
     * Searches for a film by the title in the list of films.
     */
    public void listFilmsAvailable() {
        System.out.println("\nLIST OF FILMS AVAILABLE");
        if (films.isEmpty() || films.stream().noneMatch(Film::isAvailable)) {
            System.out.println("No films available!");
            return;
        }
        for (Film film : films) {
            if (film.isAvailable())
                System.out.println(film);
        }
    }

    /**
     * Lists all films in the list of films.
     */
    public void listAllFilms() {
        System.out.println("\nLIST OF ALL FILMS");
        if (films.isEmpty()) {
            System.out.println("No films available!");
            return;
        }
        for (Film film : films)
            System.out.println(film.toString());
    }

    /**
     * Searches for a film by the title in the list of films.
     */
    public void searchByTitle() {
        System.out.println("\nSEARCH BY TITLE");
        System.out.print("Enter the film name: ");
        String filmToFind = scanner.nextLine();
        searchFilmByCriteria(filmToFind, "title");
    }

    /**
     * Searches for a film by the genre in the list of films.
     */
    public void searchByGenre() {
        System.out.println("\nSEARCH BY GENRE");
        System.out.print("Enter the film genre: ");
        String filmToFind = scanner.nextLine();
        searchFilmByCriteria(filmToFind, "genre");
    }

    /**
     * Searches for films based on the given criteria and value.
     * @param filmToFind the value to search for in the films.
     * @param criteria the criteria to search by (title or genre).
     */
    private void searchFilmByCriteria(String filmToFind, String criteria) {
        if (films.isEmpty()) {
            System.out.println("No films available!");
            return;
        }

        System.out.println("\nSEARCH RESULTS");
        boolean filmsFound = false;

        for (Film film : films) {
            String filmValue = "";

            if (criteria.equals("title"))
                filmValue = film.getTitle();
            else if (criteria.equals("genre"))
                filmValue = film.getGenre();

            if (filmValue.equals(filmToFind)) {
                System.out.println(film.toString());
                filmsFound = true;
            }
        }

        if (!filmsFound) {
            if (criteria.equals("title"))
                System.out.println("No films found with the title: " + filmToFind);
            else if (criteria.equals("genre"))
                System.out.println("No films found with the genre: " + filmToFind);
        }
    }

}
