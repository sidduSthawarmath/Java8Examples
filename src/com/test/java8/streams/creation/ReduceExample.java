package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 5, 2, 4);

		// Find max element
		int maxNum = numbers.stream().reduce((x, y) -> x >= y ? x : y).get();
		System.out.println("maxNum : " + maxNum);

		// Find min element
		int minNum = numbers.stream().reduce((x, y) -> x <= y ? x : y).get();
		System.out.println("minNum : " + minNum);

		// Find sum of all element
		int sumOfAll = numbers.stream().reduce((x, y) -> x + y).get();
		System.out.println("sumOfAll : " + sumOfAll);

	}
}
