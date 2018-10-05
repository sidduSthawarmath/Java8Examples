package com.test.java8.drg;

interface StaticMethodDemo {
	public static void display() {
		System.out.println("This is static method");
	}
}

public class StaticMethodsExample implements StaticMethodDemo {
	public static void main(String[] args) {
		StaticMethodDemo.display();
	}
}
