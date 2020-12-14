package FactoryAndBuilder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import FlyweightAndState.Bullet;

public abstract interface Enemy {
File imageFile = null;
	
	String getEnemy();
	void Spawn() throws InterruptedException;
	File getImage();
	void setX(int X);
	void setY(int Y);
	int getX();
	int getY();
	int HP = 0;
	int Value = 0;
	boolean isDead = false;
	
	void executePattern() throws InterruptedException;
	void isHit(int index);
	void Shoot(int c_degree);
	void Shoot();
	List<Bullet> getBullets();
	void removeBullet(int u);
	void ShootLoop() throws InterruptedException;
	int getSize();
	int getBulletSize();
	BufferedImage getBulletImage() throws IOException;
	String getImagePath();
}
