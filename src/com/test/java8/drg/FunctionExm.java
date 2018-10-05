package com.test.java8.drg;

import java.util.function.Function;

//Print string into upper case
//Print string length
//Print number as its square
public class FunctionExm {
	public static void main(String[] args) {

		Function<String, String> upperCaseFunction = letter -> letter.toUpperCase();
		System.out.println("Print java in upper case letter : " + upperCaseFunction.apply("Siddu"));

		Function<String, Integer> findLengthFunction = letter -> letter.length();
		System.out.println("Number of letters 'Welcome to java' :" + findLengthFunction.apply("Welcome to java"));

		Function<Integer, Integer> squareNumFunction = num -> num * num;
		System.out.println("Square of '5' :" + squareNumFunction.apply(5));

	}

}
