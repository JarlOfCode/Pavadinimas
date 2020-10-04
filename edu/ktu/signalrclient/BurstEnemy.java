package edu.ktu.signalrclient;

public class BurstEnemy implements Enemy {

	@Override
	public void Spawn() {
		main.chatBox.append("\nBurstEnemy Spawned");
		System.out.println("BurstEnemy Spawned");
		main.drawEnemy("burst");
	}
}
