package CompositeAndMediator;

import FlyweightAndState.IdleState;
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
		if(state.getClass() == IdleState.class) {
		return "Not currently playing...";
		}
		else {
			return "STATS";
		}
	}

	@Override
	public String onPlay() {
		if(state.getClass() == IdleState.class) {
			changeState(new PlayingState(this));
			return "Entering Play Mode...";
		}
		else {
			return "Already Playing";
		}
	}

	@Override
	public State getState() {
		return state;
	}

}
