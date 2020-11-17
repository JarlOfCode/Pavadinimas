package Testing;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;

import edu.ktu.signalrclient.GameSingleton;


public class GameSingletonTest {
		
	@Test  
	public void testStart() throws InterruptedException {
		GameSingleton singleton = GameSingleton.getInstance();
		singleton.Start();
		int sleepTime = 1000;
		Thread.sleep(sleepTime);
		int curTime = singleton.getTime();
		if(curTime == 0) {
			throw new AssertionError();
		}
	}
	
	@Test 
	public void testGetInstance() {
		try {
			GameSingleton.getInstance();
		} catch (Exception e) {
			throw e;
		}		
	}
	
	@Test
	public void testGetTime() throws InterruptedException {
		GameSingleton singleton = GameSingleton.getInstance();
		try {
			assertEquals(0,singleton.getTime());
		} catch (AssertionError e) {
			throw e;
		}
	}
	
	@Test 
	public void testGetScore() {
		GameSingleton singleton = GameSingleton.getInstance();
		try {
			assertEquals(0,singleton.getScore());
		} catch (AssertionError e) {
			throw e;
		}
	}

}
