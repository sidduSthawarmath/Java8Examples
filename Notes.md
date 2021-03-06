Concepts covered
----------------
1.Lambda Expression
2.FunctionalInterface
3.Default methods and static methods
4.Predefined function interfaces
    a.Predicate
    b.Function
    c.Consumer
    d.Supplier
  For two arguments BiPredicate,BiFunction and BiConsumer
5.Optional class
6.Reduce
7.Streams
	a.Creating Java Streams
	b.Converting Java Stream to Collection or Array
	c.Java Stream Intermediate Operations
	d.Java Stream Terminal Operations  
    e.Java Stream Short Circuiting Operations










Lambda expression:
----------------------------------------
Lambda expression is 
	- Not having modifiers(such as public, private & protected)
	- Not having return type(void, int, float)
	- Not having even function name also

Example : 
    public void add(int a, int b)
	    {
	    retun a+b;
	    }
    
    In Lambda exp:
    (a,b)->a+b;
 
    
    
    
Functional interface:
----------------------------- 
 Functional interface is a interface it should have only one abstract method
 and it may or may not have static or default methods. 
 (Example: Runnable, Comparator, Comparable)
	 - @FunctionalInterface indicate that interface should rules of the functional
		interface
     - Functional interface should have only One abstract method
     - It may have N number of default and static methods
     - Functional interface have extends of some other interface also but
       condition is that if its parent already have One abstract methods
       then it should not have abstract method.
       
       
  Example :
  
		public class FunctionalInterfaceExample {
			public static void main(String[] args) {
				Message message = (name) -> System.out.println("Welcome to java8 " + name);
				message.welcomeMsg("Siddu");
			}
		}
				
		@FunctionalInterface
		interface Message {
			public void welcomeMsg(String name);
		}
       
       output:
       Welcome to java8 Siddu
       
       
 
 Default Methods(Virtual extension methods/Defender methods):
 ------------------
 Until JDK 1.7 Version
 	void m1();
 	public void m1();
 	abstract void m1();
 	public abstract void m1();
 	
 	
In JDK 1.8 version onwards
	Related to methods:
	    in jdk1.8 : default methods are allowed and static methods are also allowed
	    in jdk1.9 : private methods are also allowed
	    
	Related to variables:
	     public static final always in JDK 1.7, 1.8 & 1.9 also
	
	
	 Without affecting implementation classes, if we want to add new
	 method to the interface then we should go for default method concept.
	 
	 
	 Example:
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
	 
	 		output:
	        This is default method overrided method
	        
	        
	      Note:
	         - default is not a modifier
	         - While overriding default method child class method should have modifier
	         	as public only otherwise it gives compilation error
	         - We can't declare or define default method as methods of the object class
	           (Example : hashcode(), wait(), toString() etc)
	           it gives compilation error because child classes already having the
	           these method from Object class so it will not take from interface.
	     
	     
     If default method are present in two interfaces with same name and child class
     implements both interfaces then child class must override default method.
     if we need to call any default method of the interface in child class
     then we can use syntax like
     
     <inetrfaceName>.super.<methodName>  
      
      interface A	                  interface B           
	   m1(){ Sysout("A method") }            m1(){Sysout("B method")}
	       \                           /
	        \                         /
	          \                      /
		             interface c
		              m1()
		              {
		              A.super.m1();  //prints as output "A method"
		              B.super.m1();  //Prints as output "B method"
		              }
		              
		              
static methods
------------------------------
  - class vs interface
       interface is not heavy weight component as compared to class because 
       it never contains constructor block, static block, instance block
       
  - static method are no where related to object. In such cases instead of going class
  we can go for interface concept
     
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
		
    - In above example static method belongs to the interface it will not inherited to
      the child class. So if we want to call that method means we must and should use
      <interfaceName>.<staticMethodName> there is no other ways.
      
  
 Predefined functional interfaces(It should have only one abstract method)
 -------------------------------------
 	Predicate  (input any data type of value and always return boolean value)
 	Function   (input take any data type of value and returns any data type of value not boolean )
 	Consumer   (input takes any data type but not returns any value)
 	Supplier
 	
      Two argument predefined functional interfaces:
      -----------------------------------------------
      BiPredicate
      BiFunction
      BiConsumer
      BiSupplier
      
      Primitive predefined functional interfaces:
      ---------------------------------------------
	  IntPredicate
	  IntFunction
	  IntConsumer
	  ...
	  
	  
