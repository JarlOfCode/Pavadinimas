package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;

public class FastBullet extends Bullet {

	public FastBullet(int posX, int posY, int[] vel, BulletType type, int sp) {
		super(posX, posY, vel, type, sp);
		// TODO Auto-generated constructor stub
	}

	public FastBullet() {
		super();
	}

}
