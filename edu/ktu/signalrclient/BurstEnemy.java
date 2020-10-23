package edu.ktu.signalrclient;
import java.io.File;

public class BurstEnemy implements Enemy {

	File imageFile = new File("src/enemy_2.jpg");
	int xPos = 0;
	int yPos = 0;
	@Override
	public void Spawn() {
		//GetEnemy method should be implemented
		main.chatBox.append("\nBurstEnemy Spawned");
		System.out.println("BurstEnemy Spawned");
	}
	
	@Override
	public String getEnemy(){
		return "burst";
	}
	
	
	@Override
	public File getImage() {
		return imageFile;
	}
	
	@Override
	public void setX(int x) {
		this.xPos = x;
	}
	
	@Override
	public void setY(int y) {
		this.yPos = y;
	}
	
	@Override
	public int getX() {
		return this.xPos;
	}
	
	@Override
	public int getY() {
		return this.yPos;
	}
}
