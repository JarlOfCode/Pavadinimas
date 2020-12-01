package FlyweightAndState;

import CompositeAndMediator.Mediator;
import edu.ktu.signalrclient.Player1;

public abstract class State {
	
	private Mediator PlayerStateMediator;
	
	State(Mediator PlayerStateMediator) {
		this.PlayerStateMediator = PlayerStateMediator;
	}
	
	public abstract String onGetStats();
	public abstract String onPlay();
}
