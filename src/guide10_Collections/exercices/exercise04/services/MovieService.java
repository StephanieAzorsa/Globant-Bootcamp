package guide10_Collections.exercices.exercise04.services;

import guide10_Collections.exercices.exercise04.entities.Movie;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MovieService {
    private final Scanner scanner;
    private final ArrayList<Movie> movies;
    private final DateTimeFormatter formatter;

    public MovieService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.movies = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("HH:mm");
    }

    public void createMovie() {
        Movie movie = new Movie();

        System.out.println("\nAdd movie...");
        System.out.print("Enter movie's title: ");
        movie.setTitle(scanner.nextLine().trim());
        System.out.print("Enter the director's movie: ");
        movie.setDirector(scanner.nextLine().trim());

        System.out.print("Enter movie's duration in hours: ");
        int hours = scanner.nextInt();
        System.out.print("Enter movie's duration in minutes: ");
        int minutes = scanner.nextInt();
        scanner.nextLine();

        Duration duration = Duration.ofHours(hours).plusMinutes(minutes);

        movie.setDuration(LocalDateTime.of(1, 1, 1,
                duration.toHoursPart(), duration.toMinutesPart()));

        movies.add(movie);
    }

    public void showAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("There are no movies to show");
            return;
        }

        for (Movie movie : movies) {
            String formattedDuration = movie.getDuration().format(formatter);
            System.out.printf("| Title: %-10s | Duration: %-5s | Director: %-10s | %n",
                    movie.getTitle(), formattedDuration, movie.getDirector());
        }
    }

    public void showMovieOverOneHour() {
        if (movies.isEmpty()) {
            System.out.println("There are no movies to show");
            return;
        }

        for (Movie movie : movies) {
            if (movie.getDuration().getHour() >= 1) {
                String formattedDuration = movie.getDuration().format(formatter);
                System.out.printf("| Title: %-10s | Duration: %-5s | Director: %-10s | %n",
                        movie.getTitle(), formattedDuration, movie.getDirector());
            }
        }
    }

    public void sortDurationMovies() {
        movies.sort(Comparator.comparing(Movie::getDuration));
    }

    public void sortDurationMoviesDesc() {
        movies.sort(Comparator.comparing(Movie::getDuration).reversed());
    }

    public void sortTitleMovies() {
        movies.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortDirectorMovies() {
        movies.sort(Comparator.comparing(Movie::getDirector));
    }
}
