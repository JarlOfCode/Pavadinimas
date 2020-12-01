package CompositeAndMediator;

import FlyweightAndState.PlayingState;
import FlyweightAndState.State;
import edu.ktu.signalrclient.Player1;

public class IdleMediator implements Mediator {

	Player1 player;
	State state;
	
	
	public void setPlayer(Player1 player) {
		this.player = player;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public void changeState(State state) {
		this.state = state;
	}
	
	@Override
	public String onGetStats() {
		return "Not currently playing...";
	}

	@Override
	public String onPlay() {
		player.changeState(new PlayingState(this));
		return "Entering Play Mode...";
	}

	@Override
	public State getState() {
		return state;
	}

}
