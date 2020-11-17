package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import FactoryAndBuilder.CircleEnemy;
import FactoryAndBuilder.ContinuedEnemy;
import Strategy.Bullet;

public class ContinuedEnemyTest {

	@Test
	public void testGetSetConfiguration() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		String config = "new configuration";
		try {
			enemy.setConfiguration(config);
			assertEquals(config, enemy.getConfiguration());
		} catch (AssertionError e) {
			throw e;
		}
	}

	@Test
	public void testSpawn() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		try {
			enemy.Spawn();
			System.out.println("Gerai");
		} catch (InterruptedException e) {
			System.out.println("Blogai");
			e.printStackTrace();
		}
	}

	@Test
	public void testGetEnemy() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		enemy.getEnemy();
	}

	@Test
	public void testGetImage() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		enemy.getImage();
	}

	@Test
	public void testGetSetX() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		int altX = 5;
		try {
			assertEquals(0, enemy.getX());
			enemy.setX(altX);
			assertEquals(altX, enemy.getX());
			System.out.println("Gerai");
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
	}

	@Test
	public void testGetSetY() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		int altY = 5;
		try {
			assertEquals(0, enemy.getY());
			enemy.setY(altY);
			assertEquals(altY, enemy.getY());
			System.out.println("Gerai");
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
	}
	
	@Test
	public void testIsHit() {
		/*pabaigti pridejus getHP metoda
		 * */
		Bullet bullet = new FastBullet(false, 0, 0, null);
		ContinuedEnemy enemy = new ContinuedEnemy();
		//int enemyHealth = enemy.HP;
		try {
			enemy.isHit(bullet);
			//assertEquals(enemyHealth - 1, enemy.HP);
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
	}

	@Test
	public void testExecutePattern() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		try {
			enemy.executePattern();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testShootInt() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		int degree = 30;
		enemy.Shoot(degree);
	}

	@Test
	public void testShoot() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		enemy.Shoot();
	}

	@Test
	public void testGetBullets() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		enemy.Shoot();
		try {
			int bulletNumber = enemy.getBullets().size();
			assertEquals(1, bulletNumber);
		} catch (AssertionError e) {
			throw e;			
		}	
	}

	@Test
	public void testShootLoop() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		try {
			enemy.ShootLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveBullet() {
		ContinuedEnemy enemy = new ContinuedEnemy();
		enemy.Shoot();
		try {
			enemy.removeBullet(0);
		} catch (Exception e) {
			throw e;
		}
	}

}
