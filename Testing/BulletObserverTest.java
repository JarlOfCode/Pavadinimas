package Testing;

import static org.junit.Assert.*;
import edu.ktu.signalrclient.*;
import java.io.IOException;
import org.junit.Test;
import Observer.Observer;
import Observer.BulletObserver;

public class BulletObserverTest {
	

	@Test
	public void testUpdate() throws IOException {
		Observer bulletObserver = new BulletObserver();
		main mainDummy = new main();
		try {
			bulletObserver.update();
			System.out.println("Gerai");
		}catch(IOException ex){
			System.out.println("Blogai");
			throw ex;
		}		
	}
}
