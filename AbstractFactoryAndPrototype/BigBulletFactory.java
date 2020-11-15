package AbstractFactoryAndPrototype;

import java.util.Vector;

public class BigBulletFactory extends AbstractFactory {
	public Big_Slow_Bullet createSlowBullet(boolean Friendly, int posX, int posY, int[] vel) {
		Big_Slow_Bullet bsb = new Big_Slow_Bullet(Friendly, posX, posY, vel);
		return bsb;
	}
	
	public Big_Fast_Bullet createFastBullet(boolean Friendly, int posX, int posY, int[] vel) {
		Big_Fast_Bullet bfb = new Big_Fast_Bullet(Friendly, posX, posY, vel);
		return bfb;
	}
}
