package edu.ktu.signalrclient;
import java.io.File;
import java.util.List;

public class BurstEnemy implements Enemy {

	File imageFile = new File("src/enemy_2.jpg");
	int xPos = 0;
	int yPos = 0;
	int HP = 4;
	Patterns pattern = new Burst();
	
	AbstractFactory F = new BigBulletFactory();
	List<Small_Slow_Bullet> Bullets = new List<Small_Slow_Bullet>();
	
	@Override
	public void Spawn() {
		main.chatBox.append("\nBurstEnemy Spawned");
		System.out.println("BurstEnemy Spawned");
	}
	
	@Override
	public String getEnemy(){
		return "burst";
	}
	
	
	@Override
	public File getImage() {
		return imageFile;
	}
	
	@Override
	public void setX(int x) {
		this.xPos = x;
	}
	
	@Override
	public void setY(int y) {
		this.yPos = y;
	}
	
	@Override
	public int getX() {
		return this.xPos;
	}
	
	@Override
	public int getY() {
		return this.yPos;
	}
	
	@Override
	public void isHit(Bullet bullet) {
		if(bullet.getFriendly() == false) {
			this.HP -= 1;
		}
	}

	@Override
	public void executePattern() throws InterruptedException {
		pattern.executePattern(this);	
	}

	@Override
	public void Shoot(int c_degree) {
		
	}

	@Override
	public void Shoot() {
		// TODO Auto-generated method stub
		
	}
}
