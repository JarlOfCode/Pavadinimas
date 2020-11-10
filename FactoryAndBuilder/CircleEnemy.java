package FactoryAndBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import AbstractFactoryAndPrototype.SmallBulletFactory;
import AbstractFactoryAndPrototype.Small_Slow_Bullet;
import Strategy.Bullet;
import Strategy.CircularBurst;
import Strategy.Patterns;
import Strategy.ShootLooper;

public class CircleEnemy implements Enemy {
	
	File imageFile = new File("src/Enemy_Big_1.png");
	int xPos = 0;
	int yPos = 0;
	int HP = 4;
	Patterns pattern = new CircularBurst();
	
	SmallBulletFactory F = new SmallBulletFactory();
	List<Bullet> Bullets = new ArrayList<Bullet>();
	
	@Override
	public void Spawn() throws InterruptedException {
		////GetEnemy method should be implemented
		//main.chatBox.append("\nCircleEnemy Spawned");
		System.out.println("CircleEnemy Spawned");
		ShootLoop();
	}
	
	@Override
	public String getEnemy(){
		return "circle";
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
		double radians = c_degree*Math.PI/180.0;
		double[] bulletVelocity = { Math.cos(radians) * 7, Math.sin(radians) * 7 };
		Small_Slow_Bullet b = F.createSlowBullet(false, getX()+55, getY()+55, bulletVelocity) ;
		System.out.println("CircleEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		double[] a = { 0, 0 };
		Small_Slow_Bullet b = F.createSlowBullet(false, getX(), getY(), a) ;
		System.out.println("SpiralEnemy shot random " + b.getClass());
		Bullets.add(b);
		
	}
	
	public List<Bullet> getBullets(){
		return this.Bullets;
	}
	
	public void ShootLoop() throws InterruptedException {
		ShootLooper sl = new ShootLooper(this, "sl1");
		sl.start();
	}

	@Override
	public void removeBullet(int u) {
		Bullets.remove(u);
	}
}