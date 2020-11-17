package Testing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Observer.PlayerObserver;

public class PlayerObserverTest {

	@Test
	public void testUpdate() throws IOException {
		PlayerObserver PO = new PlayerObserver();
		PO.update();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

	@Test
	public void testStartConstant() {
		PlayerObserver PO = new PlayerObserver();
		PO.startConstant();
		System.out.println("Test complete");
		//fail("Not yet implemented");
	}

}
