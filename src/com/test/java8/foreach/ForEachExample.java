
package com.test.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Suresh");
		names.add("Ganesh");
		names.add("Raghav");
		names.add("Raj");

		//Display all names
		names.forEach(name -> System.out.println(name));
	}
}
