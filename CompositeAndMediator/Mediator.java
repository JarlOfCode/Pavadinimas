package CompositeAndMediator;

import FlyweightAndState.State;

public interface Mediator {
	public void changeState(State state);
	public String onGetStats() throws InterruptedException;
	public String onPlay();
	public State getState();
	public String onShoot();
}
