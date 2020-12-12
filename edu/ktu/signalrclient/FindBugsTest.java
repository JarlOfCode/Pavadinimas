package edu.ktu.signalrclient;

public class FindBugsTest {
	public static void main(String[] args) {
		boolean infLoop = true;
		while (infLoop) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
