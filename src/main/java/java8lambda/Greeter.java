package java8lambda;

public class Greeter {

	public void greet(ActOfGreeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {

		Greeter greeter = new Greeter();
		ActOfGreeting actOfGreeting = new HumbleActOfGreeting();
		greeter.greet(actOfGreeting);

	}
}
