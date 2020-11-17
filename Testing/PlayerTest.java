package Testing;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.ktu.signalrclient.Player1;

public class PlayerTest {

	@Test
	public void testAddHP() {
		Player1 player = new Player1();
		int temp = player.GetHP();
		try {
			//expected, real
			player.AddHP(1);
			assertEquals(temp+1,player.GetHP());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMaxHP() {
		Player1 player = new Player1();
		int temp = 5;
		try {
			//expected, real
			player.SetMaxHP(5);
			assertEquals(temp,player.GetMaxHP());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSetSpeed() {
		Player1 player = new Player1();
		int temp = 5;
		try {
			//expected, real
			player.SetSpeed(5);
			assertEquals(temp,player.GetSpeed());
		} catch (AssertionError e) {
			throw(e);
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
