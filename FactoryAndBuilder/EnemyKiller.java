package FactoryAndBuilder;

import edu.ktu.signalrclient.main;

public class EnemyKiller  implements Runnable{

		private Thread t;
		private String threadName;
		private Enemy e;
		int index;
		
		public EnemyKiller(Enemy E, String name, int index) {
			threadName = name;
			e = E;
			this.index = index;
		}
		
		public void run() {
			try {
				
				Thread.sleep(2000);
				main.enemies.removeEnemy(index);
				
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

