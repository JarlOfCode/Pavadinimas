package edu.ktu.signalrclient;


public class SmallBulletFactory extends AbstractFactory {

	public SlowBullet createSlowBullet() {
		SlowBullet bsb = new Big_Slow_Bullet();
		return bsb;
	}
	
	public FastBullet createFastBullet() {
		FastBullet bfb = new Big_Fast_Bullet();
		return bfb;
	}
}
