package Testing.Done;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import AbstractFactoryAndPrototype.FastBullet;
import AbstractFactoryAndPrototype.Small_Fast_Bullet;
import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;

public class BulletTest {
	@Test
	public void testBullet() {
		Bullet b = new FastBullet();
		return;
	}

	/*@Test
	public void testSetGetDamage() {
		Bullet b = new Small_Fast_Bullet(false, 0, 0, null);
		b.setDamage(1);
		try {
			assertEquals(1, b.getDamage());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

	@Test
	public void testMove() throws IOException {
		int[] vel = { 2, 3 };
		Bullet b = new Small_Fast_Bullet(0, 0, vel);
		b.Move();
		int[] expectedPos = { 2, 3 };
		int[] actualPos = { b.getX(), b.getY() };
		//System.out.println(actualPos[1]);
 		try {
 			for(int i = 0; i < 2; i++) {
			assertEquals(expectedPos[i], actualPos[i]);
 			}
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}*/

	@Test
	public void testSetGetX() {
		Bullet b = new Small_Fast_Bullet(0, 0, null, null);
		b.setX(1);
		try {
			assertEquals(1, b.getX());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

	@Test
	public void testSetGetY() {
		Bullet b = new Small_Fast_Bullet(0, 0, null, null);
		b.setY(1);
		try {
			assertEquals(1, b.getY());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

	/*@Test
	public void testSetGetFriendly() {
		Bullet b = new Small_Fast_Bullet(0, 0, null, null);
		BulletType bt = new BulletType(1, false);
		b.setFriendly(true);
		try {
			assertEquals(true, b.getFriendly());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
		
		b.setFriendly(false);
		try {
			assertEquals(false, b.getFriendly());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}*/

	@Test
	public void testSetGetVel() {
		Bullet b = new Small_Fast_Bullet(0, 0, null, null);
		int[] d = { 5, 4 };
		b.setVel(d);
		try {
			assertEquals(d, b.getVel());
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

}
