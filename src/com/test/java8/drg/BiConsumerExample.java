package com.test.java8.drg;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		EmployeeDetails emp=new EmployeeDetails("Siddu", 10000);
		BiConsumer<EmployeeDetails, Integer> salIncr = (employee, sal) -> employee.salary = employee.salary + sal;
		salIncr.accept(emp, 500);
		System.out.println(emp);
	}

}

class EmployeeDetails {
	String name;
	Integer salary;

	public EmployeeDetails(String name, Integer salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}
