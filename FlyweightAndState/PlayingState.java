package FlyweightAndState;

import CompositeAndMediator.Mediator;
import edu.ktu.signalrclient.Player1;

public class PlayingState extends State {

	private Mediator PlayerStateMediator;
	
	public PlayingState(Mediator PlayerStateMediator) {
		super(PlayerStateMediator);
	}

	@Override
	public String onGetStats() throws InterruptedException {
		return PlayerStateMediator.onGetStats();
	}

	@Override
	public String onPlay() {
		return PlayerStateMediator.onPlay();
	}
	
	@Override
	public String onShoot() {
		return PlayerStateMediator.onShoot();
	}


}
