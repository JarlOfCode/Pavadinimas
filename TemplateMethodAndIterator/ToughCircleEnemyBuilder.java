package TemplateMethodAndIterator;

public class ToughCircleEnemyBuilder extends CircleEnemyBuilder {

	@Override
	public CircleEnemy setValue(CircleEnemy ce) {
		ce.setValue(1);
		return ce;
	}

	@Override
	public CircleEnemy setHealth(CircleEnemy ce) {
		ce.setHealth(8);
		return ce;
	}

}
