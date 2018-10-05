package com.test.java8.drg;

import java.util.function.Function;

public class FunctionChainingExample {
	public static void main(String[] args) {
		Function<Integer, Integer> multiflyBy2Fun = num -> num * 2;
		Function<Integer, Integer> squareNum = num -> num * num;
		
		//Here f1 function first executed and result will be used as input for f2 function 
		System.out.println("Example of andThen :"+multiflyBy2Fun.andThen(squareNum).apply(2));
	
		//Here f2 function first executed and result will be used as input for f1 function
		System.out.println("Example of compose :"+multiflyBy2Fun.compose(squareNum).apply(2));
		
	}
}
