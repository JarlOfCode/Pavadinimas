package FactoryAndBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import AbstractFactoryAndPrototype.BigBulletFactory;
import AbstractFactoryAndPrototype.Big_Fast_Bullet;
import Strategy.Bullet;
import Strategy.Burst;
import Strategy.ContinuedFire;
import Strategy.Patterns;
import Strategy.ShootLooper;

public class ContinuedEnemy implements Enemy {

	double speed = 5;
	
	
	//super.imageFile = new File("/src/enemy_1.png");
	
	File imageFile = new File("src/Enemy_Small_2.png");
	int xPos = 0;
	int yPos = 0;
	int HP = 4;
	Patterns pattern = new ContinuedFire();
	
	BigBulletFactory F = new BigBulletFactory();
	List<Bullet> Bullets = new ArrayList<Bullet>();
	
	
	protected String configuration = "Empty String";
	
	public String getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void Spawn() throws InterruptedException {
		////GetEnemy method should be implemented
		//main.chatBox.append("\nContinuedEnemy Spawned");
		System.out.println("ContinuedEnemy Spawned");
		System.out.println("Stats: " + configuration);	
		ShootLoop();
	}
	
	@Override
	public String getEnemy(){
		return "continued";
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
		double[] a = { 0, 0 };
		Big_Fast_Bullet b = F.createFastBullet(false, getX()+65, getY()+65, a) ;
		System.out.println("ContinuedEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		Random random = new Random();
    	int ran = random.nextInt(360) + 1;
		double radians = ran*Math.PI/180.0;
		double[] bulletVelocity = { Math.cos(radians) * 7, Math.sin(radians) * 7 };
		Big_Fast_Bullet b = F.createFastBullet(false, getX()+35, getY()+35, bulletVelocity) ;
		System.out.println("Continued shot random " + b.getClass());
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


