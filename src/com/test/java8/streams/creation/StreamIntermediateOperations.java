package com.test.java8.streams.creation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntermediateOperations {

	public static void main(String[] args) {

		List<Integer> numList = Arrays.asList(2, 5, 3, 15, 35);

		System.out.println("\n----Filter-------");
		/* filter -> We can use filter() method to apply predicate */
		numList.stream().filter(num -> num % 2 != 0).forEach(i -> System.out.println(i));

		System.out.println("\n----Map-------");
		/* map -> We can use map to apply the function on the stream */
		numList.stream().map(num -> {
			return num * 2;
		}).forEach(i -> System.out.println(i));

		System.out.println("\n----Sorted-------");

		/*
		 * Sorted -> We can use sorted() to sort the stream elements by passing
		 * Comparator argument.
		 */

		// Ascending
		System.out.println("\nAscending Oder:");
		numList.stream().sorted().forEach(i -> System.out.println(i));

		System.out.println("\nDescending Oder:");
		numList.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println(i));

		System.out.println("\nCustom Comparator by lambda expression:");
		numList.stream().sorted((Integer num1, Integer num2) -> {
			if (num1 > num2)
				return 1;
			else if (num1 < num2)
				return -1;
			else
				return 0;
		}).forEach(i -> System.out.println(i));

		System.out.println("\nCustom Comparator by class:");
		numList.stream().sorted(new CustomComparator()).forEach(i -> System.out.println(i));

		System.out.println("-------------------------------------");

		System.out.println("--------Flat Map----------");
		List<String> teamA = Arrays.asList("Siddu", "Shivu");
		List<String> teamB = Arrays.asList("Mahesh", "Sharnu");

		List<List<String>> teams = new ArrayList<>();
		teams.add(teamA);
		teams.add(teamB);
		System.out.println("Team A & B :" + teams);

		// Using Stream flatMap(Function maper)
		/*
		 * the function used by map operation returns a Stream of values or list
		 * of values rather than single value, that's why we need flattening.
		 * When you flat a Stream of Stream, it gets converted into Stream of
		 * values.
		 */

		// Here selecting name of the player by each team considering name
		// should have only 5 characters and among these selected name
		// considering name starts with "Si"
		List<String> combinedSingleTeam = (List<String>) teams.stream()
				.flatMap(list -> list.stream().filter(name -> name.length() == 5)).filter(name -> name.startsWith("Si"))
				.collect(Collectors.toList());
		System.out.println("combinedSingleTeam :" + combinedSingleTeam);
	}
}
