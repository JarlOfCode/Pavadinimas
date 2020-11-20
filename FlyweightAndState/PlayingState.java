package FlyweightAndState;

import edu.ktu.signalrclient.Player1;

public class PlayingState extends State {

	PlayingState(Player1 player) {
		super(player);
	}

	@Override
	public String onGetStats() {
		return player.getStats();
	}

	@Override
	public String onPlay() {
		return "Already playing...";
	}

}
