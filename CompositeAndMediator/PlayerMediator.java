package CompositeAndMediator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import FactoryAndBuilder.Enemy;
import FlyweightAndState.Bullet;
import FlyweightAndState.IdleState;
import FlyweightAndState.PlayingShootingState;
import FlyweightAndState.PlayingState;
import FlyweightAndState.State;
import Memento.Caretaker;
import Memento.Originator;
import TemplateMethodAndIterator.EnemyRepository;
import TemplateMethodAndIterator.IIterator;
import edu.ktu.signalrclient.Player1;
import edu.ktu.signalrclient.main;

public class PlayerMediator implements Mediator {

	Player1 player;
	Caretaker ct = new Caretaker();
	State initial = new IdleState(this);
	Originator org = new Originator(initial);
	
	
	public void setPlayer(Player1 player) {
		this.player = player;
	}
	
	public void setState(State state) {
		org.setState(state);
	}
	
	@Override
	public void changeState(State state) {
		org.setState(state);
	}
	
	@Override
	public String onGetStats() throws InterruptedException {
		if(org.getState().getClass() == IdleState.class) {
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
		if(org.getState().getClass() == IdleState.class) {
			org.setState(new PlayingState(this));
			
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
	public String onShoot() {
		if(org.getState().getClass() == PlayingState.class) {
			org.setState(new PlayingShootingState(this));
			
			Shooter sh = new Shooter();
			
			sh.run();
			
			return "Shooting";
		}
		else if(org.getState().getClass() == PlayingShootingState.class) {
			return "Already shooting";
		}
		else {
			return "Idle, no shooting needed";
		}
	}

	@Override
	public State getState() {
		return org.getState();
	}

}

class Shooter implements Runnable {
	private Thread t;
	private String threadName;
	
	Shooter(){
		threadName = "shooter";
	}
	
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		State st = new PlayingState(main.player.PlayerStateMediator);
		main.player.PlayerStateMediator.changeState(st);
	}
	
	public void start () {
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	  }
}
