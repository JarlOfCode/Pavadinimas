package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.BulletType;

public class BigBulletFactory extends AbstractFactory {
	public Big_Slow_Bullet createSlowBullet(int posX, int posY, int[] vel, BulletType type) {
		Big_Slow_Bullet bsb = new Big_Slow_Bullet(posX, posY, vel, type);
		return bsb;
	}
	
	public Big_Fast_Bullet createFastBullet(int posX, int posY, int[] vel, BulletType type) {
		Big_Fast_Bullet bfb = new Big_Fast_Bullet(posX, posY, vel, type);
		return bfb;
	}
}
