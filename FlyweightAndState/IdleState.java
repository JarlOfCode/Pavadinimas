package FlyweightAndState;

import CompositeAndMediator.Mediator;
import edu.ktu.signalrclient.Player1;

public class IdleState extends State {

	private Mediator PlayerStateMediator;
	
	public IdleState(Mediator PlayerStateMediator) {
		super(PlayerStateMediator);
	}

	@Override
	public String onGetStats() {
		return PlayerStateMediator.onGetStats();
	}

	@Override
	public String onPlay() {
		return PlayerStateMediator.onPlay();
	}

}
