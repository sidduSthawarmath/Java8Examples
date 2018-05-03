package com.test.java8.inputstream.example;

import java.util.stream.IntStream;

//Calculate the sum of value as specified range
public class SumOfSpecifiedRange {

	public static void main(String[] args) {
	//takes range 1 to 3(excluding 3) and prints the sum value(In this case sum value is 3)
		int sum = IntStream.range(1, 3).sum();
		System.out.println(sum);
	}
}
