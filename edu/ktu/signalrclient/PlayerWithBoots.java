package edu.ktu.signalrclient;

public class PlayerWithBoots {
	protected Player1 p;
	
	public PlayerWithBoots(Player1 p) {
		p.SetSpeed(7);
		this.p = p;
	}
	
	public void update() {
		p.update();
	}
}