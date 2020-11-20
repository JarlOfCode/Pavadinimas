package FlyweightAndState;

import edu.ktu.signalrclient.Player1;

public abstract class State {
	Player1 player;
	
	State(Player1 player){
		this.player = player;
	}
	
	public abstract String onGetStats();
	public abstract String onPlay();
}
