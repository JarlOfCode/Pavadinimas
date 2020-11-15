package DecoratorAndCommand;

public abstract class Decorator implements Player {
	protected Player decoratedPlayer;
	
	int HP;
	int MaxHP;
	int Speed;
	
	public Decorator(Player decoratedPlayer) {
		this.decoratedPlayer = decoratedPlayer;
	}
}
