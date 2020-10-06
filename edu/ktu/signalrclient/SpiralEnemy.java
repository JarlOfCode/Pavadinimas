package edu.ktu.signalrclient;

public class SpiralEnemy implements Enemy {

	@Override
	public void Spawn() {
		////GetEnemy method should be implemented
		main.chatBox.append("\nSpiralEnemy Spawned");
		System.out.println("SpiralEnemy Spawned");
		main.drawEnemy("spiral");
	}
	
	@Override
	public String getEnemy(){
		return "spiral";
	}
}
