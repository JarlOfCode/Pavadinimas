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
			int i = 0;
			while(i <3) {
				e.executePattern();
				Thread.sleep(5000);
				i++;
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