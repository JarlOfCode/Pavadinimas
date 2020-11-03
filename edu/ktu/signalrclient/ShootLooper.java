package edu.ktu.signalrclient;

public class ShootLooper implements Runnable{

	private Thread t;
	private String threadName;
	private Enemy e;
	
	ShootLooper(Enemy E, String name) {
		threadName = name;
		e = E;
	}
	
	public void run() {
		try {
			while(true) {
				e.executePattern();
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		if(t == null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}
	
}