Predicate :
----------	
   Predicate is used for check the condition.
   Method :
       public boolean test(T t);
     
     Example 1: check even or odd number
		public class PredicateExample {
			public static void main(String[] args) {
				Predicate<Integer> predicate = num -> num % 2 == 0;
				System.out.println("10 is even number : " + predicate.test(10));
				System.out.println("5 is even number : " + predicate.test(5));
			}
		}
     
     output:
        10 is even number : true
		5 is even number : false


    Example 2: check employee salary is greate than 50k and gender is Male
            Predicate<Employee> predicate = e -> e.getSalary()>50000 && e.getGender().equals("M");
            predicate.test(e);      
   
   
     Predicate Joining:
     ------------------
     We can combine multiple of predicate to to check the condition -> predicate joining
     
     Example:
    	predicate p1 -> Check the number is even or not
    	predicate p2- > checks the number is greater than 20
       
       we can join as:
        'and' is check both should be true
         	p1.and(p2).test(10);
        
        'or' check if any one of the true
        	p1.or(p2).test(10);
        
        'negate' gives the reverse result
        	p1.negate()
        
   
   
	  Example :
			 public class PredicateJoiningExample {
					public static void main(String[] args) {
						int[] num = { 10, 5, 12, 6, 21 };
						// Number is even predicate
						Predicate<Integer> evenNumCheck = n -> n % 2 == 0;
				
						// Num is greater than 10 predicate
						Predicate<Integer> numGreaterThan10 = n -> n > 10;
				
						for (int n : num) {
				
							// 'and' Predicate joining
							if (evenNumCheck.and(numGreaterThan10).test(n)) {
								System.out.println("Number is even and greater than 10:" + n);
							}
				
							// 'or' Predicate joining
							if (evenNumCheck.or(numGreaterThan10).test(n)) {
								System.out.println("Number may be even or greater than 10:" + n);
							}
						}
					}
				}
	  
	  	
		   output:
		   			Number is even and greater than 10:12
					Number may be even or greater than 10:10
					Number may be even or greater than 10:12
					Number may be even or greater than 10:6
					Number may be even or greater than 10:21
					       
       
       
Function:
--------------
  we need to pass some input and perform some operations and produce some result but result should not be
  boolean(Because for boolean result we have Predicate functional result)  then we should go for function.
  
  Method:
     public R apply(T t);
            
  Example 1:
   
		//Print string into upper case
		//Print string length
		//Print number as its square
		public class FunctionExm {
			public static void main(String[] args) {
		
				Function<String, String> upperCaseFunction = letter -> letter.toUpperCase();
				System.out.println("Print java in upper case letter : " + upperCaseFunction.apply("Siddu"));
		
				Function<String, Integer> findLengthFunction = letter -> letter.length();
				System.out.println("Number of letters 'Welcome to java' :" + findLengthFunction.apply("Welcome to java"));
		
				Function<Integer, Integer> squareNumFunction = num -> num * num;
				System.out.println("Square of '5' :" + squareNumFunction.apply(5));
		
			}
		
		}
		
   	    output:
   	     Print java in upper case letter : SIDDU
		 Number of letters 'Welcome to java' :15
		 Square of '5' :25
   	     
   	     
   	     
   	 Example 2: Find grade of the student
   	 
		 public class GradeOfStudent {
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
		
				// Finding the Grade of the student
				System.out.println("Result: " + findGradeFunction.apply(new Student("Siddu", 90)));
		
			}
		
		}
		
		class Student {
			String name;
			int marks;
			public Student(String name, int marks) {
				this.name = name;
				this.marks = marks;
			}
		}
		   	 	    
        
        output:
        	    Result: FirstClass
       
       
     
   Function chaining:
   -----------------
    	Two functions can be combined to form more complex function.
       
       i. f1.andThen(f2).apply(i);
       	   Here f1 function first executed and result will be used as input for f2 function 
       
       ii. f1.compose(f2).apply(i);
            Here f2 function first executed and result will be used as input for f1 function
            
       
       Example :
				public class FunctionChainingExample {
					public static void main(String[] args) {
						Function<Integer, Integer> multiflyBy2Fun = num -> num * 2;
						Function<Integer, Integer> squareNum = num -> num * num;
						
						//Here f1 function first executed and result will be used as input for f2 function 
						System.out.println("Example of andThen :"+multiflyBy2Fun.andThen(squareNum).apply(2));
					
						//Here f2 function first executed and result will be used as input for f1 function
						System.out.println("Example of compose :"+multiflyBy2Fun.compose(squareNum).apply(2));
						
					}
				}     
          
           output :
       				Example of andThen :16
					Example of compose :8
       
       
       

