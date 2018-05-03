package com.test.java8.inputstream.example;

import java.util.stream.IntStream;


//Print number using range and skip initial specified number
public class PrintNumberByRangeAndSkip {
public static void main(String[] args) {
	//it take 1 to 10 number and skips up to 5 number then prints remaining(6,7,8,9)  
	IntStream.range(1, 10).skip(5).forEach(num->System.out.println(num));
}
}
