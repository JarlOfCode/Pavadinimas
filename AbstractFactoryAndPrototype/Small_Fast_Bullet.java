package AbstractFactoryAndPrototype;

import java.util.Vector;

import FlyweightAndState.BulletType;

public class Small_Fast_Bullet extends FastBullet implements Cloneable {

	public Small_Fast_Bullet() {
		super();
	}
	
	public Small_Fast_Bullet(int posX, int posY, int[] vel, BulletType type) {
		super(posX, posY, vel, type);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Small_Fast_Bullet clone() {
		Small_Fast_Bullet clone = null;
		
		try {
			clone = (Small_Fast_Bullet) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clone;
	}
	
	

}
