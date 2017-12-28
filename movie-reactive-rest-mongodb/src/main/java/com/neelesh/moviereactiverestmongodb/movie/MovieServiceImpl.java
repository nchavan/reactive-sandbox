package com.neelesh.moviereactiverestmongodb.movie;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Flux<MovieEvent> events(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1)) ;
    }

    @Override
    public Mono<Movie> getMoviesById(String movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Flux <Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
