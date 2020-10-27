package edu.ktu.signalrclient;

public class Armor implements Pickup {

	Item i;
	
	public Armor(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player1 p) {
		i.SetHealth(p);
	}

}
