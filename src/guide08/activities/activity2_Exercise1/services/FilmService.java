package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmService {
    private final Scanner scanner = new Scanner(System.in);
    private static final List<Film> films = new ArrayList<>();

    public void createFilm() {
        System.out.println("\nDATA ENTRY");
        Film film = new Film();

        System.out.print("Enter title: ");
        film.setTitle(scanner.nextLine().trim());
        System.out.print("Enter the genre: ");
        film.setGenre(scanner.nextLine());
        System.out.print("Enter the duration in minutes: ");
        film.setDuration(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        film.setYear(LocalDate.of(year, 1, 1));

        films.add(film);
    }

    public static List<Film> getFilms() {
        return films;
    }

    public void listAllFilms() {
        System.out.println("\nLIST OF ALL FILMS");
        listFilm(films);
    }

    public void listFilmsAvailable() {
        System.out.println("\nLIST OF FILMS AVAILABLE");
        List<Film> availableFilms = films.stream()
                .filter(Film::isAvailable)
                .toList();
        listFilm(availableFilms);
    }

    public void listFilmsAvailableAndSameTitle(String filmName) {
        System.out.println("\nLIST OF FILMS AVAILABLE AND WITH THE SAME NAME");
        List<Film> matchingFilms = films.stream()
                .filter(film -> film.isAvailable() && film.getTitle().equals(filmName))
                .toList();
        listFilm(matchingFilms);
    }

    public void searchByCriteria(String criteria) {
        System.out.println("\nSEARCH BY " + criteria.toUpperCase());
        if (films.isEmpty()) {
            System.out.println("No films available!");
            return;
        }
        System.out.print("Enter the " + criteria.toLowerCase() + ": ");
        String searchTerm = scanner.nextLine();

        if (films.stream().noneMatch(film -> matchesCriteria(film, criteria, searchTerm))) {
            System.out.println("No films found!");
            return;
        }


        List<Film> searchResults = films.stream()
                .filter(film -> matchesCriteria(film, criteria, searchTerm))
                .toList();

        listFilm(searchResults);
    }

    private boolean matchesCriteria(Film film, String criteria, String searchTerm) {
        return switch (criteria) {
            case "title" -> film.getTitle().equalsIgnoreCase(searchTerm);
            case "genre" -> film.getGenre().equalsIgnoreCase(searchTerm);
            default -> false;
        };
    }

    private void listFilm(List<Film> films) {
        if (films.isEmpty()) {
            System.out.println("No films available!");
            return;
        }

        int index = 0;
        for (Film film : films) {
            System.out.printf("| Title: %-8s | Genre: %-8s " +
                            "| Year: %-4s | Duration: %-4s " +
                            "| Available: %-5s | Index: %d%n",
                    film.getTitle(), film.getGenre(), film.getYear().getYear(),
                    film.getDuration(), film.isAvailable(), index++);
        }
    }
}