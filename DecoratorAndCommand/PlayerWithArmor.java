package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class PlayerWithArmor extends Decorator {
	//protected Player1 p;
	
	public PlayerWithArmor(Player p) {
		super(p);
	}
	
	public void Decorate(Player decoratedPlayer) {
		decoratedPlayer.SetMaxHP(5);
	}

	@Override
	public void AddHP(int hp) {
		HP += hp;
	}

	@Override
	public void SetMaxHP(int hp) {
		HP = hp;
	}

	@Override
	public void SetSpeed(int sp) {
		Speed = sp;
	}
	
	@Override
	public int GetHP() {
		return HP;
	}

	@Override
	public int GetMaxHP() {
		return MaxHP;
	}
	
	@Override
	public int GetSpeed() {
		return Speed;
	}
	
	/*public void update() {
		p.update();
	}*/
}