package guide10_Collections.exercices.exercise04;

import guide10_Collections.exercices.exercise04.services.MovieService;

public class Main {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();

        movieService.createMovie();
        movieService.createMovie();
        movieService.createMovie();

        System.out.println("\nAll movies: ");
        movieService.showAllMovies();

        System.out.println("\nMovies over one hour: ");
        movieService.showMovieOverOneHour();

        movieService.sortDurationMovies();
        System.out.println("\nMovies sorted by duration: ");
        movieService.showAllMovies();

        movieService.sortDurationMoviesDesc();
        System.out.println("\nMovies sorted by duration desc: ");
        movieService.showAllMovies();

        movieService.sortTitleMovies();
        System.out.println("\nMovies sorted by title: ");
        movieService.showAllMovies();

        movieService.sortDirectorMovies();
        System.out.println("\nMovies sorted by director: ");
        movieService.showAllMovies();
    }
}
