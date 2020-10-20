package edu.ktu.signalrclient;

public abstract class AbstractFactory {
	
	public abstract FastBullet createFastBullet( );
	
	public abstract SlowBullet createSlowBullet( );
	
}