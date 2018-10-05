package com.test.java8.drg;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		Predicate<Integer> predicate = num -> num % 2 == 0;
		System.out.println("10 is even number : " + predicate.test(10));
		System.out.println("5 is even number : " + predicate.test(5));
	}
}
