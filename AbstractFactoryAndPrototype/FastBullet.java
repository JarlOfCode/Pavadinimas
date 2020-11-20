package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;

public class FastBullet extends Bullet {

	public FastBullet(int posX, int posY, int[] vel, BulletType type) {
		super(posX, posY, vel, type);
		// TODO Auto-generated constructor stub
	}

	public FastBullet() {
		super();
	}

}
