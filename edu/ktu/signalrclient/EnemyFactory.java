package edu.ktu.signalrclient;

import java.util.Random;

//implements AbstractFactory<Enemy>
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
			//return new ContinuedEnemy();
			IBuilder builder = new ContinuosEnemyBuilder();
			Random random = new Random();
			int ran = random.nextInt(3 - 1)+1;
			if(ran == 1){
				builder.addBoots();
			}
			return builder.build();
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
