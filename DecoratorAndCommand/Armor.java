package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class Armor implements Pickup {

	Item i;
	
	public Armor(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player p) {
		i.SetHealth(p);
	}

}
