package Observer;

import java.io.IOException;

import edu.ktu.signalrclient.main;

public class BulletObserver implements Observer {

	@Override
	public void update() throws IOException {
		main.render();
	}

}
