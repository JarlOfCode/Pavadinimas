package DecoratorAndCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
	private List<Pickup> pickups = new ArrayList<Pickup>();
	
	public void addPickup(Pickup pickup) {
		pickups.add(pickup);
	}
	
	public void executePickups(Player p) {
		for (Pickup pickup : pickups) {
			pickup.execute(p);
		}
		pickups.clear();
	}
}
