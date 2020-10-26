package edu.ktu.signalrclient;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player1 {
	private int dx;
	private int dy;
	private int Pos_X = 10;
	private int Pos_Y = 15;
	private int i_width;
	private int i_heigt;
	private int HP = 100;
	private int Move_Speed;
	private Image image;
	
	public Player1(){
		loadImage();
	}
	
	 private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon("src/player.png");
	        image = ii.getImage(); 
	        
	        i_width = image.getWidth(null);
	        i_heigt = image.getHeight(null);
	    }

	    public void move() {
	        
	    	Pos_X += dx;
	        Pos_Y += dy;
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
	        
	        return i_heigt;
	    }    

	    public Image getImage() {
	        
	        return image;
	    }

	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_A) {
	            dx = -1;
	        }

	        if (key == KeyEvent.VK_D) {
	            dx = 1;
	        }

	        if (key == KeyEvent.VK_W) {
	            dy = 1;
	        }

	        if (key == KeyEvent.VK_S) {
	            dy = -1;
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
}
