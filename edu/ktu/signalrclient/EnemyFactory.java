package edu.ktu.signalrclient;

public class EnemyFactory implements AbstractFactory<Enemy>{
	//use getEnemy method to get object of type Enemy
	@Override
	public Enemy getEnemy(String enemyType) {
		if(enemyType == null) {
			return null;
		}
		if(enemyType.equalsIgnoreCase("Spiral")) {
			return new SpiralEnemy();
		}
		else if(enemyType.equalsIgnoreCase("Continued")) {
			return new ContinuedEnemy();
		}
		else if(enemyType.equalsIgnoreCase("Circle")) {
			return new CircleEnemy();
		}
		else if(enemyType.equalsIgnoreCase("Burst")) {
			return new BurstEnemy();
		}
		
		return null;
	}
}
