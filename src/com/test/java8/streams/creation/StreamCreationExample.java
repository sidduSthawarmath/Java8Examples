package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExample {
	public static void main(String[] args) {

		// By Stream.Of()
		Stream<Integer> intStream = Stream.of(1, 2, 4, 6);
		intStream.forEach(i -> System.out.print(i + " "));
		System.out.println("\n-------\n");

		// By Array
		Integer[] intArray = { 1, 2, 4, 6 };
		Stream<Integer> intArrayStream = Stream.of(intArray);
		intArrayStream.forEach(i -> System.out.print(i + " "));
		System.out.println("\n-------\n");

		// By collections
		List<String> namesList = Arrays.asList("Siddu", "Shivu", "Sharnu");
		Stream<String> namesStream = namesList.stream();
		namesStream.forEach(name -> System.out.println(name));

		// Stream generate
		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		//Stream<String> stringStreeam = Stream.generate(() -> "dasdada");
		//stream1.forEach(str->System.out.printf(str));


		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
		stream2.forEach(s->System.out.println(s));
		
		//We can use Stream.generate() and Stream.iterate() methods to create Stream.
		
	}
}
