package Strategy;

import FactoryAndBuilder.Enemy;

public class ShootLooper implements Runnable{

	private Thread t;
	private String threadName;
	private Enemy e;
	
	public ShootLooper(Enemy E, String name) {
		threadName = name;
		e = E;
	}
	
	public void run() {
		try {
			while(!e.isDead) {
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