Consumer
-----------
  	
  	Consumer always going to take some input value and won't return any value 
  
	Method:
	 
	 public void accept(T t);
       
       
       Example : print student grade
        
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
        
       
       output :
              Result: FirstClass
        		
       
       
 Consumer Chaining
 ---------------------
    Multiple consumer calling one by one
    
    
    Example: 
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
				Consumer<Movie> MovieNextVersion = movie -> System.out.println(movie.movieName + " movie next part also coming");
				
				//Consumer chaining
				Consumer<Movie> consumerChaining = releaseMovie.andThen(MovieReview).andThen(MovieNextVersion);
		
				consumerChaining.accept(new Movie("OM"));
		
			}
		}
		
		
		output:
				OM movie got released
				OM movie is running 100 days
				OM movie next part also coming
				


Supplier:
------------
   It will supply my required object without taking any input.
   
   Method:
      
      public R get();
      
      
      Example: OTP generation
      
		public class SupplierExample {
			public static void main(String[] args) {
				Supplier<String> generateOTP = () -> {
					String otp = "";
					for (int i = 0; i < 6; i++) {
						otp = otp + (int) (Math.random() * 10);
					}
					return otp;
				};
		
				System.out.println("Generated OTP: " + generateOTP.get());
				System.out.println("Generated OTP: " + generateOTP.get());
			}
		}
		
		output:
				Generated OTP: 407149
				Generated OTP: 063823
				      
		      
    
    
    Two argument  functional interface
    ---------------------------------
    
    BiPredicate:
    --------------
	    Normal predicate can take only one input argument and perform some conditional check.
	    Sometime our program requirement is we have to take two input argument and perform some conditional check
	    for these we should go for BiPredicate. BiPredicate is exactly same as predicate but it will take two argument. 
	      
      Method:
         public boolean test(T1 t1, T2 t2);
       
       Example: Some of two number is even or not
        
                public class BiPredicateExample {
					public static void main(String[] args) {
						BiPredicate<Integer,Integer> evenOrNotPredicate=(n1,n2)->(n1+n2)%2==0;
						System.out.println(evenOrNotPredicate.test(10,20));
						System.out.println(evenOrNotPredicate.test(7,2));
					}
				}
		     
		     output:
		         true
		         false
        
   				
	
	BiFunction:
	-----------
	  It will take two argument and returns the results
	  
	  Method:
	   public R apply(T1 t1,T2 t2);
	   
	   
	   Example: Take name and phone num as argument and return employee object.
	   
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
	  
        
          output:
              Employee [name=Siddu, phoneNum=123456789]
              
       
       
       
       BiCosumer
       ---------
       
       Method:
        
        public void accept(T1 t1,T2 t2)
        
        
        Example: Take employee Details and increment salary
   
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
		
		
		output:
			Employee [name=Siddu, salary=10500]
			
			
			
Optional
----------
	Java Optional is a container object which may or may not contain a non-null value. 
If a value is present, isPresent() will return true and get() will return the value. 
Stream terminal operations return Optional object. 

	Some of these methods are:
	1.Optional<T> reduce(BinaryOperator<T> accumulator)
	2.Optional<T> min(Comparator<? super T> comparator)
	3.Optional<T> max(Comparator<? super T> comparator)
	4.Optional<T> findFirst()
	5.Optional<T> findAny()
	
	
	public class OptionalExm {
		public static void main(String[] args) {
			List<Integer> intValList= Arrays.asList(4,1,4,6,8,3);
			
			//Optional<T> reduce(BinaryOperator<T> accumulator)
			Optional<Integer> additionVal= intValList.stream().reduce(Integer::sum);
			System.out.println(additionVal.get());  //prints 26 (i.e sum of all elements)
			
			
			//Optional<T> min(Comparator<? super T> comparator)
			Optional<Integer> minVal=intValList.stream().min(Comparator.naturalOrder());
			System.out.println(minVal.get());  // prints 1
			
		}
}



Reduce
--------
	Reducing in the context of Java8 Streams refers to the process of combining all elements in the stream 
repeatedly to produce a single value which is returned as the result of the reduction operation.

