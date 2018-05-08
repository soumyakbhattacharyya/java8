package java8lambda;

import org.junit.Assert;
import org.junit.Test;

import java8lambda.App;

public class AppTest {

	@Test
	public void testLengthOfTheUniqueKey() {

		App obj = new App();
		Assert.assertEquals(36, obj.generateUniqueKey().length());

	}
}
