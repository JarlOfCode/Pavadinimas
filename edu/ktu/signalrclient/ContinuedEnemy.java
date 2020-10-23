package edu.ktu.signalrclient;

import java.io.File;

public class ContinuedEnemy implements Enemy {

	double speed = 5;
	
	int xPos = 0;
	int yPos = 0;
	
	
	//super.imageFile = new File("/src/enemy_1.png");
	
	File imageFile = new File("src/enemy_1.png");
	
	protected String configuration = "Empty String";
	
	public String getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void Spawn() {
		////GetEnemy method should be implemented
		main.chatBox.append("\nContinuedEnemy Spawned");
		System.out.println("ContinuedEnemy Spawned");
		System.out.println("Stats: " + configuration);	
	}
	
	@Override
	public String getEnemy(){
		return "continued";
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


