package edu.ktu.signalrclient;

public class EnemyFactory {
	//use getEnemy method to get object of type Enemy
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
