package Proxy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ContEnemyImage implements enemyImage{
	
	String imgPath;
	int imgHeight;
	int imgWidth;
	
	public ContEnemyImage(String srcPath) {
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
	public void showEnemyImage() {
		// TODO Auto-generated method stub
		System.out.println("Cont enemy image " + imgPath + " is loaded");
		System.out.println("img Height:" + imgHeight + " img Width:" + imgWidth);
		
	} 
}
