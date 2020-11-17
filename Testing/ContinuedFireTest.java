package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.ContinuedEnemy;
import Strategy.ContinuedFire;

public class ContinuedFireTest {

	@Test
	public void testExecutePattern() throws InterruptedException {
		ContinuedEnemy enemy = new ContinuedEnemy();
		ContinuedFire continuedFireObj = new ContinuedFire();
		continuedFireObj.executePattern(enemy);
	}

}
