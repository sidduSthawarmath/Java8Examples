package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTerminalOperations {
	public static void main(String[] args) {


		// for each
		numbers.stream().forEach(num -> System.out.print(num));

		// min
		Optional<Integer> minNum = numbers.stream().min(Comparator.naturalOrder());
		System.out.println("\nMin Num:" + minNum.get());

		// max
		Optional<Integer> maxNum = numbers.stream().max(Comparator.naturalOrder());
		System.out.println("\nMax Num:" + maxNum.get());
		
		
		Optional<Integer>  .stream().findFirst();
		

	}
}
