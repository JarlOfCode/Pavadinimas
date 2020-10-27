package edu.ktu.signalrclient;

public class HealthPotion implements Pickup {

	Item i;
	
	public HealthPotion(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player1 p) {
		i.AddHealth(p);
	}

}
