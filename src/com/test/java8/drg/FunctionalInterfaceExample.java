package com.test.java8.drg;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		Message message = (name) -> System.out.println("Welcome to java8 " + name);
		message.welcomeMsg("Siddu");
	}
}

// - Functional interface is a interface it should have only one abstract method
// and it may or may not have static or default methods. (Example: Runnable,
// Comparator, Comparable)
// - @FunctionalInterface indicate that interface should rules of the functional
// interface
// - Functional interface should have only One abstract method
// - It may have N number of default and static methods
// - Functional interface have extends of some other interface also but
// condition is that if its parent already have One abstract methods
// then it should not have abstract method.
@FunctionalInterface
interface Message {
	public void welcomeMsg(String name);
}
