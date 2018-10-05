package com.test.java8.drg;

interface Interf {
	default void m1() {
		System.out.println("This is default method");
	}
}

public class DefaultMethodsExample implements Interf {
	public void m1() {
		System.out.println("This is default method overrided method");
	}
	public static void main(String[] args) {
		Interf interf = new DefaultMethodsExample();
		interf.m1();
	}
}
