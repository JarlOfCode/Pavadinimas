package edu.ktu.signalrclient;

public class BurstEnemy implements Enemy {

	@Override
	public void Spawn() {
		//GetEnemy method should be implemented
		main.chatBox.append("\nBurstEnemy Spawned");
		System.out.println("BurstEnemy Spawned");
		main.drawEnemy("burst");
	}
	
	@Override
	public String getEnemy(){
		return "burst";
	}
}
