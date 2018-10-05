package com.test.java8.drg;

import java.util.function.Predicate;

public class PredicateJoiningExample {
	public static void main(String[] args) {
		int[] num = { 10, 5, 12, 6, 21 };
		// Number is even predicate
		Predicate<Integer> evenNumCheck = n -> n % 2 == 0;

		// Num is greater than 10 predicate
		Predicate<Integer> numGreaterThan10 = n -> n > 10;

		for (int n : num) {

			// 'and' Predicate joining
			if (evenNumCheck.and(numGreaterThan10).test(n)) {
				System.out.println("Number is even and greater than 10:" + n);
			}

			// 'or' Predicate joining
			if (evenNumCheck.or(numGreaterThan10).test(n)) {
				System.out.println("Number may be even or greater than 10:" + n);
			}
		}
	}
}
