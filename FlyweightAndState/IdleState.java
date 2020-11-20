package FlyweightAndState;

import edu.ktu.signalrclient.Player1;

public class IdleState extends State {

	IdleState(Player1 player) {
		super(player);
	}

	@Override
	public String onGetStats() {
		return "Not currently playing...";
	}

	@Override
	public String onPlay() {
		player.changeState(new PlayingState(player));
		return "Entering Play Mode...";
	}

}
