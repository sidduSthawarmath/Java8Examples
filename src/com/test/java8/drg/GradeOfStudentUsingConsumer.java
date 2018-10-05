package com.test.java8.drg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GradeOfStudentUsingConsumer {
	
	public static void main(String[] args) {

		// Predicate Declarations
		Predicate<Integer> firstClass = marks -> marks >= 60;
		Predicate<Integer> secondClass = marks -> marks >= 50;
		Predicate<Integer> thirdClass = marks -> marks >= 35;

		// Function declaration
		Function<Student, String> findGradeFunction = student -> {
			if (firstClass.test(student.marks)) {
				return "FirstClass";
			} else if (secondClass.test(student.marks)) {
				return "secondClass";
			} else if (thirdClass.test(student.marks)) {
				return "thirdClass";
			} else {
				return "Fail";
			}

		};

		// Consumer for printing the result
		Consumer<Student> printStudent = student -> {
			System.out.println("Result: " + findGradeFunction.apply(student));
		};

		// Consumer called for result verification
		printStudent.accept(new Student("Siddu", 90));
	}

}
