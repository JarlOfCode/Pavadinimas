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
		//visada failins, nes reikia main objekto, konkreciai render klases, kuria naudoja bulletObeserver
		Observer bulletObserver = new BulletObserver();
		main mainDummy = new main();
		//Renderer r = new Renderer();
		//mainDummy.r = r;
		
		try {
			bulletObserver.update();
			System.out.println("Gerai");
		}catch(IOException ex){
			System.out.println("Blogai");
			throw ex;
		}
		
	}

}
