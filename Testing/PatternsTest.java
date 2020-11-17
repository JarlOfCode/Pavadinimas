package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.SpiralEnemy;

public class PatternsTest {

	@Test
	public void testExecutePattern() throws InterruptedException {
		SpiralEnemy temp = new SpiralEnemy();
		temp.executePattern();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
