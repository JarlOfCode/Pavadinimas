package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import AbstractFactoryAndPrototype.BigBulletFactory;
import AbstractFactoryAndPrototype.SmallBulletFactory;

public class SmallBulletFactoryTest {

	@Test
	public void testCreateSlowBulletBooleanIntIntDoubleArray() {
		SmallBulletFactory sbf = new SmallBulletFactory();
		int[] i = { 0, 0 };
		//sbf.createSlowBullet(true, 0, 0, i);
		return;
	}

	@Test
	public void testCreateFastBulletBooleanIntIntDoubleArray() {
		SmallBulletFactory sbf = new SmallBulletFactory();
		int[] i = { 0, 0 };
		//sbf.createFastBullet(true, 0, 0, i);
		return;
	}

}
