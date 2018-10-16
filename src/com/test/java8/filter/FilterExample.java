package com.test.java8.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExample {

	static List<Integer> NUMBERS = Arrays.asList(1, 5, 8, 3, 5);

	public static void main(String[] args) {

		// It will get the name first matched. It will checks orderly
		Optional<Integer> number = NUMBERS.stream().filter(num -> num == 5).findFirst();
		System.out.println("findFirst:" + number.get());

		// It will get the name first matched. It wont maintain order
		number = NUMBERS.stream().filter(num -> num == 5).findAny();
		System.out.println("findAny:" + number.get());

		// Sorted in ascending order
		List<Integer> sortedNum = NUMBERS.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedNum);

		// Distinct elements in a list
		sortedNum = NUMBERS.stream().distinct().collect(Collectors.toList());
		System.out.println(sortedNum);

		long count = NUMBERS.stream().count();
		System.out.println("Total Num Of elements:" + count);

		Predicate<Integer> predicate = num -> num == 8;
		boolean isEixts = NUMBERS.stream().anyMatch(predicate);
		System.out.println("8 num is exist:" + isEixts);
		
		
	}
}
