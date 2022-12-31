package com.learnreactiveprogramming.assignments;

import reactor.core.publisher.Mono;

public class Assignment01 {

    public Mono<String> namesMono(){
        return Mono.just("alex")
                .log();
    }
}
