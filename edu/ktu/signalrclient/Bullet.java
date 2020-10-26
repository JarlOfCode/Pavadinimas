package edu.ktu.signalrclient;

public class Bullet {
	
	int damage = 0;
	int speed = 0;
	boolean friendly = false;
	float pos_x = 0;
	float pos_y = 0;
	
	public Bullet(boolean Friendly, float posx, float posy) {
		pos_x = posx;
		pos_y = posy;
		friendly = Friendly;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public float getX() {
		return pos_x;
	}
	
	public float getY() {
		return pos_y;
	}
	
	public boolean getFriendly() {
		return friendly;
	}
}

