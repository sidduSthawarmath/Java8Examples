package com.test.java8.streams.creation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTerminalOperations {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(5, 1, 2, 4, 10, 7);

		// for each
		System.out.println("For Each");
		numbers.stream().forEach(num -> System.out.println(num));

		// min
		Optional<Integer> minNum = numbers.stream().min(Comparator.naturalOrder());
		System.out.println("\nMin Num:" + minNum.get());

		// max
		Optional<Integer> maxNum = numbers.stream().max(Comparator.naturalOrder());
		System.out.println("\nMax Num:" + maxNum.get());

		// Checks the first element which is greater the 5(it won't check for
		// sorting order)
		// It will get first occurred element only
		Optional<Integer> firstOccEle = numbers.stream().filter(num -> num > 5).findFirst();
		System.out.println("\nFind First:" + firstOccEle.get());

		// Checks the first element which is greater the 5(it won't check for
		// sorting order)
		// It wont check for first occurrence, Randomly it will get element
		Optional<Integer> existedEle = numbers.stream().filter(num -> num > 5).findFirst();
		System.out.println("\nFind Any:" + existedEle.get());

		//All the element should match the condition then it returns true
		boolean allAreEvenNumber = numbers.stream().allMatch(num -> num % 2 == 0);
		System.out.println("\nAll are even numbers in the List:" + allAreEvenNumber);

		//If any one element match then it returns true
		boolean isAnyEvenNumber = numbers.stream().anyMatch(num -> num % 2 == 0);
		System.out.println("\nIs any even numbers in the List:" + isAnyEvenNumber);

		//None of the element should match the condition then only it returns true 
		boolean noneEvenNumber = numbers.stream().noneMatch(num -> num % 2 == 0);
		System.out.println("\nNone number is even number in the List:" + noneEvenNumber);
		
		//Converts the stream to array of elemnts
		int[] numArray= numbers.stream().mapToInt(i->i.intValue()).toArray();
		System.out.println("\ntoArray:"+Arrays.toString(numArray));
		
	}
}
