package com.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SortFindFirstExample {

	public static void main(String[] args) {

		List intNumbers = Arrays.asList(100, 30, 8, 18);
		Optional firstNum = intNumbers.stream().sorted().findFirst();
		System.out.println(firstNum.get());

	}

}
