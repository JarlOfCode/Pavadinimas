package FactoryAndBuilder;

import java.util.Random;

import TemplateMethodAndIterator.CircleEnemy;
import TemplateMethodAndIterator.ToughCircleEnemyBuilder;
import TemplateMethodAndIterator.ValuableCircleEnemyBuilder;

//implements AbstractFactory<Enemy>
public class EnemyFactory{
	
	IBuilder builder = new ContinuedEnemyBuilder();
	ToughCircleEnemyBuilder tceb = new ToughCircleEnemyBuilder();
	ValuableCircleEnemyBuilder vceb = new ValuableCircleEnemyBuilder();
	
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
				builder.addArmor();
			}
			return builder.build();
		}
		else if(enemyType.equalsIgnoreCase("Circle")) {
			Random random = new Random();
			int ran = random.nextInt(3 - 1)+1;
			
			if(ran == 1) {
				return tceb.buildEnemy();
			}
			
			else {
				return vceb.buildEnemy();
			}
		}
		else if(enemyType.equalsIgnoreCase("Burst")) {
			return new BurstEnemy();
		}
		
		return null;
	}
}
