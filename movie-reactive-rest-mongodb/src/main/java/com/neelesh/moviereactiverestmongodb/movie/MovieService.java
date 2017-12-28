package com.neelesh.moviereactiverestmongodb.movie;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);
    Mono<Movie> getMoviesById(String movieId);
    Flux<Movie> getAllMovies();

}
