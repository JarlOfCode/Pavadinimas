package AbstractFactoryAndPrototype;

import java.util.Vector;

public class SmallBulletFactory extends AbstractFactory {
	public Small_Slow_Bullet createSlowBullet(boolean Friendly, int posX, int posY, int[] vel) {
		Small_Slow_Bullet ssb = new Small_Slow_Bullet(Friendly, posX, posY, vel);
		return ssb;
	}
	
	Small_Fast_Bullet sfb = new Small_Fast_Bullet();
	
	public Small_Fast_Bullet createFastBullet(boolean Friendly, int posX, int posY, int[] vel) {
		Small_Fast_Bullet clone = sfb.clone();
		clone.setX(posX);
		clone.setY(posY);
		clone.setVel(vel);
		clone.setFriendly(Friendly);
		return clone;
	}
}
