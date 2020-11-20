package TemplateMethodAndIterator;

public class ValuableCircleEnemyBuilder extends CircleEnemyBuilder {

	@Override
	public CircleEnemy setValue(CircleEnemy ce) {
		ce.setValue(3);
		return ce;
	}

	@Override
	public CircleEnemy setHealth(CircleEnemy ce) {
		ce.setHealth(4);
		return ce;
	}
}
