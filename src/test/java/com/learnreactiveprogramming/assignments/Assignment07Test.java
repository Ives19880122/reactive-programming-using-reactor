package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.domain.Movie;
import com.learnreactiveprogramming.domain.MovieInfo;
import com.learnreactiveprogramming.domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Use the getAllMovies function as an example and use the flatMap operator as
 * it was used  and implement the getMovieById functionality
 *
 * 此作業的問題
 * Write a test case for getMovieById function using flatMap operator
 */
public class Assignment07Test {

    Assignment07 service;

    @BeforeEach
    public void setup(){
        this.service = new Assignment07();
    }

    // Junit test for
    @Test
    public void getMovieById(){
        // given - precondition or setup
        Long movieId = 1L;
        // when - action or the behavior that we are going test
        Mono<Movie> movieFlux = service.getMovieById(1L).log();
        // then - verify the output
        StepVerifier.create(movieFlux)
                .assertNext(movie -> {
                    MovieInfo movieInfo = movie.getMovieInfo();
                    List<Review> reviewList = movie.getReviewList();
                    assertEquals("Batman Begins",movieInfo.getName());
                    assertEquals(2005,movieInfo.getYear());
                    assertEquals(2,reviewList.size());
                })
                .verifyComplete();
    }
}
