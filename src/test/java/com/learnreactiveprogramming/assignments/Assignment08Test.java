package com.learnreactiveprogramming.assignments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Assignment08Test {

    Assignment08 service;

    @BeforeEach
    public void setup(){
        this.service = new Assignment08();
    }

    /**
     * Implement a test case by passing the input as "abc" and write the appropriate assertions.
     */
    @Test
    void exception_mono_onErrorContinue_abc() {
        // given
        String input = "abc";
        // when
        Mono<String> value = service.exception_mono_onErrorContinue(input);
        // then
        StepVerifier.create(value)
                .verifyComplete();
    }

    /**
     * Implement a test case by passing the input as "reactor" and write the appropriate assertions.
     */
    @Test
    void exception_mono_onErrorContinue_reactor() {
        // given
        String input = "reactor";
        // when
        Mono<String> value = service.exception_mono_onErrorContinue(input);
        // then
        StepVerifier.create(value)
                .expectNext("reactor")
                .verifyComplete();
    }
}