Example :
	public class ReduceExample {
		public static void main(String[] args) {
			List<Integer> numbers = Arrays.asList(1, 5, 2, 4);
	
			// Find max element
			int maxNum = numbers.stream().reduce((x, y) -> x >= y ? x : y).get();
			System.out.println("maxNum : " + maxNum);
	
			// Find min element
			int minNum = numbers.stream().reduce((x, y) -> x <= y ? x : y).get();
			System.out.println("minNum : " + minNum);
	
			// Find sum of all element
			int sumOfAll = numbers.stream().reduce((x, y) -> x + y).get();
			System.out.println("sumOfAll : " + sumOfAll);
	
		}
	}
	
	output:
		maxNum : 5
		minNum : 1
		sumOfAll : 12
			
	

Streams:
---------------------------------
	
	Creating Java Streams
	---------------------
		public class StreamCreationExample {
			public static void main(String[] args) {
		
				// By Stream.Of()
				Stream<Integer> intStream = Stream.of(1, 2, 4, 6);
				intStream.forEach(i -> System.out.print(i + " "));
				System.out.println("\n-------\n");
		
				// By Array
				Integer[] intArray = { 1, 2, 4, 6 };
				Stream<Integer> intArrayStream = Stream.of(intArray);
				intArrayStream.forEach(i -> System.out.print(i + " "));
				System.out.println("\n-------\n");
		
				// By collections
				List<String> namesList = Arrays.asList("Siddu", "Shivu", "Sharnu");
				Stream<String> namesStream = namesList.stream();
				namesStream.forEach(name -> System.out.println(name));
		
				// We can use Stream.generate() and Stream.iterate() methods to create Stream.
				Stream<String> stream1 = Stream.generate(() -> {return "abc";});
				Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
			}
		}



Converting Java Stream to Collection or Array
----------------------------------------------
	We can use java Stream collect() method to get List, Map or Set from stream.
     
     public class ConvertingClassToCollectionOrArray {
		public static void main(String[] args) {
	
			List<Integer> intNumber = Arrays.asList(1, 20, 3, 11, 5, 6, 8);
	
			// Collect even number into separate list from the above list
			List<Integer> evenNumList = intNumber.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
			System.out.println(evenNumList);
	
			// Collect odd number into separate set from the above list
			Set<Integer> oddNumSet = intNumber.stream().filter(num -> num % 2 != 0).collect(Collectors.toSet());
			System.out.println(oddNumSet);
	
			// Square of each element from the above list
			Map<Integer, Integer> squareOfNumber = intNumber.stream().collect(Collectors.toMap(i -> i, i -> i * i));
			System.out.println(squareOfNumber);
	
			// converting list integer to array of integer
			Integer[] intArray = intNumber.stream().toArray(Integer[]::new);
			System.out.println(Arrays.toString(intArray));
		}
	}
     



Java Stream Intermediate 
-------------------------------------------------
	Java Stream API operations that returns a new Stream are called intermediate operations.
Most of the times, these operations are lazy in nature, so they start producing new stream elements and 
send it to the next operation. Intermediate operations are never the final result producing operations.
Commonly used intermediate operations are 
	1.filter
	2.sorted
	3.map
	4.flatMap

1.Filter: 
-----------
 	When we want to apply any condition or predicate on stream of elements then we will use Filters

2.sorted :
----------
 	When we want to sort the stream or apply the comparator on that then we will use sorted
 	

3.map :
--------
 When we want to apply any function on stream(stream should return single value) of elements then we will use map
  
4.flatMap :
--------
	The function used by map operation returns a Stream of values or list of values rather than single value, 
