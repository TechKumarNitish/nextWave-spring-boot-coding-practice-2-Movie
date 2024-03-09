// Write your code here

package com.example.movie;

import com.example.movie.Movie;
import java.util.ArrayList;

/**
 * MovieRepository
 */
public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie addMovie(Movie movie);

    Movie getMovieById(int movieId);

    Movie updateMovie(int movieId, Movie movie);

    void deleteMovie(int movieId);
}