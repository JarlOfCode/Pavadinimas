package Strategy;

import java.io.IOException;
import java.util.Vector;

import Observer.BulletObserver;

public abstract class Bullet {
	
	int damage = 0;
	int speed = 0;
	boolean friendly = false;
	int pos_x = 0;
	int pos_y = 0;
	double[] vel;
	public int timeAlive = 0;
	BulletObserver bo = new BulletObserver();
	
	public Bullet(boolean Friendly, int posx, int posy, double[] vel) {
		pos_x = posx;
		pos_y = posy;
		this.vel = vel;
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
	
	public int getX() {
		return pos_x;
	}
	
	public int getY() {
		return pos_y;
	}
	
	public boolean getFriendly() {
		return friendly;
	}
	
	public void Move() throws IOException {
		pos_x += vel[0];
		pos_y += vel[1];
		//bo.update();
		timeAlive++;
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
	
	public void setVel(double[] vel) {
		this.vel = vel;
	}
}

