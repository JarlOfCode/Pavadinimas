package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.BurstEnemy;
import FactoryAndBuilder.Enemy;
import Strategy.Burst;

public class BurstTest {

	@Test
	public void testExecutePattern() throws InterruptedException {
		Enemy enemy = new BurstEnemy();
		Burst burst = new Burst();
		burst.executePattern(enemy);
	}
}
