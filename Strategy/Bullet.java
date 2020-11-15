package Strategy;

import java.io.IOException;
import java.util.Vector;

import Observer.BulletObserver;

public abstract class Bullet {
	
	int damage = 0;
	boolean friendly = false;
	int pos_x = 0;
	int pos_y = 0;
	int[] vel;
	public int timeAlive = 0;
	BulletObserver bo = new BulletObserver();
	
	public Bullet(boolean Friendly, int posx, int posy, int[] vel) {
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
	
	public void setDamage(int damage) {
		this.damage = damage;
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
	
	public void setVel(int[] vel) {
		this.vel = vel;
	}
	
	public int[] getVel() {
		return this.vel;
	}
}

