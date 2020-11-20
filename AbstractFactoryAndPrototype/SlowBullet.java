package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;

public class SlowBullet extends Bullet {

	public SlowBullet(int posX, int posY, int[] vel, BulletType type) {
		super(posX, posY, vel, type);
	}

}
