package com.learnreactiveprogramming.assignments;

import com.learnreactiveprogramming.domain.Movie;
import com.learnreactiveprogramming.domain.MovieInfo;
import com.learnreactiveprogramming.domain.Review;
import com.learnreactiveprogramming.exception.ReactorException;
import com.learnreactiveprogramming.service.MovieInfoService;
import com.learnreactiveprogramming.service.ReviewService;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Create a function named exception_mono_onErrorContinue() and it accepts a String as an input
 *
 * Create a Mono using the Mono.just(<input String to the function>)
 *
 * In the map function throw a RuntimeException if the input is abc otherwise return the input
 *
 * Using the onErrorContinut handle the exception and log the exception and the input value in the onErrorContinue block
 *
 * 此作業的問題
 * Implement the exception_mono_onErrorContinue using the instructions provided in the Instructions page.
 *
 * Implement a test case by passing the input as "abc" and write the appropriate assertions.
 *
 * Implement a test case by passing the input as "reactor" and write the appropriate assertions.
 */
public class Assignment08 {

    public Mono<String> exception_mono_onErrorContinue(String input){
        return Mono.just(input)
                .map(name->{
                    if("abc".equals(input))
                        throw  new RuntimeException("Input error String");
                    return name;
                })
                .onErrorContinue((ex, val) -> {
                    System.out.println("Value is : "+ val);
                    System.out.println("Exception is : "+ex);
                })
                .log();
    }
}
