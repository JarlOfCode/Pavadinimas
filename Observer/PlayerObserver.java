package Observer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import FactoryAndBuilder.Enemy;
import edu.ktu.signalrclient.main;

public class PlayerObserver implements Observer {

	@Override
	public void update() throws IOException {
		main.render();
	}
	
	public void startConstant() {
		ConstantUpdate cu = new ConstantUpdate();
		cu.start();
	}

}

class ConstantUpdate implements Runnable {
	private Thread t;
	private String threadName = "constantUpdate";
	private BufferedImage bf;
	
	public void run() {
		while(true) {
		try {
			main.render();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void start () {
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	  }
}