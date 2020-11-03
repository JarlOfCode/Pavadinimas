package AbstractFactoryAndPrototype;

import java.util.Vector;

import Strategy.Bullet;

public class SlowBullet extends Bullet {

	public SlowBullet(boolean Friendly, int posx, int posy, double[] vel) {
		super(Friendly, posx, posy, vel);
	}

}
