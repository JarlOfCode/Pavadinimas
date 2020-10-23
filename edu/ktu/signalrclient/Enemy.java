package edu.ktu.signalrclient;

import java.io.File;

public abstract interface Enemy {
File imageFile = null;
	
	String getEnemy();
	void Spawn();
	File getImage();
	void setX(int X);
	void setY(int Y);
	int getX();
	int getY();
	
}
