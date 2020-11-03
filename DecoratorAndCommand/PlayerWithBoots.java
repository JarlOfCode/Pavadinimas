package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class PlayerWithBoots extends Decorator {
	protected Player1 p;
	
	public PlayerWithBoots(Player p) {
		super(p);
	}
	
	public void Decorate(Player decoratedPlayer) {
		decoratedPlayer.SetSpeed(7);
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
		Move_Speed = sp;
	}
	
	/*public void update() {
		p.update();
	}*/
}