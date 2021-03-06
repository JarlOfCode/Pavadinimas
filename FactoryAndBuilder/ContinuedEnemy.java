package FactoryAndBuilder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import AbstractFactoryAndPrototype.BigBulletFactory;
import AbstractFactoryAndPrototype.Big_Fast_Bullet;
import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;
import Strategy.Burst;
import Strategy.ContinuedFire;
import Strategy.Patterns;
import Strategy.ShootLooper;
import Visitor.InfoGiver;
import Visitor.Visitor;
import edu.ktu.signalrclient.main;

public class ContinuedEnemy implements Enemy, InfoGiver {

	double speed = 5;
	
	File imageFile = main.getImageFiles().get(5);
	int xPos = 0;
	int yPos = 0;
	public int HP = 4;
	int Value = 2;
	Patterns pattern = new ContinuedFire();
	boolean isDead = false;
	
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
	public String getImagePath() {
		return imageFile.getPath();
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
	public void isHit(int index) {
		this.HP -= 1;
		
		if(this.HP == 0) {
			this.isDead = true;
			/*EnemyKiller ek = new EnemyKiller(this, "ek1", index);
			ek.start();*/
			main.enemies.removeEnemy(index);
			main.GS.addScore(Value);
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
		Big_Fast_Bullet b = F.createFastBullet(getX()+65, getY()+65, a, bt, 2) ;
		//System.out.println("ContinuedEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		Random random = new Random();
    	int ran = random.nextInt(360) + 1;
		double radians = ran*Math.PI/180.0;
		int[] bulletVelocity = { (int) (Math.cos(radians) * 7), (int) (Math.sin(radians) * 7) };
		BulletType bt = main.bt.get("lowEnemy");
		Big_Fast_Bullet b = F.createFastBullet(getX()+35, getY()+35, bulletVelocity, bt, 2) ;
		//System.out.println("Continued shot random " + b.getClass());
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
	
	@Override
	public int getSize() {
		return 35;
	}

	@Override
	public int getBulletSize() {
		return 20;
	}
	
	@Override
	public BufferedImage getBulletImage() throws IOException {
		return ImageIO.read(main.getImageFiles().get(6));
	}

	@Override
	public String getInfo(Visitor visitor) {
		return visitor.getInfo(this);
	}
}


