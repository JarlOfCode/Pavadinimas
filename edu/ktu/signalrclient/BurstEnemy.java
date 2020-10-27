package edu.ktu.signalrclient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BurstEnemy implements Enemy {

	File imageFile = new File("src/enemy_2.jpg");
	int xPos = 0;
	int yPos = 0;
	int HP = 4;
	Patterns pattern = new Burst();
	
	SmallBulletFactory F = new SmallBulletFactory();
	List<Bullet> Bullets = new ArrayList<Bullet>();
	
	@Override
	public void Spawn() throws InterruptedException {
		//main.chatBox.append("\nBurstEnemy Spawned");
		System.out.println("BurstEnemy Spawned");
		ShootLoop();
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
		// METODAS KURIS APSKAICIUOJA KULKOS KAMPA
		float a = 0;
		Small_Fast_Bullet b = F.createFastBullet(false, getX(), getY(), a, a) ;
		System.out.println("BurstEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		float a = 0;
		Small_Fast_Bullet b = F.createFastBullet(false, getX(), getY(), a, a) ;
		System.out.println("SpiralEnemy shot random " + b.getClass());
		Bullets.add(b);
		
	}
	
	public List<Bullet> getBullets(){
		return this.Bullets;
	}
	
	public void ShootLoop() throws InterruptedException {
		executePattern();
		Thread.sleep(5000);
	}
}
