package Testing;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import Strategy.Bullet;
import edu.ktu.signalrclient.Player1;

public class Player1Test {

	@Test
	public void testPlayer1() {
		Player1 testplayer = new Player1();
		int tempHP = 3;
		try {
			if (testplayer.GetHP() < tempHP) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	
	//private int Pos_X = 10;
	//private int Pos_Y = 15;
	@Test
	public void testMove() {
		Player1 testplayer = new Player1();
		int x = 5;
		int y = 5;
		int tempPosx = 10;
		int tempPosy = 15;
		int tempResultX = x + tempPosx;
		int tempResultY = y + tempPosy;

		try {
			try {
				testplayer.move(x, y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tempResultX != testplayer.getX() || tempResultY != testplayer.getY()) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testStartConstantObserve() {
		Player1 testplayer = new Player1();
		testplayer.startConstantObserve();
		//fail("Not yet implemented");
	}

	//private int Pos_X = 10;
	//private int Pos_Y = 15;	
	@Test
	public void testGetX() {
		Player1 testplayer = new Player1();
		int tempX = 10;
		try {
			if (testplayer.getX() != tempX) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		Player1 testplayer = new Player1();
		int tempY = 15;
		try {
			if (testplayer.getY() != tempY) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	//Needs loadimage()
	@Test
	public void testGetWidth() {
		Player1 testplayer = new Player1();
		//int tempWidth = 10;
		try {
			if (testplayer.getWidth() == 0) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet completed");
	}

	//Needs loadimage();
	@Test
	public void testGetHeight() {
		Player1 testplayer = new Player1();
		//int tempWidth = 10;
		try {
			if (testplayer.getHeight() == 0) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw e;
		}
		System.out.println("Test complete");
		//fail("Not yet completed");
	}

	@Test
	public void testGetImage() {
		Player1 testplayer = new Player1();
		testplayer.getImage();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testPlayerShoot() {
		Player1 testplayer = new Player1();
		testplayer.playerShoot();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	//Needs Key event
	@Test
	public void testKeyPressed(KeyEvent e) throws IOException {
		//int key = KeyEvent.VK_A;
		//KeyEvent e = KeyEvent.VK_A;
		// testplayer = new Player1();
		//KeyEvent e;
		//testplayer.keyPressed(key);
		int key = e.getKeyCode();
		int keyA = KeyEvent.VK_A;
		int keyD = KeyEvent.VK_D;
        //System.out.println("Key code");
        if (keyA == KeyEvent.VK_A) {
            //System.out.println("\"A\" pressed");
        	System.out.println("Pressed: A");
        }
        if (keyD == KeyEvent.VK_D) {
            //System.out.println("\"D\" pressed");
        	System.out.println("Pressed: D");
        }

        if (key == KeyEvent.VK_W) {
            //System.out.println("\"W\" pressed");
        	System.out.println("Pressed: W");
        }

        if (key == KeyEvent.VK_S) {
            //System.out.println("\"S\" pressed");
        	System.out.println("Pressed: S");
        }
        
        if (key == KeyEvent.VK_SPACE) {
            //System.out.println("\"Space\" pressed");
        	System.out.println("Pressed: Space");
        }
        System.out.println("Test complete");
	}

	//Same here
	@Test
	public void testKeyReleased(KeyEvent e)  {
		int key = e.getKeyCode();
		int keyA = KeyEvent.VK_A;
		int keyB = KeyEvent.VK_D;

        if (keyA == KeyEvent.VK_A) {
        	System.out.println("Released: A");
        }

        if (keyB == KeyEvent.VK_D) {
        	System.out.println("Released: D");
        }

        if (key == KeyEvent.VK_W) {
        	System.out.println("Released: W");
        }

        if (key == KeyEvent.VK_S) {
        	System.out.println("Released: S");
        }
        System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testNotifyObserver() throws IOException {
		Player1 testplayer = new Player1();
		testplayer.notifyObserver();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		Player1 testplayer = new Player1();
		testplayer.update();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

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
	}

	@Test
	public void testGetBullets() {
		Player1 player = new Player1();
		List<Bullet> templist = player.getBullets();
		try {
			if (templist == null) {
				throw new AssertionError();
			}			
		} catch (AssertionError e) {
			throw(e);
		}
		//fail("Not yet implemented");
	}

}
