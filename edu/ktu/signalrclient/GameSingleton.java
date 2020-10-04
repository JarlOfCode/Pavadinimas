package edu.ktu.signalrclient;

import java.time.LocalTime;

public class GameSingleton {
	private static GameSingleton single_instance = null;
	
	private int time;
	private int score;
	private int start_time;
	
	private GameSingleton() {
		time = 0;
		score = 0;
		start_time = LocalTime.now().toSecondOfDay();
	}
	
	public static GameSingleton getInstance() {
		if(single_instance == null)
			single_instance = new GameSingleton();
		
		return single_instance;
	}
	
	public int getTime() {
		// is tikruju tures buti time updatinamas realiu laiku, ir tiesiog grazins kintamaji
		return LocalTime.now().toSecondOfDay() - start_time;
	}
	
	public int getScore() {
		return score;
	}
}
