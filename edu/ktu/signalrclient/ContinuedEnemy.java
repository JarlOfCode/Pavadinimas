package edu.ktu.signalrclient;

public class ContinuedEnemy implements Enemy {

	@Override
	public void Spawn() {
		////GetEnemy method should be implemented
		main.chatBox.append("\nContinuedEnemy Spawned");
		System.out.println("ContinuedEnemy Spawned");
		main.drawEnemy("continued");
	}
	
	@Override
	public String getEnemy(){
		return "continued";
	}
}
