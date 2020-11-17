package Testing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Observer.PlayerObserver;

public class ObserverTest {

	@Test
	public void testUpdate() throws IOException {
		PlayerObserver tempPO = new PlayerObserver();
		tempPO.update();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
