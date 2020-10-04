package edu.ktu.signalrclient;

public class SpiralEnemy implements Enemy {

	@Override
	public void Spawn() {
		main.chatBox.append("\nSpiralEnemy Spawned");
		System.out.println("SpiralEnemy Spawned");
		main.drawEnemy("spiral");
	}
}
