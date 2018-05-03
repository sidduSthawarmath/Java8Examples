package com.test.java8.inputstream.example;

import java.util.stream.IntStream;


//This program will print the number as specified range
public class PrintNumberByRange {

	public static void main(String[] args) {

		//Prints 1 to 9 number (10 will be excluded)
		IntStream.range(1, 10).forEach(num->System.out.println(num));
		
	}
}
