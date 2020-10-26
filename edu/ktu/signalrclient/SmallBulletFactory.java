package edu.ktu.signalrclient;


public class SmallBulletFactory extends AbstractFactory {
	@Override
	public Small_Slow_Bullet createSlowBullet(boolean Friendly, float posX, float posY, float YVel, float XVel) {
		Small_Slow_Bullet bsb = new Small_Slow_Bullet(Friendly, posX, posY, YVel, XVel);
		return bsb;
	}
	
	@Override
	public Small_Fast_Bullet createFastBullet(boolean Friendly, float posX, float posY, float YVel, float XVel) {
		Small_Fast_Bullet bfb = new Small_Fast_Bullet(Friendly, posX, posY, YVel, XVel);
		return bfb;
	}
}
