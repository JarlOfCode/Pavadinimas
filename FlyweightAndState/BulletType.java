package FlyweightAndState;

public class BulletType {
	public int damage = 0;
	public boolean friendly = false;
	
	public BulletType(int damage, boolean friendly) {
		this.damage = damage;
		this.friendly = friendly;
	}
}