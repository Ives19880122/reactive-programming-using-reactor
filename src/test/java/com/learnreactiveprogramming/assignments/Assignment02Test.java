package com.learnreactiveprogramming.assignments;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Assignment02Test {

    // Junit test for namesMono_map_filter
    @Test
    public void namesMono_map_filter_Test(){
        // given - precondition or setup
        Assignment02 service = new Assignment02();
        int stringLength = 3;
        // when - action or the behavior that we are going test
        Mono<String> namesMono = service.namesMono_map_filter(stringLength);
        // then - verify the output
        StepVerifier.create(namesMono)
                .expectNext("ALEX")
                .verifyComplete();
    }
}