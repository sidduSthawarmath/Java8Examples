package com.test.java8.drg;

import java.util.function.Consumer;

class Movie {
	String movieName;
	public Movie(String movieName) {
		this.movieName = movieName;
	}
}

public class ConsumerChainingExample {

	public static void main(String[] args) {

		Consumer<Movie> releaseMovie = movie -> System.out.println(movie.movieName + " movie got released");
		Consumer<Movie> MovieReview = movie -> System.out.println(movie.movieName + " movie is running 100 days");
		Consumer<Movie> MovieNextVersion = movie -> System.out
				.println(movie.movieName + " movie next part also coming");
		
		//Consumer chaining
		Consumer<Movie> consumerChaining = releaseMovie.andThen(MovieReview).andThen(MovieNextVersion);

		consumerChaining.accept(new Movie("OM"));

	}
}
