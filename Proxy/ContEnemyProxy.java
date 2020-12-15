package Proxy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import FactoryAndBuilder.Enemy;
import FlyweightAndState.Bullet;
import Visitor.InfoGiver;
import Visitor.Visitor;
import edu.ktu.signalrclient.main;

public class ContEnemyProxy implements Enemy, InfoGiver{
	
	File imageFile = main.getImageFiles().get(5);

	@Override
	public String getEnemy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Spawn() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getImage() {
		// TODO Auto-generated method stub
		if(imageFile == null) {
			System.out.println("Image does not exist");
		}
		return imageFile;
	}

	@Override
	public void setX(int X) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int Y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void executePattern() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isHit(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Shoot(int c_degree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bullet> getBullets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBullet(int u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ShootLoop() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBulletSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferedImage getBulletImage() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInfo(Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
