package java8lambda;

public class Greeter {

	public void greet(ActOfGreeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {

		Greeter greeter = new Greeter();

		// HumbleActOfGreeting is an implementation of the behavior ActOfGreeting
		ActOfGreeting actOfGreeting = new HumbleActOfGreeting();

		// behavior is being passed as an argument to the method
		greeter.greet(actOfGreeting);

	}

}
