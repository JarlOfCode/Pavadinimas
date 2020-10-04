package edu.ktu.signalrclient;

public class CircleEnemy implements Enemy {
	
	@Override
	public void Spawn() {
		main.chatBox.append("\nCircleEnemy Spawned");
		System.out.println("CircleEnemy Spawned");
		main.drawEnemy("circle");
	}
}
