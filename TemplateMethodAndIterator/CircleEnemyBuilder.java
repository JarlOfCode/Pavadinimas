package TemplateMethodAndIterator;

public abstract class CircleEnemyBuilder {
	
	public final CircleEnemy buildEnemy() {
		CircleEnemy ce = new CircleEnemy();
		ce = setValue(ce);
		ce = setHealth(ce);
		GetStats(ce);
		return ce;
	}
	
	public final void GetStats(CircleEnemy ce) {
		System.out.println("CircleEnemy HP: " + ce.getHP());
		System.out.println("CircleEnemy Value: " + ce.getValue());
	}
	
	public abstract CircleEnemy setValue(CircleEnemy ce);
	public abstract CircleEnemy setHealth(CircleEnemy ce);
}
