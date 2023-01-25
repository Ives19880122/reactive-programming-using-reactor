package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.service.FluxAndMonoGeneratorService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Write the test case for explore_concatwith() and
 * explore_concatwith_mono() methods in the FluxAndMonoGeneratorService class.
 *
 * 此作業的問題
 * Write the test case for explore_concatwith()
 * method in FluxAndMonoGeneratorService class.
 *
 * Write the test case for explore_concatwith_mono()
 * method in FluxAndMonoGeneratorService class.
 */
public class Assignment04Test {

    @Test
    public void explore_concatWith_TEST() {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        Flux<String> stringFlux = service.explore_concatWith();
        StepVerifier.create(stringFlux)
                .expectNextCount(6)
                .verifyComplete();
    }

    @Test
    public void explore_concatWith_mono_TEST() {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        Flux<String> stringFlux = service.explore_concatWith_mono();
        StepVerifier.create(stringFlux)
                .expectNextCount(2)
                .verifyComplete();
    }
}
