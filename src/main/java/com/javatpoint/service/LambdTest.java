package com.javatpoint.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}
public class LambdTest { public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(LambdTest.class);
    // Lambda expression to define addition operation
    MathOperation addition = (a, b) -> a + b;
    MathOperation multiplication = (a, b) -> a * b;

    System.out.println("Addition: " + addition.operation(10, 5));  // Output: 15
    System.out.println("Multiplication: " + multiplication.operation(10, 5));  // Output: 50

    List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Alex", "John");

    // Filter names starting with 'A'
    List<String> filteredNames = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());

    System.out.println("example 1"+ filteredNames);
    filteredNames.add("dmeo");
    logger.info("example 1 -{}",filteredNames);
    List<String> filteredNames1 = names.stream()
            .filter(name -> name.startsWith("A"))
            .toList();
    //filteredNames1.add("demo");   immutable if toList()
    logger.info("example 2 -{}",filteredNames1);
    List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("Alice", "Bob"),
            Arrays.asList("Charlie", "David")
    );
//Flattens nested streams into a single stream
    List<String> namesFlattened = namesNested.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());

    System.out.println(namesFlattened);



}
}