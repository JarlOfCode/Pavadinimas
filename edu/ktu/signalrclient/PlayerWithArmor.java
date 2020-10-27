package edu.ktu.signalrclient;

public class PlayerWithArmor {
	protected Player1 p;
	
	public PlayerWithArmor(Player1 p) {
		p.SetMaxHP(5);
		this.p = p;
	}
	
	public void update() {
		p.update();
	}
}