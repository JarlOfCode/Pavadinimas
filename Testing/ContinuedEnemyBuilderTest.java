package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.ContinuedEnemy;
import FactoryAndBuilder.ContinuedEnemyBuilder;

public class ContinuedEnemyBuilderTest {

	@Test
	public void testAddBoots() {
		ContinuedEnemyBuilder builder = new ContinuedEnemyBuilder();
		builder.reset();
		builder.addBase();

		ContinuedEnemy enemy = builder.build();
		double speed = enemy.Move_Speed;
		builder.addBoots();
		try {
			ContinuedEnemy enemyWithBoots =  builder.build();
			assertEquals(speed * 1.5, enemyWithBoots.Move_Speed, 0.0005);
		} catch (AssertionError e) {
			throw e;
		}
	}
}
