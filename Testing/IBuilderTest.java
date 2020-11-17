package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import FactoryAndBuilder.ContinuedEnemy;
import FactoryAndBuilder.ContinuedEnemyBuilder;
import FactoryAndBuilder.IBuilder;

public class IBuilderTest {

	@Test
	public void testBuild() {
		IBuilder builder = new ContinuedEnemyBuilder();
		builder.reset();
		ContinuedEnemy enemy =  builder.build();
		try {
			assertEquals(0,enemy.getX());
		} catch (AssertionError e) {
			throw e;
		}
	}

	@Test
	public void testAddBase() {
		IBuilder builder = new ContinuedEnemyBuilder();
		builder.reset();
		try {
			builder = builder.addBase();
			ContinuedEnemy enemy =  builder.build();
			assertEquals("Empty String / Base", enemy.getConfiguration());
		} catch (AssertionError e) {
			throw e;
		}
	}

	@Test
	public void testReset() {
		IBuilder builder = new ContinuedEnemyBuilder();
		builder.reset();
	}

	@Test
	public void testAddBoots() {
		IBuilder builder = new ContinuedEnemyBuilder();
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
