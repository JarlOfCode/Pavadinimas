package edu.ktu.signalrclient;

public class SmallBulletFactory extends AbstractFactory {
	public Small_Slow_Bullet createSlowBullet(boolean Friendly, int posX, int posY, int YVel, int XVel) {
		Small_Slow_Bullet ssb = new Small_Slow_Bullet(Friendly, posX, posY, YVel, XVel);
		return ssb;
	}
	
	Small_Fast_Bullet sfb = new Small_Fast_Bullet();
	
	public Small_Fast_Bullet createFastBullet(boolean Friendly, int posX, int posY, int YVel, int XVel) {
		Small_Fast_Bullet clone = sfb.clone();
		clone.setX(posX);
		clone.setY(posY);
		clone.setVel(YVel, XVel);
		clone.setFriendly(Friendly);
		return clone;
	}
}
