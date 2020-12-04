package CompositeAndMediator;

import java.awt.Graphics2D;

import FlyweightAndState.IdleState;
import FlyweightAndState.PlayingState;
import FlyweightAndState.State;
import edu.ktu.signalrclient.Player1;
import edu.ktu.signalrclient.main;

public class PlayerMediator implements Mediator {

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
	public String onGetStats() throws InterruptedException {
		if(state.getClass() == IdleState.class) {
			String score = Integer.toString(main.GS.getScore());
			String HP = Integer.toString(main.player.GetHP());
			Graphics2D g2d = (Graphics2D) main.g;
			g2d.drawString("Score: "+score, 670, 860);
			g2d.drawString("Time: "+main.currentSavedTime, 670, 880);
			g2d.drawString("HP: "+HP, 670, 900);
			
		return "Not currently playing...";
		}
		else {
			
			String score = Integer.toString(main.GS.getScore());
			if(main.isPlaying) {
				main.currentSavedTime = Integer.toString(main.GS.getTime());
				main.lastSavedTime = main.currentSavedTime;
			}
			
			String HP = Integer.toString(main.player.GetHP());
			
			Graphics2D g2d = (Graphics2D) main.g;
			g2d.drawString("Score: "+score, 670, 860);
			g2d.drawString("Time: "+main.currentSavedTime, 670, 880);
			g2d.drawString("HP: "+HP, 670, 900);
			return "STATS";
		}
	}

	@Override
	public String onPlay() {
		if(state.getClass() == IdleState.class) {
			changeState(new PlayingState(this));
			main.isPlaying = true;
			main.GS.setScore(0);
    		main.Start();
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
