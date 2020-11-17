package Testing;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import FactoryAndBuilder.Enemy;
import FactoryAndBuilder.EnemyFactory;

public class EnemyFactoryTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "zodis", "Spiral", "Continued", "Circle", "Burst"})
	public void testGetEnemy(String input) {
		EnemyFactory factory = new EnemyFactory();
		Enemy enemyResult = factory.getEnemy(input);
	}
}
