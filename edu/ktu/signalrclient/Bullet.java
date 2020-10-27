package edu.ktu.signalrclient;

public abstract class Bullet {
	
	int damage = 0;
	int speed = 0;
	boolean friendly = false;
	float pos_x = 0;
	float pos_y = 0;
	float xVel = 0;
	float yVel = 0;
	
	public Bullet(boolean Friendly, float posx, float posy, float XVEL, float YVEL) {
		pos_x = posx;
		pos_y = posy;
		xVel = XVEL;
		yVel = YVEL;
		friendly = Friendly;
	}
	
	public Bullet() {
		// TODO Auto-generated constructor stub
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
	
	public void Move() {
		
		// Judejimo logika su kampu ir t.t.
		
	}
	
	public void setX(int x) {
		pos_x = x;
	}
	
	public void setY(int y) {
		pos_y = y;
	}
	
	public void setFriendly(boolean f) {
		friendly = f;
	}
	
	public void setVel(int YVel, int XVel) {
		yVel = YVel;
		xVel = XVel;
	}
}

