package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.List;

public class StreamShortCircuitingOperations {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// The limit(long n) method of java.util.stream.Stream object returns a
		// reduced stream of first n elements
		System.out.println("Limit of 2 :");
		numbers.stream().limit(2).forEach(i -> System.out.println(i));

		
		// Stream of remaining elements after skipping first n elements
		System.out.println("\nSkip of 2 :");
		numbers.stream().skip(2).forEach(i -> System.out.println(i));

	}
}
