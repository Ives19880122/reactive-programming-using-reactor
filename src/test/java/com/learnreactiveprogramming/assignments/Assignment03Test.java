package com.learnreactiveprogramming.assignments;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Assignment03Test {

    @Test
    void defaultIfEmpty() {
        Assignment03 service = new Assignment03();
        Mono<String> publisher = service.defaultIfEmpty();
        StepVerifier.create(publisher)
                .expectNext("default")
                .verifyComplete();
    }

    @Test
    void switchIfEmpty() {
        Assignment03 service = new Assignment03();
        Mono<String> publisher = service.switchIfEmpty();
        StepVerifier.create(publisher)
                .expectNext("default")
                .verifyComplete();
    }
}