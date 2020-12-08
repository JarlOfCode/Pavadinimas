package Proxy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import FactoryAndBuilder.BurstEnemy;

public class BurstEnemyImage implements enemyImage{
	
	String imgPath;
	int imgHeight;
	int imgWidth;
	
	BurstEnemy BE = new BurstEnemy();
	
	public BurstEnemyImage(String srcPath) {
		imgPath = srcPath;
		try {
			File imageFile = new File(imgPath);	
			BufferedImage image = ImageIO.read(imageFile );	
			imgHeight = image.getHeight();
			imgWidth = image.getWidth();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEnemyImage() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Burst enemy image " + imgPath + " is loaded");
		System.out.println("img Height:" + imgHeight + " img Width:" + imgWidth);
		BE.Spawn();
	}

}
