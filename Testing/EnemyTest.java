package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import FactoryAndBuilder.ContinuedEnemy;
import FactoryAndBuilder.Enemy;
import Strategy.Bullet;

public class EnemyTest {

	@Test
	public void testGetEnemy() {
		Enemy enemy = new ContinuedEnemy();
		enemy.getEnemy();
	}

	@Test
	public void testSpawn() {
		Enemy enemy = new ContinuedEnemy();
		try {
			enemy.Spawn();
			System.out.println("Gerai");
		} catch (InterruptedException e) {
			System.out.println("Blogai");
			e.printStackTrace();
		}
	}

	@Test
	public void testGetImage() {
		Enemy enemy = new ContinuedEnemy();
		enemy.getImage();
	}

	@Test
	public void testGetSetX() {
		Enemy enemy = new ContinuedEnemy();
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
		Enemy enemy = new ContinuedEnemy();
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
	public void testExecutePattern() {
		Enemy enemy = new ContinuedEnemy();
		try {
			enemy.executePattern();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsHit() {
		/*pabaigti pridejus getHP metoda
		 * */
		Bullet bullet = new FastBullet(false, 0, 0, null);
		Enemy enemy = new ContinuedEnemy();
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
	public void testShootInt() {
		Enemy enemy = new ContinuedEnemy();
		int degree = 30;
		enemy.Shoot(degree);
	}

	@Test
	public void testShoot() {
		Enemy enemy = new ContinuedEnemy();
		enemy.Shoot();
	}

	@Test
	public void testGetBullets() {
		Enemy enemy = new ContinuedEnemy();
		enemy.Shoot();
		try {
			int bulletNumber = enemy.getBullets().size();
			assertEquals(1, bulletNumber);
		} catch (AssertionError e) {
			throw e;			
		}	
	}

	@Test
	public void testRemoveBullet() {
		Enemy enemy = new ContinuedEnemy();
		enemy.Shoot();
		try {
			enemy.removeBullet(0);
		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void testShootLoop() {
		Enemy enemy = new ContinuedEnemy();
		try {
			enemy.ShootLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
