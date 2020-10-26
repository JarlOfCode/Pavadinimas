package edu.ktu.signalrclient;

import java.time.LocalTime;

public class GameSingleton {
	
	private static GameSingleton single_instance = null;
	
	private int time = 0;
	private int score = 0;
	private int start_time;
	private String notification;
	
	private GameSingleton() {
		time = 0;
		score = 0;
	}
	
	public void Start() {
		start_time = LocalTime.now().toSecondOfDay();
	}
	
	public static GameSingleton getInstance() {
		if(single_instance == null)
			single_instance = new GameSingleton();
		
		return single_instance;
	}
	
	public int getTime() {
		return LocalTime.now().toSecondOfDay() - start_time;
	}
	
	public int getScore() {
		return score;
	}
}
