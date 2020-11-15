package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class HealthPotion implements Pickup {

	Item i;
	
	public HealthPotion(Item i) {
		this.i = i;
	}
	
	@Override
	public Player execute(Player p) {
		return i.AddHealth(p);
	}

}
