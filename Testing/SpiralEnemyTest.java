package Testing;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.List;
import java.io.File;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import FactoryAndBuilder.SpiralEnemy;
import Strategy.Bullet;

public class SpiralEnemyTest {

	@Test
	public void testSpawn() throws InterruptedException {
		SpiralEnemy SE = new SpiralEnemy();
		SE.Spawn();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEnemy() {
		SpiralEnemy SE = new SpiralEnemy();
		String name = SE.getEnemy();
		try {
			if (name == null) {
				throw new AssertionError();
			}
		} catch (Exception e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetImage() {
		SpiralEnemy SE = new SpiralEnemy();
		File seimage = SE.getImage();
		try {
			if (seimage == null) {
				throw new AssertionError();
			}
		} catch (Exception e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.setX(5);
		int tempx = 5;
		try {
			//expected, real
			assertEquals(tempx,SE.getX());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.setY(5);
		int tempy = 5;
		try {
			//expected, real
			assertEquals(tempy,SE.getY());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}
	//Pos_X = 0
	@Test
	public void testGetX() {
		SpiralEnemy SE = new SpiralEnemy();
		int tempx = 0;
		try {
			//expected, real
			assertEquals(tempx,SE.getX());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		SpiralEnemy SE = new SpiralEnemy();
		int tempx = 0;
		try {
			//expected, real
			assertEquals(tempx,SE.getX());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testIsHit() {
		SpiralEnemy SE = new SpiralEnemy();
		Bullet b = new FastBullet();
		SE.isHit(b);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testExecutePattern() throws InterruptedException {
		SpiralEnemy SE = new SpiralEnemy();
		SE.executePattern();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testShootInt() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.Shoot(30);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testShoot() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.Shoot();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBullets() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.Shoot();
		try {
			if(SE.getBullets() == null) {
				throw new AssertionError();
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testShootLoop() throws InterruptedException {
		SpiralEnemy SE = new SpiralEnemy();
		SE.ShootLoop();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveBullet() {
		SpiralEnemy SE = new SpiralEnemy();
		SE.Shoot();
		SE.removeBullet(1);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
