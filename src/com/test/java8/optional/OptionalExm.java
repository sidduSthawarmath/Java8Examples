package com.test.java8.optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OptionalExm {
	public static void main(String[] args) {
		List<Integer> intValList= Arrays.asList(4,1,4,6,8,3);
		
		//Optional<T> reduce(BinaryOperator<T> accumulator)
		Optional<Integer> additionVal= intValList.stream().reduce(Integer::sum);
		System.out.println(additionVal.get());
		
		
		//Optional<T> min(Comparator<? super T> comparator)
		Optional<Integer> minVal=intValList.stream().min(Comparator.naturalOrder());
		System.out.println(minVal.get());
		
	}
}