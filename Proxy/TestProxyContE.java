package Proxy;

import java.awt.Image;

public class TestProxyContE {
	public static void main(String[] args) throws InterruptedException {
		String path = "src/Enemy_Small_2.png";
		
		System.out.println("\n=== Proxy Cont Enemy Image ===");
		enemyImage e1 = new enemyImageProxy(path);
		e1.showEnemyImage();
		
		System.out.println("\n=== Real Cont Enemy Image ===");
		enemyImage re1 = new ContEnemyImage(path);
		re1.showEnemyImage();
		
	}
}
