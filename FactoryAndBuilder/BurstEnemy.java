package FactoryAndBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import AbstractFactoryAndPrototype.Big_Fast_Bullet;
import AbstractFactoryAndPrototype.SmallBulletFactory;
import AbstractFactoryAndPrototype.Small_Fast_Bullet;
import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;
import Strategy.Burst;
import Strategy.Patterns;
import Strategy.ShootLooper;
import edu.ktu.signalrclient.main;

public class BurstEnemy implements Enemy {

	File imageFile = new File("src/Enemy_Small_1.png");
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
		int[] a = { 0, 0 };
		BulletType bt = main.bt.get("lowEnemy");
		Small_Fast_Bullet b = F.createFastBullet(getX()+35, getY()+35, a, bt) ;
		System.out.println("BurstEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		Random random = new Random();
    	int ran = random.nextInt(360) + 1;
		double radians = ran*Math.PI/180.0;
		int[] bulletVelocity = { (int) (Math.cos(radians) * 7), (int) (Math.sin(radians) * 7) };
		BulletType bt = new BulletType(1, false);
		Small_Fast_Bullet b = F.createFastBullet(getX()+35, getY()+35, bulletVelocity, bt) ;
		System.out.println("BurstEnemy shot random " + b.getClass());
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


