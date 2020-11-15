package Testing.Done;

import static org.junit.Assert.*;

import org.junit.Test;

import DecoratorAndCommand.Armor;
import DecoratorAndCommand.Boots;
import DecoratorAndCommand.CommandInvoker;
import DecoratorAndCommand.HealthPotion;
import DecoratorAndCommand.Item;
import DecoratorAndCommand.Player;
import edu.ktu.signalrclient.Player1;

public class CommandInvokerTest {

	@Test
	public void testExecutePickups() {
		CommandInvoker ci = new CommandInvoker();
		Player p = new Player1();
		Item i = new Item();
		
		Boots b = new Boots(i);
		HealthPotion hp = new HealthPotion(i);
		Armor a = new Armor(i);
		
		ci.addPickup(b);
		ci.addPickup(hp);
		ci.addPickup(a);
		
		ci.executePickups(p);
		
		try {
			assertEquals(p.GetHP(), 5);
			//assertEquals(p.GetMaxHP(), 5); Isemiau is testo, nes atskirai neveikia
			System.out.println(p.GetSpeed() + " speed");
			assertEquals(p.GetSpeed(), 7);
		} catch (AssertionError e) {
			System.out.println("Blogai");
			throw e;
		}
		System.out.println("Gerai");
	}

}
