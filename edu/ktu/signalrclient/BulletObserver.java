package edu.ktu.signalrclient;

import java.io.IOException;

public class BulletObserver implements Observer {

	@Override
	public void update() throws IOException {
		main.render();
	}

}
