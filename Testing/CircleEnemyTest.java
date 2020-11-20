package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import FactoryAndBuilder.BurstEnemy;
import FlyweightAndState.Bullet;
import TemplateMethodAndIterator.CircleEnemy;

public class CircleEnemyTest {
	/*
	 * KINDA DONE, ATKREIPKIT DEMESI I KOMENTARUS
	 * 
	 * 
	 * 
	 * */
	@Test
	public void testSpawn() {
		CircleEnemy enemy = new CircleEnemy();
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
		CircleEnemy enemy = new CircleEnemy();
		enemy.getEnemy();
	}

	@Test
	public void testGetImage() {
		CircleEnemy enemy = new CircleEnemy();
		enemy.getImage();
	}

	@Test
	public void testGetSetX() {
		CircleEnemy enemy = new CircleEnemy();
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
		CircleEnemy enemy = new CircleEnemy();
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
		Bullet bullet = new FastBullet(0, 0, null, null);
		CircleEnemy enemy = new CircleEnemy();
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
		CircleEnemy enemy = new CircleEnemy();
		try {
			enemy.executePattern();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testShootInt() {
		//netestuota kokie rezultatai
		CircleEnemy enemy = new CircleEnemy();
		int degree = 30;
		enemy.Shoot(degree);
	}

	@Test
	public void testShoot() {
		CircleEnemy enemy = new CircleEnemy();
		enemy.Shoot();
	}

	@Test
	public void testGetBullets() {
		CircleEnemy enemy = new CircleEnemy();
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
		CircleEnemy enemy = new CircleEnemy();
		try {
			enemy.ShootLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveBullet() {
		CircleEnemy enemy = new CircleEnemy();
		enemy.Shoot();
		try {
			enemy.removeBullet(0);
		} catch (Exception e) {
			throw e;
		}
	}
}
