package edu.ktu.signalrclient;

public class ContinuedEnemy implements Enemy {

	@Override
	public void Spawn() {
		main.chatBox.append("\nContinuedEnemy Spawned");
		System.out.println("ContinuedEnemy Spawned");
		main.drawEnemy("continued");
	}
}
