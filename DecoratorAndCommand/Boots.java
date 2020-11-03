package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class Boots implements Pickup {

	Item i;
	
	public Boots(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player p) {
		i.SetSpeed(p);
	}

}
