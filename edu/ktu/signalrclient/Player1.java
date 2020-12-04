package edu.ktu.signalrclient;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import AbstractFactoryAndPrototype.Big_Fast_Bullet;
import AbstractFactoryAndPrototype.SmallBulletFactory;
import AbstractFactoryAndPrototype.Small_Fast_Bullet;
import CompositeAndMediator.Mediator;
import DecoratorAndCommand.Player;
import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;
import FlyweightAndState.IdleState;
import FlyweightAndState.State;
import Observer.PlayerObserver;

public class Player1 implements Player {
	private int dx;
	private int dy;
	private int Pos_X = 10;
	private int Pos_Y = 15;
	private int i_width;
	private int i_height;
	private int HP = 6;
	private int MaxHP = 3;
	private Image image;
	private int Speed = 10;
	private PlayerObserver o = new PlayerObserver();
	private boolean playing = false;
	
	SmallBulletFactory F = new SmallBulletFactory();
	List<Bullet> Bullets = new ArrayList<Bullet>();
	
	private Mediator PlayerStateMediator;
	
	public Player1(Mediator PlayerStateMediator){
		this.PlayerStateMediator = PlayerStateMediator;
		loadImage();
	}
	
	 private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon(main.getImageFiles().get(1).toString());
	        image = ii.getImage(); 
	        
	        i_width = image.getWidth(null);
	        i_height = image.getHeight(null);
	    }

	    public void move(int x, int y) throws IOException {
	        
	    	Pos_X += x;
	        Pos_Y += y;
	        //notifyObserver();
	    }
	    
	    public void startConstantObserve() {
	    	o.startConstant();
	    }

	    public int getX() {
	        
	        return Pos_X;
	    }

	    public int getY() {
	        
	        return Pos_Y;
	    }
	    
	    public int getWidth() {
	        
	        return i_width;
	    }
	    
	    public int getHeight() {
	        
	        return i_height;
	    }    

	    public Image getImage() {
	        
	        return image;
	    }
	    
	    public void changeState(State state) {
	    	PlayerStateMediator.changeState(state);
	    }
	    
	    public State getState() {
	    	return PlayerStateMediator.getState();
	    }
	    
	    public void setPlaying(boolean playing) {
	        this.playing = playing;
	    }
	    
	    public boolean isPlaying() {
	    	return playing;
	    }
	    
	    public String getStats() {
			return PlayerStateMediator.onGetStats();
	    	// mock for observer
	    }
	    
	    public void playerShoot(){
	    	//System.out.println("Player shot a bullet");
			double radians = 270*Math.PI/180.0;
			int[] bulletVelocity = { (int) (Math.cos(radians) * 7), (int) (Math.sin(radians) * 7) };
			BulletType bt = main.bt.get("highEnemy");

			Small_Fast_Bullet b = F.createFastBullet(getX()+25, getY()+25, bulletVelocity, bt, 2) ;
			Bullets.add(b);
	    }

	    public void keyPressed(KeyEvent e) throws IOException {

	        int key = e.getKeyCode();
	        //System.out.println("Key code");

	        if (key == KeyEvent.VK_A) {
	            //System.out.println("\"A\" pressed");
	            this.move(-Speed, 0);
	        }

	        if (key == KeyEvent.VK_D) {
	            //System.out.println("\"D\" pressed");
	            this.move(Speed, 0);
	        }

	        if (key == KeyEvent.VK_W) {
	            //System.out.println("\"W\" pressed");
	            this.move(0, -Speed);
	        }

	        if (key == KeyEvent.VK_S) {
	            //System.out.println("\"S\" pressed");
	            this.move(0, Speed);
	        }
	        
	        if (key == KeyEvent.VK_SPACE) {
	            //System.out.println("\"Space\" pressed");
	            this.playerShoot();
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_A) {
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_D) {
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_W) {
	            dy = 0;
	        }

	        if (key == KeyEvent.VK_S) {
	            dy = 0;
	        }
	    }
	    
		public void notifyObserver() throws IOException {
			o.update();
		}
		
		public void update() {
		}
		
		public void AddHP(int hp) {
			HP+=hp;
		}
		
		public void SetMaxHP(int hp) {
			MaxHP = hp;
		}
		
		public void SetSpeed(int sp) {
			Speed = sp;
		}
		
		public int GetHP() {
			return HP;
		}
		
		public int GetMaxHP() {
			return MaxHP;
		}
		
		public int GetSpeed() {
			return Speed;
		}
		
		public List<Bullet> getBullets(){
			return this.Bullets;
		}
		
		public void isHit(Bullet b) {
			HP -= b.getDamage();
			System.out.println("GOT HIT");
			if(HP <= 0) {
				State idleState = new IdleState(PlayerStateMediator);
				System.out.println(getStats());
				PlayerStateMediator.changeState(idleState);
				System.out.println(getStats());
			}
		}
}
