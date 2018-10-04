package com.test.java8.drg;

/*Lambda expression is 
	- Not having modifiers(such as public, private & protected)
	- Not having return type(void, int, float)
	- Not having even function name also
*/

public class LambdExp {
	public static void main(String[] args) {
		// No need to maintain argument type(Example passing a,b)
		// for Single line no need to add { and } brackets
		// No need to add return type if we have not written in { and } brackets
		Calculate calculate = (a, b) -> a + b;
		System.out.println("Addition Of  10 and 20 is:" + calculate.add(10, 20));
	}
}
@FunctionalInterface
interface Calculate {
	public int add(int a, int b);
}
