package edu.ktu.signalrclient;

public class Boots implements Pickup {

	Item i;
	
	public Boots(Item i) {
		this.i = i;
	}
	
	@Override
	public void execute(Player1 p) {
		i.SetSpeed(p);
	}

}
