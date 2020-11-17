package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.SpiralEnemy;
import Strategy.Spiral;

public class SpiralTest {

	@Test
	public void testExecutePattern() throws InterruptedException {
		SpiralEnemy SE = new SpiralEnemy();
		Spiral spiral = new Spiral();
		spiral.executePattern(SE);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
