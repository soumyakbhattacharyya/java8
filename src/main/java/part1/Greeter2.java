package part1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import java8lambda.example.Person;

public class Greeter2 {

	public void greet(ActOfGreeting greeting) {
		greeting.perform();
	}

	public int add(AddFunction addFunction) {
		return addFunction.add(5, 6);
	}

	public static void main(String[] args) {

		Greeter2 greeter = new Greeter2();

		// HumbleActOfGreeting is an implementation of the behavior ActOfGreeting
		ActOfGreeting actOfGreeting = new HumbleActOfGreeting();

		// behavior is being passed as an argument to the method
		greeter.greet(actOfGreeting);

		// equivalent implementation
		ActOfGreeting actOfGreeting2 = () -> System.out.println("Hello World :-D");

		greeter.greet(actOfGreeting2);

		AddFunction addFunction = (i, j) -> {
			return i + j;
		};

		System.out.println(addFunction.add(8, 9));

		// Thread implementation

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("do an action inside a traditional thread");

			}
		});

		thread.start();

		Thread thread2 = new Thread(() -> System.out.println("do an action inside a new thread"));
		thread2.start();

		List<Person> peoples = Arrays.asList(new Person("Stefan", "Banach", 50), 
				                            new Person("Jean", "Bartik", 90),
				                            new Person("Subrahmanyan", "Chandrasekhar", 52),
				                            new Person("Hugh", "Beaver", 70), 
				                            new Person("Elizabeth", "Borg", 52)
				                           );
		                                    
		
		System.out.println("1st solution");
		// sort list by last name
		// anonymous inner class approach
		peoples.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		System.out.println(peoples);
		
		// convert to lambda expression
		// remove access modifier, name and return type
		peoples.sort((p1, p2) -> {
			return p1.getLastName().compareTo(p2.getLastName());
		});
		
		
		
		System.out.println("2nd solution");
		// create a method that prints all elements in the list
		peoples.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person person) {
				System.out.println(person);

			}
		});
		
		peoples.forEach((p) -> {System.out.println(p);});
		
		
		System.out.println("3rd solution");
		// create a method that prints all people whose last name starts with B
		peoples.forEach((p) -> {
			if (p.getLastName().startsWith("B")) {
				System.out.println(p);
			}
		});

	}

	// target behavior

	/**
	 * aVariable = public void myMethod(){ // further code logic}
	 * 
	 * public - makes sense if the method is a member of a class 
	 * name - is unnecessary 
	 * return type - can be guessed from the return statement of a function
	 * 
	 * () -> {// some code}
	 */

}
