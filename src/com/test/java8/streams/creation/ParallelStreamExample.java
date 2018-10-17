package com.test.java8.streams.creation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
	}
}
