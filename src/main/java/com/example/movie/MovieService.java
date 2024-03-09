/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    private static int count = 5;

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here

    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> allMovies = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(allMovies);
        return movies;
    }

    @Override
    public Movie addMovie(Movie movie) {
        count += 1;
        Movie newMovie = new Movie(count, movie.getMovieName(), movie.getLeadActor());
        movieList.put(count, newMovie);
        return newMovie;

    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        Movie existingMovie = movieList.get(movieId);
        if (existingMovie == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if (movie.getMovieName() != null)
            existingMovie.setMovieName(movie.getMovieName());
        if (movie.getLeadActor() != null)
            existingMovie.setLeadActor(movie.getLeadActor());
        return existingMovie;

    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        movieList.remove(movieId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