that's why we need flattening. When you flat a Stream of Stream, it gets converted into Stream of values.

	
	Example:
	
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
			
					
					//Converts the elements into double, int, long 
					//i.e  mapToDouble, mapToInt and mapToLong for map
					// flatMapToDouble, flatMapToInt and flatMapToLong for flatMap
					System.out.println("\n---- mapToDouble---");
					numList.stream().mapToDouble(num -> {
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
				
				
	output:
				
				----Filter-------
				5
				3
				15
				35
				
				----Map-------
				4
				10
				6
				30
				70
				
				---- mapToDouble---
				4.0
				10.0
				6.0
				30.0
				70.0
				
				----Sorted-------
				
				Ascending Oder:
				2
				3
				5
				15
				35
				
				Descending Oder:
				35
				15
				5
				3
				2
				
				Custom Comparator by lambda expression:
				2
				3
				5
				15
				35
				
				Custom Comparator by class:
				2
				3
				5
				15
				35
				-------------------------------------
				--------Flat Map----------
				Team A & B :[[Siddu, Shivu], [Mahesh, Sharnu]]
				combinedSingleTeam :[Siddu]
					



Terminal Operations
----------------------
	Once the terminal method is called on a stream, it consumes the stream and after that we cant use stream. 
Terminal operations are eager in nature i.e they process all the elements in the stream before returning 
the result. 
Commonly used terminal methods are : 
	forEach
	toArray, 
	min, 
	max, 
	findFirst, 
	anyMatch, 
	allMatch etc.
	
	You can identify terminal methods from the return type, they will never return a Stream.
	
	Example:
	
		public class StreamTerminalOperations {
				public static void main(String[] args) {
			
					List<Integer> numbers = Arrays.asList(5, 1, 2, 4, 10, 7);
			
					// for each
					System.out.println("For Each");
					numbers.stream().forEach(num -> System.out.println(num));
			
					// min
					Optional<Integer> minNum = numbers.stream().min(Comparator.naturalOrder());
					System.out.println("\nMin Num:" + minNum.get());
			
					// max
					Optional<Integer> maxNum = numbers.stream().max(Comparator.naturalOrder());
					System.out.println("\nMax Num:" + maxNum.get());
			
					// Checks the first element which is greater the 5(it won't check for
					// sorting order)
					// It will get first occurred element only
					Optional<Integer> firstOccEle = numbers.stream().filter(num -> num > 5).findFirst();
					System.out.println("\nFind First:" + firstOccEle.get());
			
					// Checks the first element which is greater the 5(it won't check for
					// sorting order)
					// It wont check for first occurrence, Randomly it will get element
					Optional<Integer> existedEle = numbers.stream().filter(num -> num > 5).findFirst();
					System.out.println("\nFind Any:" + existedEle.get());
			
					//All the element should match the condition then it returns true
					boolean allAreEvenNumber = numbers.stream().allMatch(num -> num % 2 == 0);
					System.out.println("\nAll are even numbers in the List:" + allAreEvenNumber);
			
					//If any one element match then it returns true
					boolean isAnyEvenNumber = numbers.stream().anyMatch(num -> num % 2 == 0);
					System.out.println("\nIs any even numbers in the List:" + isAnyEvenNumber);
			
					//None of the element should match the condition then only it returns true 
					boolean noneEvenNumber = numbers.stream().noneMatch(num -> num % 2 == 0);
					System.out.println("\nNone number is even number in the List:" + noneEvenNumber);
					
					//Converts the stream to array of elemnts
					int[] numArray= numbers.stream().mapToInt(i->i.intValue()).toArray();
					System.out.println("\ntoArray:"+Arrays.toString(numArray));
					
				}
			}

	output:
			For Each
			5
			1
			2
			4
			10
			7
			
			Min Num:1
			
			Max Num:10
			
			Find First:10
			
			Find Any:10
			
			All are even numbers in the List:false
			
			Is any even numbers in the List:true
			
			None number is even number in the List:false
			
			toArray:[5, 1, 2, 4, 10, 7]






Java Stream Short Circuiting Operations
----------------------------------------
An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream.
	1.limit()
	2.skip()
	
	
		public class StreamShortCircuitingOperations {
			public static void main(String[] args) {
		
				List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
				// The limit(long n) method of java.util.stream.Stream object returns a
				// reduced stream of first n elements
				System.out.println("Limit of 2 :");
				numbers.stream().limit(2).forEach(i -> System.out.println(i));
		
				
				// Stream of remaining elements after skipping first n elements
				System.out.println("\nSkip of 2 :");
				numbers.stream().skip(2).forEach(i -> System.out.println(i));
		
			}
		}
		
	output :
		Limit of 2 :
			1
			2
			
		Skip of 2 :
			3
			4
			5
			6
	

ParallelStream:
----------------		
 	Parallel stream enables parallel computing that involves processing
   elements concurrently in parallel with each element in a separate thread.
   But this does not guarantee high performance and faster execution
   every time. It again depends on the number of CPU cores available.

   ParallelStream has a much higher overhead compared to a sequential
   one.Parallel stream should be used only when there is a huge amount of
   elements to process and there is a performance problem with processing
   these elements. Also the parallel stream operations should be independent



