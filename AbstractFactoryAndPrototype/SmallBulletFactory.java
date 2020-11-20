package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.BulletType;

public class SmallBulletFactory extends AbstractFactory {
	public Small_Slow_Bullet createSlowBullet(int posX, int posY, int[] vel, BulletType type) {
		Small_Slow_Bullet ssb = new Small_Slow_Bullet(posX, posY, vel, type);
		return ssb;
	}
	
	Small_Fast_Bullet sfb = new Small_Fast_Bullet();
	
	public Small_Fast_Bullet createFastBullet(int posX, int posY, int[] vel, BulletType type) {
		Small_Fast_Bullet clone = sfb.clone();
		clone.setX(posX);
		clone.setY(posY);
		clone.setVel(vel);
		clone.setType(type);
		return clone;
	}
}
