package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.domain.Movie;
import com.learnreactiveprogramming.domain.MovieInfo;
import com.learnreactiveprogramming.domain.Review;
import com.learnreactiveprogramming.service.MovieInfoService;
import com.learnreactiveprogramming.service.ReviewService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Use the getAllMovies function as an example and use the flatMap operator as
 * it was used  and implement the getMovieById functionality
 *
 * 此作業的問題
 * Implement the getMovieById using the flatMap operator in Mono.
 */
public class Assignment07 {

    private MovieInfoService movieInfoService = new MovieInfoService();
    private ReviewService reviewService = new ReviewService();


    public Mono<Movie> getMovieById(Long movieId){
        Mono<MovieInfo> movieInfoFlux = movieInfoService.retrieveMovieInfoMonoUsingId(movieId);
        return movieInfoFlux
                .flatMap(movieInfo -> {
                    Mono<List<Review>> reviewListMono = reviewService.retrieveReviewsFlux(movieId)
                            .collectList();
                    return reviewListMono.map(reviews -> new Movie(movieInfo, reviews));
                });
    }
}
