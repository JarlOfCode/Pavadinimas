package edu.ktu.signalrclient;

import java.util.Random;

//implements AbstractFactory<Enemy>
public class EnemyFactory{
	
	IBuilder builder = new ContinuedEnemyBuilder();
	
	//use getEnemy method to get object of type Enemy
	public Enemy getEnemy(String enemyType) {
		if(enemyType == null) {
			return null;
		}
		if(enemyType.equalsIgnoreCase("Spiral")) {
			return new SpiralEnemy();
		}
		else if(enemyType.equalsIgnoreCase("Continued")) {
			//return new ContinuedEnemy();
			
			Random random = new Random();
			int ran = random.nextInt(3 - 1)+1;
			builder.reset();
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
