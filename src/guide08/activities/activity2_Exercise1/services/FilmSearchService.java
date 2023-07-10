package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Film;

import java.util.Scanner;

public class FilmSearchService {
    public Film findFilmForRental(String filmTitle) {
        FilmService filmService = new FilmService();
        Scanner scanner = new Scanner(System.in);

        Film film = findFilmByTitle(filmTitle);
        if (film == null) return null;

        if (isUniqueFilmTitle(filmTitle)) {
            return findFilmByTitle(filmTitle);
        }
        else {
            filmService.listFilmsAvailableAndSameTitle(filmTitle);
            System.out.print("Enter the index of the film: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            return findFilmByTitleAndIndex(filmTitle, index);
        }
    }

    boolean isUniqueFilmTitle(String filmTitle) {
        return FilmService.getFilms()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .count() == 1;
    }

    Film findFilmByTitle(String filmTitle) {
        return FilmService.getFilms()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .findFirst()
                .orElse(null);
    }

    Film findFilmByTitleAndIndex(String filmTitle, int index) {
        return FilmService.getFilms()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
