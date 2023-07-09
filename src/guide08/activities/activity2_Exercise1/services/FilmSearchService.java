package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Film;

public class FilmSearchService {

    /**
     * Checks if the film name is unique among the films in the list.
     *
     * @param filmTitle The film name to check for uniqueness.
     * @return True if the film name is unique among the films, false otherwise.
     */
    boolean isUniqueFilmTitle(String filmTitle) {
        long count = FilmService.getFilm()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .count();
        return count == 1;
    }

    /**
     * Searches for a film by its title in the list of films.
     *
     * @param filmTitle The title of the movie to be searched.
     * @return The first film found that matches the specified title and isAvailable is true.
     * If no match is found, it returns null.
     */
    Film findFilmByTitle(String filmTitle) {
        return FilmService.getFilm()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds a film by its title and index in the list of films.
     * @param filmTitle The title of the movie to be searched.
     * @param index The index of the movie to be searched.
     * @return The Film object with the specified title and index, if found. Otherwise, returns null.
     */
    Film findFilmByTitleAndIndex(String filmTitle, int index) {
        return FilmService.getFilm()
                .stream()
                .filter(film -> film.getTitle().equals(filmTitle))
                .filter(Film::isAvailable)
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
