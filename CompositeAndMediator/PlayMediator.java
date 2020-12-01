package CompositeAndMediator;

import FlyweightAndState.PlayingState;
import FlyweightAndState.State;
import edu.ktu.signalrclient.Player1;

public class PlayMediator implements Mediator {

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
		return player.getStats();
	}

	@Override
	public String onPlay() {
		return "Already playing...";
	}

	@Override
	public State getState() {
		return state;
	}
}
