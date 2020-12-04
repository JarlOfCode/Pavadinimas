package TemplateMethodAndIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;

import AbstractFactoryAndPrototype.SmallBulletFactory;
import AbstractFactoryAndPrototype.Small_Slow_Bullet;
import FactoryAndBuilder.Enemy;
import FactoryAndBuilder.EnemyKiller;
import FlyweightAndState.Bullet;
import FlyweightAndState.BulletType;
import Strategy.CircularBurst;
import Strategy.Patterns;
import Strategy.ShootLooper;
import edu.ktu.signalrclient.main;

public class CircleEnemy implements Enemy {
	
	File imageFile = main.getImageFiles().get(2);
	int xPos = 0;
	int yPos = 0;
	int HP = 4;
	int Value = 1;
	Patterns pattern = new CircularBurst();
	boolean isDead = false;
	
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
		double radians = c_degree*Math.PI/180.0;
		int[] bulletVelocity = { (int) (Math.cos(radians) * 7), (int) (Math.sin(radians) * 7) };
		BulletType bt = main.bt.get("highEnemy");

		Small_Slow_Bullet b = F.createSlowBullet(getX()+55, getY()+55, bulletVelocity, bt, 1) ;
		//System.out.println("CircleEnemy shot " + b.getClass() + " at " + c_degree + " degrees");
		Bullets.add(b);
	}

	@Override
	public void Shoot() {
		// METODAS KURIS NUKREIPIA KULKA RANDOM KRYPTIM
		int[] a = { 0, 0 };
		BulletType bt = main.bt.get("highEnemy");

		Small_Slow_Bullet b = F.createSlowBullet(getX(), getY(), a, bt, 1) ;
		//System.out.println("SpiralEnemy shot random " + b.getClass());
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
	
	public void setValue(int v) {
		this.Value = v;
	}
	
	public void setHealth(int h) {
		this.HP = h;
	}
	
	public int getValue() {
		return this.Value;
	}
	
	public int getHP() {
		return this.HP;
	}
	
	@Override
	public int getSize() {
		return 65;
	}

	@Override
	public int getBulletSize() {
		return 10;
	}
	
	@Override
	public BufferedImage getBulletImage() throws IOException {
		return ImageIO.read(main.getImageFiles().get(7));
	}
}
