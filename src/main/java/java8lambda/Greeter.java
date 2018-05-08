package java8lambda;

public class Greeter {

	public void greet(ActOfGreeting greeting) {
		greeting.perform();
	}

	public int add(AddFunction addFunction) {
		return addFunction.add(5, 6);
	}

	public static void main(String[] args) {

		Greeter greeter = new Greeter();

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

	}

	// target behavior

	/**
	 * aVariable = public void myMethod(){ // further code logic}
	 * 
	 * public - makes sense if the method is a member of a class name - is
	 * unnecessary if the function body is deferrable return type - can be guessed
	 * from the return statement of a function
	 * 
	 * () -> {// some code}
	 */

}
