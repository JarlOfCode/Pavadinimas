package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class Armor implements Pickup {

	Item i;
	
	public Armor(Item i) {
		this.i = i;
	}
	
	@Override
	public Player execute(Player p) {
		return i.SetHealth(p);
	}

}
