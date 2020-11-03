package Strategy;

import FactoryAndBuilder.Enemy;

public class Spiral implements Patterns {

	@Override
	public void executePattern(Enemy enemy) throws InterruptedException {
		int degree = 60;
		int c_degree = 0;
		for(int i = 0; i < 6; i++) {
			c_degree = degree*i;
			enemy.Shoot(c_degree);
			Thread.sleep(500);
		}
	}
}
