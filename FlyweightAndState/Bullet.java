package FlyweightAndState;

import java.io.IOException;
import java.util.Vector;

import Observer.BulletObserver;

public abstract class Bullet {
	int pos_x = 0;
	int pos_y = 0;
	int[] vel;
	public int timeAlive = 0;
	public int speed = 1;
	private BulletType type;
	
	
	BulletObserver bo = new BulletObserver();
	
	public Bullet(int posx, int posy, int[] vel, BulletType type, int sp) {
		pos_x = posx;
		pos_y = posy;
		this.vel = vel;
		this.type = type;
		speed = sp;
	}
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}

	public int getDamage() {
		return type.damage;
	}
	
	public void setDamage(int damage) {
		this.type.damage = damage;
	}
	
	public int getX() {
		return pos_x;
	}
	
	public int getY() {
		return pos_y;
	}
	
	public boolean getFriendly() {
		return type.friendly;
	}
	
	public void Move() throws IOException {
		pos_x += vel[0]*speed;
		pos_y += vel[1]*speed;
		//bo.update();
		timeAlive++;
	}
	
	public void setX(int x) {
		pos_x = x;
	}
	
	public void setY(int y) {
		pos_y = y;
	}
	
	public void setVel(int[] vel) {
		this.vel = vel;
	}
	
	public int[] getVel() {
		return this.vel;
	}
	
	public void setType(BulletType bt) {
		this.type = bt;
	}
}

