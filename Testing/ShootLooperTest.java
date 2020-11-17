package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.Enemy;
import FactoryAndBuilder.SpiralEnemy;
import Strategy.ShootLooper;

public class ShootLooperTest {

	@Test
	public void testShootLooper() {
		Enemy e = new SpiralEnemy();
		ShootLooper SL = new ShootLooper(e, "Spiral");
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		Enemy e = new SpiralEnemy();
		ShootLooper SL = new ShootLooper(e, "Spiral");
		SL.run();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testStart() {
		Enemy e = new SpiralEnemy();
		ShootLooper SL = new ShootLooper(e, "Spiral");
		SL.start();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
