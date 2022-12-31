package com.learnreactiveprogramming.assignments;

import reactor.core.publisher.Mono;

public class Assignment02 {

    public Mono<String> namesMono_map_filter(int stringLength){
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(name->name.length()>stringLength)
                .log();
    }
}
