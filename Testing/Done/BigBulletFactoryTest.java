package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.AbstractFactory;
import AbstractFactoryAndPrototype.BigBulletFactory;

public class BigBulletFactoryTest {

	@Test
	public void testCreateSlowBulletBooleanIntIntDoubleArray() {
		BigBulletFactory bbf = new BigBulletFactory();
		int[] i = { 0, 0 };
		bbf.createSlowBullet(true, 0, 0, i);
		return;
	}

	@Test
	public void testCreateFastBulletBooleanIntIntDoubleArray() {
		BigBulletFactory bbf = new BigBulletFactory();
		int[] i = { 0, 0 };
		bbf.createFastBullet(true, 0, 0, i);
		return;
	}

}
