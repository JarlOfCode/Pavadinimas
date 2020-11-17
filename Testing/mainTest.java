package Testing;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.IOException;

import org.junit.Test;

import FactoryAndBuilder.Enemy;
import FactoryAndBuilder.SpiralEnemy;
import edu.ktu.signalrclient.main;

public class mainTest {

	@Test
	public void testMain() {
		//main.main(args);
		fail("Not yet implemented");
	}

	@Test
	public void testConstant() {
		main mn = new main();
		mn.constant();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testRender() throws IOException {
		main mn = new main();
		mn.render();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSetup() throws IOException {
		main mn = new main();
		mn.setup();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		main mn = new main();
		Object o = new Object();
		int temp = 1;
		String string = "Hello";
		ActionEvent e = new ActionEvent(o,temp,string);
		mn.actionPerformed(e);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSpawnEnemy() throws IOException {
		main mn = new main();
		Enemy SE = new SpiralEnemy();
		mn.spawnEnemy(SE);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGui() {
		main mn = new main();
		mn.gui();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testInvoke() {
		main mn = new main();
		String name = "name test";
		String message = "this is a test";
		mn.invoke(name, message);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testReceiveMessage() {
		main mn = new main();
		String user = "test user";
		String message = "this is a test";
		mn.ReceiveMessage(user, message);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testSendMessage() {
		main mn = new main();
		String user = "test user";
		String message = "this is a test message";
		mn.SendMessage(user, message);
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetRandomX() {
		main mn = new main();
		int temp = mn.getRandomX();
		try {
			if (temp == 0) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetRandomY() {
		main mn = new main();
		int temp = mn.getRandomY();
		try {
			if (temp == 0) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
