package FactoryAndBuilder;

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
	
	void executePattern() throws InterruptedException;
	void isHit(Bullet bullet);
	void Shoot(int c_degree);
	void Shoot();
	List<Bullet> getBullets();
	void removeBullet(int u);
	void ShootLoop() throws InterruptedException;
}
