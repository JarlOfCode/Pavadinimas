package edu.ktu.signalrclient;

public class BigBulletFactory extends AbstractFactory {
	public Big_Slow_Bullet createSlowBullet(boolean Friendly, float posX, float posY, float YVel, float XVel) {
		Big_Slow_Bullet bsb = new Big_Slow_Bullet(Friendly, posX, posY, YVel, XVel);
		return bsb;
	}
	
	public Big_Fast_Bullet createFastBullet(boolean Friendly, float posX, float posY, float YVel, float XVel) {
		Big_Fast_Bullet bfb = new Big_Fast_Bullet(Friendly, posX, posY, YVel, XVel);
		return bfb;
	}
}
