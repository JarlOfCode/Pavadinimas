package DecoratorAndCommand;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

public interface Player {
	/*void move(int x, int y) throws IOException;
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	Image getImage();
	void playerShoot();
	void keyPressed(KeyEvent e) throws IOException;
	void keyReleased(KeyEvent e);
	void notifyObserver() throws IOException;
	void update();
	void AddHP(int hp);
	void SetMaxHP(int hp);
	void SetSpeed(int sp);*/
	
	void AddHP(int hp);
	void SetMaxHP(int hp);
	void SetSpeed(int sp);
}
