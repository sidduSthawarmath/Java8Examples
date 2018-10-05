package com.test.java8.drg;

import java.util.function.BiPredicate;

//Check some of two number is even or not
public class BiPredicateExample {
	public static void main(String[] args) {
		BiPredicate<Integer,Integer> evenOrNotPredicate=(n1,n2)->(n1+n2)%2==0;
		System.out.println(evenOrNotPredicate.test(10,20));
		System.out.println(evenOrNotPredicate.test(7,2));
	}
}
