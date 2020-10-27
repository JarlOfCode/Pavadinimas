package edu.ktu.signalrclient;

public class Small_Fast_Bullet extends FastBullet implements Cloneable {

	public Small_Fast_Bullet() {
		super();
	}
	
	public Small_Fast_Bullet(boolean Friendly, int posX, int posY, int yVel, int xVel) {
		super(Friendly, posX, posY, yVel, xVel);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Small_Fast_Bullet clone() {
		Small_Fast_Bullet clone = null;
		
		try {
			clone = (Small_Fast_Bullet) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clone;
	}
	
	

}
