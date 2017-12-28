package com.neelesh.moviereactiverestmongodb.bootstrapclr;

import com.neelesh.moviereactiverestmongodb.movie.Movie;
import com.neelesh.moviereactiverestmongodb.movie.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll()
                .thenMany(
                    Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                            "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                            .map(title -> new Movie(title))
                            .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                            movieRepository.findAll().subscribe(System.out::println);
                        }
                );
    }
}
