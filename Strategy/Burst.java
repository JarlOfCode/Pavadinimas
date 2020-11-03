package Strategy;

import FactoryAndBuilder.Enemy;

public class Burst implements Patterns {

	@Override
	public void executePattern(Enemy enemy) throws InterruptedException {
		for(int i = 0; i < 6; i++) {
			enemy.Shoot();
			Thread.sleep(500);
		}
	}
}
