package Proxy;

import java.awt.Image;

public class enemyImageProxy implements enemyImage{
	enemyImage eImg = null;
	
	String ePath;
	enemyImage eProxy;
	
	public enemyImageProxy(String imgPath) {
		ePath = imgPath;
	}

	public enemyImageProxy(enemyImage otherProxy) {
		eProxy = otherProxy;
	}

	@Override
	public void showEnemyImage() {
		if(eProxy == null) {
			if(eImg == null) {
				eImg = new ContEnemyImage(ePath);
			}
			eImg.showEnemyImage();
		}else {
			// custom action + 
			eProxy.showEnemyImage();
		}
		
	}

	
}