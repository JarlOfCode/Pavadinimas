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
	int HP = 0;
	int Move_Speed = 0;
	int Value = 0;
	
	void executePattern() throws InterruptedException;
	void isHit(Bullet bullet);
	void Shoot(int c_degree);
	void Shoot();
	
}
