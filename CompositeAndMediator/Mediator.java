package CompositeAndMediator;

import FlyweightAndState.State;

public interface Mediator {
	public void changeState(State state);
	public String onGetStats();
	public String onPlay();
	public State getState();
}
