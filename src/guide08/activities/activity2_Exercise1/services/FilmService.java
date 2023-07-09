package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmService {
    private final Scanner scanner = new Scanner(System.in);
    private static final List<Film> films = new ArrayList<>();

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
        int year = scanner.nextInt();
        scanner.nextLine();
        film.setYear(LocalDate.of(year, 1, 1));

        // Add the film to the Film collection
        films.add(film);
    }

    /**
     * Returns the list of films.
     *
     * @return films
     */
    public static List<Film> getFilm() {
        return films;
    }

    /**
     * Lists the films that are available.
     */
    public void listFilmsAvailable() {
        System.out.println("\nLIST OF FILMS AVAILABLE");
        List<Film> availableFilms = films.stream()
                .filter(Film::isAvailable)
                .toList();

        if (availableFilms.isEmpty()) {
            System.out.println("No films available!");
            return;
        }

        availableFilms.forEach(System.out::println);
    }

    /**
     * Lists the films that are available and have the same name.
     *
     * @param filmName The title of the movie to be searched.
     */
    public void listFilmsAvailableAndSameTitle(String filmName) {
        System.out.println("\nLIST OF FILMS AVAILABLE AND WITH THE SAME NAME");
        List<Film> matchingFilms = films.stream()
                .filter(film -> film.isAvailable() && film.getTitle().equals(filmName))
                .toList();

        if (matchingFilms.isEmpty()) {
            System.out.println("No films available!");
            return;
        }

        for (int index = 0; index < matchingFilms.size(); index++) {
            Film film = matchingFilms.get(index);
            System.out.printf("Title: %-20s Genre: %-15s " +
                            "Year: %-10s Duration: %-10s " +
                            "Available: %-10s Index: %d%n",
                    film.getTitle(), film.getGenre(), film.getYear(), film.getDuration(), true, index);
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
     *
     * @param filmToFind the value to search for in the films.
     * @param criteria   the criteria to search by (title or genre).
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
            String searchType = "";
            if (criteria.equals("title"))
                searchType = "title";
            else if (criteria.equals("genre"))
                searchType = "genre";
            System.out.println("No films found with the " + searchType + ": " + filmToFind);
        }
    }


}
