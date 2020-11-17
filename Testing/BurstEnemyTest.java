package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import FactoryAndBuilder.BurstEnemy;
import Strategy.Bullet;

public class BurstEnemyTest {
	/*
	 * KINDA DONE, ATKREIPKIT DEMESI I KOMENTARUS
	 * 
	 * 
	 * 
	 * */

	@Test
	public void testSpawn() {
		BurstEnemy enemy = new BurstEnemy();
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
		BurstEnemy enemy = new BurstEnemy();
		enemy.getEnemy();
	}

	@Test
	public void testGetImage() {
		BurstEnemy enemy = new BurstEnemy();
		enemy.getImage();
	}

	@Test
	public void testGetSetX() {
		BurstEnemy enemy = new BurstEnemy();
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
		BurstEnemy enemy = new BurstEnemy();
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
		Bullet bullet = new FastBullet(false, 0, 0, null);
		BurstEnemy enemy = new BurstEnemy();
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
		BurstEnemy enemy = new BurstEnemy();
		try {
			enemy.executePattern();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testShootInt() {
		//netestuota kokie rezultatai
		BurstEnemy enemy = new BurstEnemy();
		int degree = 30;
		enemy.Shoot(degree);
	}

	@Test
	public void testShoot() {
		BurstEnemy enemy = new BurstEnemy();
		enemy.Shoot();
	}

	@Test
	public void testGetBullets() {
		BurstEnemy enemy = new BurstEnemy();
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
		//no idea ka shootLoop daro?
		BurstEnemy enemy = new BurstEnemy();
		try {
			enemy.ShootLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveBullet() {
		BurstEnemy enemy = new BurstEnemy();
		enemy.Shoot();
		try {
			enemy.removeBullet(0);
		} catch (Exception e) {
			throw e;
		}		
	}
}
