package com.learnreactiveprogramming.assignments;

import reactor.core.publisher.Mono;

/**
 * 1) defaultIfEmpty
 *
 * Use the function namesMono_map_filter to implement the defaultIfEmpty in Mono
 *
 * Pass the stringLength as 4 and use the defaultIfEmpty to return a value.
 *
 * 2) switchIfEmpty
 *
 * Create another function named namesMono_map_filter_switchIfEmpty and copy code from the namesMono_map_filter function and implement the switchIfEmpty in Mono
 *
 * Pass the stringLength as 4 and use the switchIfEmpty to return a value.
 *
 * 此作業的問題
 * 1. Use the defaultIfEmpty to return a default value in case of an empty response.
 *
 * 2. Use the switchIfEmpty to return a default value in case of an empty response.
 */
public class Assignment03 {

    public Mono<String> namesMono_map_filter(int stringLength){
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(name->name.length()>stringLength)
                .log();
    }

    public Mono<String> defaultIfEmpty(){
        int stringLength = 5;
        return namesMono_map_filter(stringLength)
                .defaultIfEmpty("default")
                .log();
    }


    public Mono<String> switchIfEmpty(){
        int stringLength = 5;
        Mono<String> switchName = Mono.just("default");
        return namesMono_map_filter(stringLength)
                .switchIfEmpty(switchName)
                .log();
    }
}
