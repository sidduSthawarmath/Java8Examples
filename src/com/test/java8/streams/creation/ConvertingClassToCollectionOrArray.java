package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertingClassToCollectionOrArray {

	public static void main(String[] args) {

		List<Integer> intNumber = Arrays.asList(1, 20, 3, 11, 5, 6, 8);

		// Collect even number into separate list from the above list
		List<Integer> evenNumList = intNumber.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumList);

		// Collect odd number into separate set from the above list
		Set<Integer> oddNumSet = intNumber.stream().filter(num -> num % 2 != 0).collect(Collectors.toSet());
		System.out.println(oddNumSet);

		// Square of each element from the above list
		Map<Integer, Integer> squareOfNumber = intNumber.stream().collect(Collectors.toMap(i -> i, i -> i * i));
		System.out.println(squareOfNumber);

		// converting list integer to array of integer
		Integer[] intArray = intNumber.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));

	}
}
