package com.test.java8.drg;

import java.util.function.BiFunction;



public class BiFunctionExample {
	public static void main(String[] args) {
		
        //Passing two String argument and return Employee
		BiFunction<String, String, Employee> getEmpFunction = (name, phoneNum) -> new Employee(name, phoneNum);
		
		System.out.println(getEmpFunction.apply("Siddu", "123456789"));
	}

}


class Employee {
	String name;
	String phoneNum;

	public Employee(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", phoneNum=" + phoneNum + "]";
	}
}