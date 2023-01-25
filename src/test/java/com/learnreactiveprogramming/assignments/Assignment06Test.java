package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.service.FluxAndMonoGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Write the test case for explore_zipWith() and
 * explore_zipWith_mono() methods in the FluxAndMonoGeneratorService class.
 * 此作業的問題
 * 1. Write the test case for explore_zipWith() method in FluxAndMonoGeneratorService class.
 * 2. Write the test case for explore_zipWith_mono() method in FluxAndMonoGeneratorService class.
 */
public class Assignment06Test {

    private FluxAndMonoGeneratorService service;

    @BeforeEach
    public void setup(){
        this.service = new FluxAndMonoGeneratorService();
    }

    @Test
    public void explore_zipWith() {
        Flux<String> stringFlux = service.explore_zipWith();
        StepVerifier.create(stringFlux)
                .expectNext("AD", "BE", "CF")
                .verifyComplete();
    }

    @Test
    public void explore_zipWith_mono() {
        Mono<String> stringFlux = service.explore_zipWith_mono();
        StepVerifier.create(stringFlux)
                .expectNext("AB")
                .verifyComplete();
    }
}
