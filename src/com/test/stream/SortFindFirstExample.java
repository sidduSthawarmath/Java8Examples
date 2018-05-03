package com.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//Sort integer numbers and find out first number
public class SortFindFirstExample {

	public static void main(String[] args) {

		//Sort integer numbers and find out first number
		List intNumbers = Arrays.asList(100, 30, 8, 18);
		
		Optional firstNum = intNumbers.stream().sorted().findFirst();

		
		System.out.println(firstNum.get());

	}

}
