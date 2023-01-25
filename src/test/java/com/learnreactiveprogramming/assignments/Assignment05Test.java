package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.service.FluxAndMonoGeneratorService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Write the test case for explore_mergeWith() and
 * explore_mergeWith_mono() methods in the FluxAndMonoGeneratorService class.
 *
 * 此作業的問題
 * 1. Write the test case for explore_mergeWith() method in FluxAndMonoGeneratorService class.
 * 2. Write the test case for explore_mergeWith_mono() method in FluxAndMonoGeneratorService class.
 */
public class Assignment05Test {

    @Test
    public void explore_mergeWith_TEST() {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        Flux<String> stringFlux = service.explore_mergeWith();
        StepVerifier.create(stringFlux)
                .expectNext("A", "D", "B", "E", "C", "F")
                .verifyComplete();
    }

    @Test
    public void explore_mergeWith_mono_TEST() {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        Flux<String> stringFlux = service.explore_mergeWith_mono();
        StepVerifier.create(stringFlux)
                .expectNext("A","B")
                .verifyComplete();
    }
}
