package com.learnreactiveprogramming.assignments;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Assignment01Test {


    @Test
    void namesMonoTest() {
        // given
        Assignment01 service = new Assignment01();
        // when
        Mono<String> namesMono = service.namesMono();
        // then
        StepVerifier.create(namesMono)
                .expectNext("alex")
                .verifyComplete();
    }
}
