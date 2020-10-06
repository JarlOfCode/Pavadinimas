package edu.ktu.signalrclient;

public class CircleEnemy implements Enemy {
	
	@Override
	public void Spawn() {
		////GetEnemy method should be implemented
		main.chatBox.append("\nCircleEnemy Spawned");
		System.out.println("CircleEnemy Spawned");
		main.drawEnemy("circle");
	}
	
	@Override
	public String getEnemy(){
		return "circle";
	}
}
