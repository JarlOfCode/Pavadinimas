package AbstractFactoryAndPrototype;

import java.util.Vector;

public class Small_Fast_Bullet extends FastBullet implements Cloneable {

	public Small_Fast_Bullet() {
		super();
	}
	
	public Small_Fast_Bullet(boolean Friendly, int posX, int posY, double[] vel) {
		super(Friendly, posX, posY, vel);
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
