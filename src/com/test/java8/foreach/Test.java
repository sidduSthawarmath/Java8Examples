package com.test.java8.foreach;

import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {

		// Square Of the value
		Function<Integer, Integer> squarFunction = i -> i * i;
		System.out.println(squarFunction.apply(5));
		System.out.println(squarFunction.apply(10));

		// Even or not
		Predicate<Integer> isEvenNumber = num -> num % 2 == 0;
		System.out.println(isEvenNumber.test(2));

	}

}
