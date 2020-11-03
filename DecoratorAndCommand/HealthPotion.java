package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class HealthPotion implements Pickup {

	Item i;
	
	public HealthPotion(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player p) {
		i.AddHealth(p);
	}

}
