package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ManualTests {
	@Test
	  public void evaluatesExpression() {
	    Calculator calculator = new Calculator();
	    int sum = calculator.evaluate("1+2+3");
	    try {
	    assertEquals(6, sum);
	    } catch (AssertionError e) {
	    	System.out.println("xujne");
	    	throw e;
	    }
	    System.out.println("gerai");
	  }
}


