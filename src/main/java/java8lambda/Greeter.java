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
		ActOfGreeting actOfGreeting = new HumbleActOfGreeting();
		greeter.greet(actOfGreeting);

	}
}
