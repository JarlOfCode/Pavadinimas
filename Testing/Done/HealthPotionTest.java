package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import DecoratorAndCommand.Boots;
import DecoratorAndCommand.HealthPotion;
import DecoratorAndCommand.Item;
import DecoratorAndCommand.Player;
import edu.ktu.signalrclient.Player1;

public class HealthPotionTest {

	@Test
	public void testHealthPotion() {
		Item i = new Item();
		HealthPotion b = new HealthPotion(i);
		Player p = new Player1();
		p.AddHP(-4);
		
		p = b.execute(p);
		
		try {
			
			assertEquals(p.GetHP(), 1);
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

}
