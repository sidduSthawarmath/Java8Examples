package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Siddu", "Sharnu", "Mahesh", "Ganesh", "Ram");

		// Print elements in sequential order
		System.out.println("----Sequential Stream--");
		names.stream().forEach(name -> System.out.println(name));

		// Prints all the elements but order is no guaranty
		System.out.println("----Parallel Stream--");
		names.stream().parallel().forEach(name -> System.out.println(name));

		System.out.println("------To check performance-----------");

		// =new ArrayList<>();//Arrays.asList(10,3,5,6,8,9,7);

		int[] numbers = IntStream.range(1, 100).map((x) -> {
			return (int) Math.random() * 100;
		}).toArray();

	Stream.of(numbers).mapToInt(x-> x). filter().collect(Collectors.toList());	
		
	}
}
