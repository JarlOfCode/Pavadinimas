package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import DecoratorAndCommand.Armor;
import DecoratorAndCommand.Item;
import DecoratorAndCommand.Player;
import edu.ktu.signalrclient.Player1;

public class ArmorTest {

	@Test
	public void testArmor() {
		Item i = new Item();
		Armor a = new Armor(i);
		Player p = new Player1();
		
		p = a.execute(p);
		
		try {
			
			assertEquals(p.GetMaxHP(), 5);
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

}
