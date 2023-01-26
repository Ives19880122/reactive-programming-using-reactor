package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.domain.MovieInfo;
import com.learnreactiveprogramming.service.MovieInfoService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Write a test case for the retrieveMovieInfoById_RestClient that was coded in the previous lecture.
 *
 * 此作業的問題
 * Write a test case for the retrieveMovieInfoById_RestClient function.
 */
class Assignment09Test {
    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080/movies")
            .build();
    MovieInfoService movieInfoService = new MovieInfoService(webClient);

    @Test
    public void retrieveMovieInfoById_RestClient(){
        // given
        Long movieInfoId = 1L;
        // when
        Mono<MovieInfo> movieInfoMono = movieInfoService.retrieveMovieInfoById_RestClient(movieInfoId);

        // then
        StepVerifier.create(movieInfoMono)
                .assertNext(movieInfo -> {
                    assertEquals("Batman Begins",movieInfo.getName());
                    assertEquals(2005,movieInfo.getYear());
                })
                .verifyComplete();
    }

}