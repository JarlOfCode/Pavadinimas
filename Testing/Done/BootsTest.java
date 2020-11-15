package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import DecoratorAndCommand.Armor;
import DecoratorAndCommand.Boots;
import DecoratorAndCommand.Item;
import DecoratorAndCommand.Player;
import edu.ktu.signalrclient.Player1;

public class BootsTest {

	@Test
	public void testBoots() {
		Item i = new Item();
		Boots b = new Boots(i);
		Player p = new Player1();
		
		p = b.execute(p);
		
		try {
			
			assertEquals(p.GetSpeed(), 7);
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}
}
